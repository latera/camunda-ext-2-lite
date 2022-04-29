package com.hydra_billing.camunda.helpers.common

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.hydra_billing.camunda.http_clients.NullableTypeAdapterFactory

object DataClassHelper {
    val gson = GsonBuilder().registerTypeAdapterFactory(NullableTypeAdapterFactory()).create()

    inline fun <reified T : Any> convertDataClassToMap(obj: T): Map<String, Any?> {
        val json = gson.toJson(obj)
        return gson.fromJson(json, object : TypeToken<Map<String, Any?>>() {}.type)
    }

    inline fun <reified T : Any> convertMapToDataClass(map: Map<String, Any?>): T {
        val json = gson.toJson(map)
        return gson.fromJson(json, object : TypeToken<T>() {}.type)
    }

    inline fun <reified T : Any> convertArrayOfDataClassToArrayOfMap(array: Array<T>): Array<Map<String, Any?>> {
        val json = gson.toJson(array)
        return gson.fromJson(json, object : TypeToken<Array<Map<String, Any?>>>() {}.type)
    }

    inline fun <reified T : Any> convertArrayOfMapToArrayOfDataClass(array: Array<Map<String, Any?>>): Array<T> {
        val json = gson.toJson(array)
        return gson.fromJson(json, object : TypeToken<Array<T>>() {}.type)
    }
}
