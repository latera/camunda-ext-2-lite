package com.hydra_billing.camunda.http_clients.mock_clients.hydra.rest.v2

import com.hydra_billing.camunda.http_clients.NullableTypeAdapterFactory
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.features.*
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.*
import io.ktor.http.*

object DocumentAttachmentMockClient {
    fun getClient(): HttpClient {
        return HttpClient(MockEngine) {
            engine {
                addHandler { request ->
                    when (request.url.fullPath) {
                        "/rest/v2/documents/94077301/files" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                                  "file": {
                                    "n_doc_file_id": 99951101,
                                    "extension": "txt",
                                    "base64_content": "IWRscm93ICxvbGxlSA==",
                                    "file_name": "hello_world.txt",
                                    "name": "hello_world.txt"
                                  }
                                }""",
                                headers = responseHeaders
                            )
                        }
                        "/rest/v2/documents/94077301/files?page=1&per_page=1000" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                                      "files": [
                                        {
                                          "n_doc_file_id": 99952101,
                                          "extension": "txt",
                                          "base64_content": "SGVsbG8sIHdvcmxkIQ==",
                                          "file_name": "hello_world.txt",
                                          "name": "hello_world.txt"
                                        }
                                      ]
                                    }
                                """.trimIndent(),
                                headers = responseHeaders
                            )
                        }
                        "/rest/v2/documents/94077301/files/99952301" -> {
                            respond("", HttpStatusCode.NoContent)
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
