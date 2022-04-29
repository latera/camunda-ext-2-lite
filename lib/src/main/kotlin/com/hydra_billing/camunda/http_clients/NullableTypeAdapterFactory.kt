package com.hydra_billing.camunda.http_clients

import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import kotlin.jvm.internal.Reflection
import kotlin.reflect.KClass
import kotlin.reflect.full.memberProperties

class NullableTypeAdapterFactory : TypeAdapterFactory {

    override fun <T : Any> create(gson: Gson, type: TypeToken<T>): TypeAdapter<T>? {
        val delegate = gson.getDelegateAdapter(this, type)

        // only for kotlin types
        if (type.rawType.declaredAnnotations.none {
            it.annotationClass.qualifiedName == "kotlin.Metadata"
        }
        ) {
            return null
        }

        if (type.rawType.superclass.toString() == "class java.lang.Enum") {
            return object : TypeAdapter<T>() {
                override fun write(out: JsonWriter, value: T?) = delegate.write(out, value)

                override fun read(input: JsonReader): T? {
                    input.peek()
                    val value = input.nextString()
                    // search json token in enum
                    val kotlinClass: KClass<Any> = Reflection.createKotlinClass(type.rawType)
                    val enumValuesMethod = kotlinClass.java.getMethod("values")
                    val enumValues: Array<Any> = enumValuesMethod.invoke(kotlinClass) as Array<Any>
                    val simpleEnumValues =
                        enumValues.map { it.javaClass.getMethod("getValue").invoke(it).toString() }

                    if (!simpleEnumValues.contains(value)) {
                        throw JsonParseException(
                            "Value $value not included in the original type [${type.rawType}]"
                        )
                    }
                    val res =
                        enumValues.find { it.javaClass.getMethod("getValue").invoke(it).toString() == value }

                    return res as T?
                }
            }
        } else {
            return object : TypeAdapter<T>() {
                override fun write(out: JsonWriter, value: T?) = delegate.write(out, value)

                override fun read(input: JsonReader): T? {
                    val value: T? = delegate.read(input)

                    if (value != null) {
                        val kotlinClass: KClass<Any> = Reflection.createKotlinClass(type.rawType)
                        // search not null properties with null value
                        kotlinClass.memberProperties.forEach {
                            if (!it.returnType.isMarkedNullable && it.get(value) == null) {
                                throw JsonParseException("Value of non-nullable member [${it.name}] cannot be null")
                            }
                        }
                    }

                    return value
                }
            }
        }
    }
}
