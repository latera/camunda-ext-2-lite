package com.hydra_billing.camunda.http_clients.mock_clients.hydra.oms

import com.hydra_billing.camunda.http_clients.NullableTypeAdapterFactory
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.features.*
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.*
import io.ktor.http.*

object FileMockClient {
    fun getClient(): HttpClient {
        return HttpClient(MockEngine) {
            engine {
                addHandler { request ->
                    when (request.url.fullPath) {
                        "/widget/files/upload" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """
                                    [
                                        {
                                            "url": "http://127.0.0.1:9000/bucket-name/1644743191779_test.txt",
                                            "name": "test.txt (13.02.2022 09:04:01)",
                                            "origin_name": "test.txt",
                                            "real_name": "1644743191779_test.txt",
                                            "field_name": null,
                                            "upload_time": "2022-02-13T09:04:01+00:00",
                                            "end_point": "http://127.0.0.1:9000",
                                            "bucket": "bucket-name"
                                        }
                                    ]
                                """.trimIndent(),
                                headers = responseHeaders
                            )
                        }

                        else -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Text.Plain.toString()))
                            respond("Wrong request", headers = responseHeaders)
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
