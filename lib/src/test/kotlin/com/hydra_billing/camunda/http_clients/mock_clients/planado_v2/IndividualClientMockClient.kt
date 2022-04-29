package com.hydra_billing.camunda.http_clients.mock_clients.planado_v2

import com.hydra_billing.camunda.http_clients.NullableTypeAdapterFactory
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.features.*
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.*
import io.ktor.http.*

object IndividualClientMockClient {
    fun getClient(): HttpClient {
        val initialPath = "/v2/clients"
        return HttpClient(MockEngine) {
            engine {
                addHandler { request ->
                    when {
                        // Create individual client
                        request.method == HttpMethod.Post &&
                            request.url.fullPath == "$initialPath" -> {

                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                                  "client_uuid": "137ecf60-06cd-6930-bd93-46513db41965"
                                }""",
                                headers = responseHeaders
                            )
                        }
                        // Get individual client
                        request.method == HttpMethod.Get &&
                            request.url.fullPath ==
                            "$initialPath/b2584e3c-25dd-4773-ab8b-0a018fd58d2b" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                                  "client": {
                                    "uuid": "b2584e3c-25dd-4773-ab8b-0a018fd58d2b",
                                    "external_id": "22451458596510-john-doe-the-second",
                                    "name": "John Doe the Second",
                                    "organization": false,
                                    "first_name": "John",
                                    "last_name": "Doe",
                                    "middle_name": "the second",
                                    "site_address": {
                                      "formatted": "VFWH+25 Rome, Metropolitan City of Rome, Italy",
                                      "entrance_no": "3",
                                      "apartment": "11",
                                      "floor": "2",
                                      "description": "Knock hard",
                                      "geolocation": {
                                        "longitude": 12.4772501,
                                        "latitude": 41.8950619
                                      }
                                    },
                                    "contacts": [
                                      {
                                        "name": "John",
                                        "value": "(923) 820-5063",
                                        "type": "phone"
                                      }
                                    ],
                                    "version": 3,
                                    "created_at": "2016-05-29T17:31:01.419601Z",
                                    "updated_at": "2016-06-07T10:57:19.529209Z"
                                  }
                                }""",
                                headers = responseHeaders
                            )
                        }
                        // Update individual client
                        request.method == HttpMethod.Patch &&
                            request.url.fullPath ==
                            "$initialPath/137ed01f-39ef-6960-bd93-46513db41965" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                                  "client_uuid": "137ed01f-39ef-6960-bd93-46513db41965"
                                }""",
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
