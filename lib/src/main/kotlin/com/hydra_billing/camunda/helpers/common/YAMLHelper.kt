package com.hydra_billing.camunda.helpers.common

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import java.io.FileReader

object YAMLHelper {
    val yamlMapper by lazy { ObjectMapper(YAMLFactory()).registerKotlinModule() }

    inline fun <reified T : Any> convertYAMLToDataClass(yaml: String): T {
        return YAMLHelper.yamlMapper.readValue(yaml, T::class.java)
    }

    inline fun <reified T : Any> convertDataClassToYAML(obj: T): String {
        return YAMLHelper.yamlMapper.writeValueAsString(T::class.java)
    }

    inline fun <reified T : Any> convertYAMLFileToDataClass(fileName: String): T {
        FileReader(fileName).use { reader ->
            return YAMLHelper.yamlMapper.readValue(reader, T::class.java)
        }
    }
}
