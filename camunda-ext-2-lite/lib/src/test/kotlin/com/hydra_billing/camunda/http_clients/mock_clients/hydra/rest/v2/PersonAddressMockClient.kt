package com.hydra_billing.camunda.http_clients.mock_clients.hydra.rest.v2

import com.hydra_billing.camunda.http_clients.NullableTypeAdapterFactory
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.*
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.features.*
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.*
import io.ktor.http.*

object PersonAddressMockClient {
    fun getClient(): HttpClient {
        return HttpClient(MockEngine) {
            engine {
                addHandler { request ->
                    when (request.url.fullPath) {
                        "/rest/v2/subjects/persons/78419101/addresses" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                    "address": {
                      "n_address_id": 99947401,
                      "n_addr_type_id": 1006,
                      "n_par_addr_id": null,
                      "vc_code": "Россия, г. Москва, г. Зеленоград",
                      "vc_visual_code": "г. Зеленоград, Россия, г. Москва, г. Зеленоград",
                      "vc_address": "Россия, г. Москва, г. Зеленоград",
                      "vc_flat": null,
                      "n_region_id": 40230201,
                      "vc_entrance_no": null,
                      "n_floor_no": null,
                      "n_firm_id": null,
                      "n_subj_address_id": 99947501,
                      "n_subj_addr_type_id": 1016,
                      "n_addr_state_id": 1029,
                      "vc_rem": null,
                      "n_bind_addr_id": null,
                      "d_begin": null,
                      "d_end": null,
                      "c_fl_main": "Y",
                      "vc_intercom_code": null,
                      "navigation": {
                        "self": "http://example.org/rest/v2/subjects/persons/78419101/addresses/",
                        "customer": "http://example.org/rest/v2/subjects/customers/78419101",
                        "addresses": "http://example.org/rest/v2/subjects/persons/78419101/addresses"
                      }
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
