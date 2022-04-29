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

object ReferenceMockClient {
    fun getClient(): HttpClient {
        return HttpClient(MockEngine) {
            engine {
                addHandler { request ->
                    when (request.url.fullPath) {
                        "/rest/v2/references?ref_type_code=REF_TYPE_Document_Type&page=1&per_page=1000" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """
                                    {
                                      "references": [
                                        {
                                          "n_ref_id": 1002,
                                          "n_par_ref_id": null,
                                          "n_ref_type_id": 2,
                                          "n_ref_base_id": null,
                                          "n_firm_id": null,
                                          "vc_name": "Договор на оказание услуг",
                                          "vc_code": "DOC_TYPE_SubscriberContract",
                                          "vc_value": null,
                                          "vc_value_2": null,
                                          "vc_value_3": null,
                                          "c_value": null,
                                          "c_value_2": null,
                                          "c_value_3": null,
                                          "d_value": null,
                                          "d_value_2": null,
                                          "d_value_3": null,
                                          "n_value": null,
                                          "n_value_2": null,
                                          "n_value_3": null,
                                          "c_fl_editable": "N",
                                          "c_fl_manual": "N",
                                          "n_lang_id": 1131
                                        }
                                      ],
                                      "actions": {
                                        "index": "http://example.org/rest/v2/references"
                                      }
                                    }
                                """.trimIndent(),
                                headers = responseHeaders
                            )
                        }
                        "/rest/v2/references/DOC_TYPE_SubscriberContract" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """
                                    {
                                      "reference": {
                                        "n_ref_id": 1002,
                                        "n_par_ref_id": null,
                                        "n_ref_type_id": 2,
                                        "n_ref_base_id": null,
                                        "n_firm_id": null,
                                        "vc_name": "Договор на оказание услуг",
                                        "vc_code": "DOC_TYPE_SubscriberContract",
                                        "vc_value": null,
                                        "vc_value_2": null,
                                        "vc_value_3": null,
                                        "c_value": null,
                                        "c_value_2": null,
                                        "c_value_3": null,
                                        "d_value": null,
                                        "d_value_2": null,
                                        "d_value_3": null,
                                        "n_value": null,
                                        "n_value_2": null,
                                        "n_value_3": null,
                                        "c_fl_editable": "N",
                                        "c_fl_manual": "N",
                                        "n_lang_id": 1131
                                      },
                                      "actions": {
                                        "show": "http://example.org/rest/v2/references/1002"
                                      },
                                      "navigation": {
                                        "self": "http://example.org/rest/v2/references/DOC_TYPE_SubscriberContract"
                                      }
                                    }
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
