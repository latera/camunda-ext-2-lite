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

object CatalogItemMockClient {
    fun getClient(): HttpClient {
        return HttpClient(MockEngine) {
            engine {
                addHandler { request ->
                    when (request.url.fullPath) {
                        "/rest/v2/catalog/40213401" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                                  "catalog": {
                                    "n_good_group_id": 2039,
                                    "n_unit_id": 4049,
                                    "vc_code": "Интернет-трафик",
                                    "vc_name": "Интернет-трафик",
                                    "n_quant": null,
                                    "t_tags": [
                                
                                    ],
                                    "vc_tags": null,
                                    "n_service_id": 40213401,
                                    "n_service_type_id": 2,
                                    "n_base_service_id": null,
                                    "n_parent_service_id": 1802,
                                    "vc_service_code": "Интернет-трафик",
                                    "vc_service_name": "Интернет-трафик",
                                    "additional_values": [
                                      {
                                        "code": "GOOD_C_FL_Serv_GroupByPrice",
                                        "name": "Группировать начисления по цене",
                                        "value": "Y"
                                      }
                                    ]
                                  },
                                  "navigation": {
                                    "self": "http://example.org/rest/v2/catalog/40213401"
                                  }
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
