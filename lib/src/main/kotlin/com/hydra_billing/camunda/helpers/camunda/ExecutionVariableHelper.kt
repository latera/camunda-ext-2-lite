package com.hydra_billing.camunda.helpers.camunda

import com.google.gson.GsonBuilder
import com.google.gson.JsonParseException
import com.google.gson.JsonSyntaxException
import com.hydra_billing.camunda.exceptions.CantCastVariable
import com.hydra_billing.camunda.exceptions.EmptyExecutionVariable
import com.hydra_billing.camunda.exceptions.NoSuchConstant
import com.hydra_billing.camunda.exceptions.WrongNumberFormat
import com.hydra_billing.camunda.http_clients.NullableTypeAdapterFactory
import org.camunda.bpm.engine.delegate.DelegateExecution
import java.math.BigDecimal
import kotlin.reflect.KProperty1

fun getString(execution: DelegateExecution, variable: String): String {
    try {
        return execution.getVariable(variable).toString()
    } catch (e: NullPointerException) {
        throw EmptyExecutionVariable("Variable $variable is empty")
    }
}

fun getNullableString(execution: DelegateExecution, variable: String): String? {
    return execution.getVariable(variable)?.toString()
}

fun getLong(execution: DelegateExecution, variable: String): Long {
    try {
        return getString(execution, variable).toLong()
    } catch (e: NumberFormatException) {
        throw WrongNumberFormat("Variable $variable(${execution.getVariable(variable)}) cant be converted to long")
    }
}

fun getNullableLong(execution: DelegateExecution, variable: String): Long? {
    try {
        return getNullableString(execution, variable)?.toLong()
    } catch (e: NumberFormatException) {
        throw WrongNumberFormat("Variable $variable(${execution.getVariable(variable)}) cant be converted to long")
    }
}

inline fun <reified T : Enum<T>> getHydraConstant(execution: DelegateExecution, variable: String): T {
    val enumValue = getLong(execution, variable)
    try {
        return enumValues<T>().first {
            val property = it::class.members.first { it.name == "value" } as KProperty1<Any, *>
            property.get(it) as Long == enumValue
        }
    } catch (e: NoSuchElementException) {
        throw NoSuchConstant("${T::class} contains no element with value $enumValue")
    }
}

inline fun <reified T : Enum<T>> getNullableHydraConstant(execution: DelegateExecution, variable: String): T? {
    val enumValue = getNullableLong(execution, variable)
    try {
        return if (enumValue == null) {
            null
        } else {
            enumValues<T>().first {
                val property = it::class.members.first { it.name == "value" } as KProperty1<Any, *>
                property.get(it) as Long == enumValue
            }
        }
    } catch (e: NoSuchElementException) {
        throw NoSuchConstant("${T::class} contains no element with value $enumValue")
    }
}

inline fun <reified T> getVariableAs(execution: DelegateExecution, variable: String): T {
    try {
        return execution.getVariable(variable) as T
    } catch (e: ClassCastException) {
        throw CantCastVariable("Variable $variable cant be cast to ${T::class}")
    } catch (e: NullPointerException) {
        throw EmptyExecutionVariable("Variable $variable is empty")
    }
}

fun getBigDecimal(execution: DelegateExecution, variable: String): BigDecimal {
    try {
        return getString(execution, variable).toBigDecimal()
    } catch (e: NumberFormatException) {
        throw WrongNumberFormat("Variable $variable(${execution.getVariable(variable)}) cant be converted to BigDecimal")
    }
}

fun getNullableBigDecimal(execution: DelegateExecution, variable: String): BigDecimal? {
    try {
        return getNullableString(execution, variable)?.toBigDecimal()
    } catch (e: NumberFormatException) {
        throw WrongNumberFormat("Variable $variable(${execution.getVariable(variable)}) cant be converted to BigDecimal")
    }
}

inline fun <reified T> getJson(execution: DelegateExecution, variable: String): T {
    try {
        val gson = GsonBuilder().registerTypeAdapterFactory(NullableTypeAdapterFactory()).create()
        return gson.fromJson(getString(execution, variable), T::class.java)
    } catch (e: JsonParseException) {
        throw throw CantCastVariable("Variable $variable cant be cast to ${T::class}")
    } catch (e: JsonSyntaxException) {
        throw throw CantCastVariable("Variable $variable cant be cast to ${T::class}")
    }
}
