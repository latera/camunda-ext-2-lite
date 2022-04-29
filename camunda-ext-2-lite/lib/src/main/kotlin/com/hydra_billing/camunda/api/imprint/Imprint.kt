package com.hydra_billing.camunda.api.imprint

import com.hydra_billing.camunda.exceptions.ImprintResponseException
import io.ktor.client.HttpClient
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.*
import java.util.*
import javax.mail.internet.ContentDisposition

class Imprint(val client: HttpClient) {
    data class File(
        val base64string: String,
        val filename: String,
    )

    data class Options(
        val convert_to_pdf: Boolean
    )

    fun <T> print(templateName: String, data: T, convertToPdf: Boolean): File {
        val client = this.client

        return runBlocking {
            val response = client.post<HttpResponse> {
                url { encodedPath = "/api/print" }

                body = mapOf(
                    "template" to templateName,
                    "data" to data,
                    "options" to Options(convertToPdf)
                )
            }

            if (response.headers["Content-Type"] == ContentType.Application.Json.toString()) {
                throw ImprintResponseException(response.receive())
            }

            File(
                base64string = Base64.getEncoder().encodeToString(response.receive()),
                filename = ContentDisposition(response.headers["Content-Disposition"]).getParameter("filename")
            )
        }
    }
}
