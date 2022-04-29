package com.hydra_billing.camunda.http_clients.mock_clients.imprint

import com.hydra_billing.camunda.http_clients.NullableTypeAdapterFactory
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.http.*

object ImprintMockClient {
    fun getClient(): HttpClient {
        return HttpClient(MockEngine) {
            engine {
                addHandler { request ->
                    when (request.url.fullPath) {
                        "/api/print" -> {
                            val responseHeaders = headersOf(
                                "Content-Disposition" to listOf("attachment; filename*=UTF-8''simple_plain_text.txt"),
                                "Content-Type" to listOf(ContentType.Text.Plain.toString())
                            )
                            respond(
                                """test Template data.""".trimIndent(),
                                headers = responseHeaders
                            )
                        }
                        else -> {
                            val responseHeaders = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond("Not Found", headers = responseHeaders)
                        }
                    }
                }
            }

            install(JsonFeature) {
                serializer =
                    GsonSerializer {
                        disableHtmlEscaping()
                        registerTypeAdapterFactory(NullableTypeAdapterFactory())
                    }
            }

            defaultRequest {
                host = "localhost"
                port = 3000
                header("Accept", "application/json")
                header("Content-Type", "application/json")
            }
        }
    }
}
