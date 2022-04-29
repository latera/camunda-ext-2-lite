package com.hydra_billing.camunda.api.hydra.hid

import com.hydra_billing.camunda.Logger.*
import org.apache.xmlrpc.client.XmlRpcClient
import java.lang.ClassCastException
import java.math.BigDecimal
import kotlin.reflect.KClass

class Hid(val client: XmlRpcClient) {
    companion object : Logged {
        val logger = getLogger()
    }

    inline fun <reified T : Any> select(request: String, dataType: KClass<T>): Array<T> {
        val params = arrayOf<String>(request)
        val constructor = dataType.constructors.first()
        val constructorParams = constructor.parameters

        logger.info("Select request started")
        val hidObject = client.execute("SELECT", params) as Map<*, *>
        logger.info("Select request finished")

        val result = mutableListOf<T>()
        for (obj in hidObject["SelectResult"] as Array<*>) {
            val row = obj as Array<Any?>
            val args =
                constructorParams.mapIndexed { index, param ->
                    val realIndex = index + 1
                    if (row[realIndex] == null) {
                        null
                    } else {
                        when (param.type.toString()) {
                            "kotlin.String", "kotlin.String?" -> row[realIndex]
                            "kotlin.Long", "kotlin.Long?" -> row[realIndex].toString().toLong()
                            "kotlin.Boolean" -> toBoolean(row[realIndex])
                            "kotlin.Boolean?" -> toNullableBoolean(row[realIndex])
                            "java.math.BigDecimal?", "java.math.BigDecimal" ->
                                BigDecimal(row[realIndex].toString().replace(",", "."))
                            else -> throw ClassCastException()
                        }
                    }
                }

            result.add(constructor.call(*args.toTypedArray()))
        }

        return result.toTypedArray()
    }

    fun toBoolean(flag: Any?): Boolean {
        return when (flag) {
            "Y" -> true
            "N" -> false
            else -> throw ClassCastException()
        }
    }

    fun toNullableBoolean(flag: Any?): Boolean? {
        return when (flag) {
            "Y" -> true
            "N" -> false
            null -> null
            else -> throw ClassCastException()
        }
    }
}
