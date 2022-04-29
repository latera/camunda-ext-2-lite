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

object SubjectAddressesMockClient {
    fun getClient(): HttpClient {
        return HttpClient(MockEngine) {
            engine {
                addHandler { request ->
                    when (request.url.fullPath) {
                        "/rest/v2/subject_addresses?subject_id%5B%5D=99&page=1&per_page=1000" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                                  "subject_addresses": [
                                    {
                                      "c_fl_main": "Y",
                                      "n_addr_type_id": 1006,
                                      "n_par_addr_id": null,
                                      "vc_code": "Fabulous Texan Way, Arizona, USA",
                                      "vc_visual_code": "Fabulous Texan Way, Arizona, USA",
                                      "vc_address": "Fabulous Texan Way, Arizona, USA",
                                      "vc_flat": null,
                                      "n_region_id": null,
                                      "vc_entrance_no": null,
                                      "n_floor_no": null,
                                      "n_firm_id": null,
                                      "n_subj_address_id": 102006601,
                                      "n_subject_id": 99,
                                      "n_subj_addr_type_id": 4016,
                                      "n_addr_state_id": 1029,
                                      "vc_rem": null,
                                      "n_bind_addr_id": null,
                                      "vc_subj_addr_type_name": "Юридический адрес",
                                      "d_begin": null,
                                      "d_end": null,
                                      "n_address_id": 102004301
                                    }
                                  ],
                                  "navigation": {
                                    "self": "http://127.0.0.1:5000/rest/v2/subject_addresses?subject_id[]=99&per_page=100&page=1"
                                  }
                                }
                                """.trimMargin(),
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
