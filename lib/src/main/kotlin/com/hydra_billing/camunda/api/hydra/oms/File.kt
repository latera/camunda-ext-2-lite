package com.hydra_billing.camunda.api.hydra.oms

import com.google.gson.GsonBuilder
import com.hydra_billing.camunda.Logger.*
import com.hydra_billing.camunda.http_clients.NullableTypeAdapterFactory
import io.ktor.client.HttpClient
import io.ktor.client.request.*
import kotlinx.coroutines.*

class File(val client: HttpClient) {
    companion object : Logged {
        val logger = getLogger()
    }

    data class FileParams(
        val name: String,
        val content: String,
        val fieldName: String? = null
    )

    data class File(
        val url: String,
        val name: String,
        val origin_name: String,
        val real_name: String,
        val field_name: String?,
        val upload_time: String,
        val end_point: String,
        val bucket: String
    )

    data class Response(
        val files: Array<File>
    )

    fun upload(files: Array<FileParams>): Array<File> {
        val client = this.client

        val gson = GsonBuilder().registerTypeAdapterFactory(NullableTypeAdapterFactory()).create()

        logger.info("Upload files to minio")

        return runBlocking {
            client.post<Array<File>> {
                url { encodedPath = "/widget/files/upload" }
                body = mapOf("files" to gson.toJson(files))
            }
        }
    }
}
