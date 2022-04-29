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

object OrganizationClientMockClient {
    fun getClient(): HttpClient {
        val initialPath = "/v2/clients"
        return HttpClient(MockEngine) {
            engine {
                addHandler { request ->
                    when {
                        // Create organization client
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
                        // Get organization client
                        request.method == HttpMethod.Get &&
                            request.url.fullPath ==
                            "$initialPath/50c773b3-a4f8-5619-be47-cb6a0edb22cc" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                                  "client": {
                                    "uuid": "50c773b3-a4f8-5619-be47-cb6a0edb22cc",
                                    "external_id": "423430387320568-acme",
                                    "name": "ACME Corporation",
                                    "organization": true,
                                    "organization_name": "ACME Corporation",
                                    "site_address": {
                                      "formatted": "Passeig de Gràcia, 92, 08008 Barcelona, Spain",
                                      "entrance_no": "1",
                                      "apartment": null,
                                      "floor": "1",
                                      "description": "Entrance via Carrer de Procença",
                                      "geolocation": {
                                        "longitude": 37.6785237278356,
                                        "latitude": 55.7862807707096
                                      }
                                    },
                                    "contacts": [
                                      {
                                        "name": "Pedro",
                                        "value": "(834) 362-5246",
                                        "type": "phone"
                                      }
                                    ],
                                    "version": 1
                                  }
                                }""",
                                headers = responseHeaders
                            )
                        }
                        // Update organization client
                        request.method == HttpMethod.Patch &&
                            request.url.fullPath ==
                            "$initialPath/50c773b3-a4f8-5619-be47-cb6a0edb22cc" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                                  "client_uuid": "50c773b3-a4f8-5619-be47-cb6a0edb22cc"
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
