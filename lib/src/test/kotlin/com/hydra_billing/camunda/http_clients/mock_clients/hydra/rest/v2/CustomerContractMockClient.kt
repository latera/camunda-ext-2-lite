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

object CustomerContractMockClient {
    fun getClient(): HttpClient {
        return HttpClient(MockEngine) {
            engine {
                addHandler { request ->
                    when (request.url.fullPath) {
                        "/rest/v2/subjects/customers/94893001/contracts" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                    "contract": {
                      "n_doc_id": 99940001,
                      "n_doc_type_id": 1002,
                      "n_doc_state_id": 3003,
                      "n_parent_doc_id": 40232501,
                      "n_workflow_id": 10021,
                      "d_doc": "2020-12-15T00:00:00+03:00",
                      "d_time": "2020-12-15T04:35:19+03:00",
                      "vc_doc_no": "Test subscriber contract v2",
                      "d_begin": "2020-12-15T00:00:00+03:00",
                      "d_end": null,
                      "n_firm_id": 100,
                      "vc_rem": null,
                      "n_provider_id": 100,
                      "additional_values": [
                        {
                          "code": "CONTR_TestCustomField",
                          "name": "Test custom field",
                          "value": null
                        }
                      ],
                      "actions": {
                        "edit": "http://example.org/rest/v2/subjects/customers/94893001/contracts/99940001/edit",
                        "show": "http://example.org/rest/v2/subjects/customers/94893001/contracts/99940001"
                      }
                    },
                    "navigation": {
                      "self": "http://example.org/rest/v2/subjects/customers/94893001/contracts",
                      "customer": "http://example.org/rest/v2/subjects/customers/94893001",
                      "contracts": "http://example.org/rest/v2/subjects/customers/94893001/contracts"
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
