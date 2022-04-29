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

object CustomerSubscriptionMockClient {
    fun getClient(): HttpClient {
        return HttpClient(MockEngine) {
            engine {
                addHandler { request ->
                    when (request.url.fullPath) {
                        "/rest/v2/subjects/customers/78052201/subscriptions" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                                  "subscription": {
                                    "n_subscription_id": 100001101,
                                    "n_service_id": 50188901,
                                    "n_customer_id": 78052201,
                                    "n_account_id": 78052501,
                                    "n_object_id": 78058401,
                                    "n_quant": null,
                                    "n_unit_id": 2009,
                                    "d_begin": "2021-10-15T09:13:52+03:00",
                                    "d_end": null,
                                    "c_fl_closed": "N",
                                    "n_line_no": 2000000,
                                    "n_par_subscription_id": null,
                                    "n_prev_subscription_id": null,
                                    "n_cl_creating_state_id": 1212,
                                    "n_contract_id": 78053001,
                                    "actions": {
                                      "show": "http://example.org/rest/v2/subjects/customers/78052201/subscriptions/100001101",
                                      "edit": "http://example.org/rest/v2/subjects/customers/78052201/subscriptions/100001101/edit"
                                    }
                                  },
                                  "navigation": {
                                    "self": "http://example.org/rest/v2/subjects/customers/78052201/subscriptions/",
                                    "customer": "http://example.org/rest/v2/subjects/customers/78052201",
                                    "subscriptions": "http://example.org/rest/v2/subjects/customers/78052201/subscriptions"
                                  }
                                }""",
                                headers = responseHeaders
                            )
                        }
                        "/rest/v2/subjects/customers/302/subscriptions/40240701" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                                  "subscription": {
                                    "n_subscription_id": 40240701,
                                    "n_service_id": 40219001,
                                    "n_customer_id": 302,
                                    "n_account_id": 40233401,
                                    "n_object_id": 40236101,
                                    "n_quant": null,
                                    "n_unit_id": 2009,
                                    "d_begin": "2011-01-19T23:12:48+03:00",
                                    "d_end": null,
                                    "c_fl_closed": "N",
                                    "n_line_no": 1000000,
                                    "n_par_subscription_id": null,
                                    "n_prev_subscription_id": null,
                                    "n_cl_creating_state_id": 1212,
                                    "n_contract_id": 40233901,
                                    "actions": {
                                      "show": "http://example.org/rest/v2/subjects/customers/302/subscriptions/40240701",
                                      "edit": "http://example.org/rest/v2/subjects/customers/302/subscriptions/40240701/edit"
                                    }
                                  },
                                  "navigation": {
                                    "self": "http://example.org/rest/v2/subjects/customers/302/subscriptions/40240701",
                                    "customer": "http://example.org/rest/v2/subjects/customers/302",
                                    "subscriptions": "http://example.org/rest/v2/subjects/customers/302/subscriptions"
                                  }
                                }""",
                                headers = responseHeaders
                            )
                        }
                        "/rest/v2/subjects/customers/302/subscriptions?page=1&per_page=1000" -> {
                            val responseHeaders = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """
                                    {
                                      "subscriptions": [
                                        {
                                          "n_subscription_id": 40240701,
                                          "n_service_id": 40219001,
                                          "n_customer_id": 302,
                                          "n_account_id": 40233401,
                                          "n_object_id": 40236101,
                                          "n_quant": null,
                                          "n_unit_id": 2009,
                                          "d_begin": "2011-01-19T23:12:48+03:00",
                                          "d_end": null,
                                          "c_fl_closed": "N",
                                          "n_line_no": 1000000,
                                          "n_par_subscription_id": null,
                                          "n_prev_subscription_id": null,
                                          "n_cl_creating_state_id": 1212,
                                          "n_contract_id": 40233901,
                                          "actions": {
                                            "show": "http://example.org/rest/v2/subjects/customers/302/subscriptions/40240701",
                                            "edit": "http://example.org/rest/v2/subjects/customers/302/subscriptions/40240701/edit"
                                          }
                                        },
                                        {
                                          "n_subscription_id": 40240801,
                                          "n_service_id": 40217401,
                                          "n_customer_id": 302,
                                          "n_account_id": 40233401,
                                          "n_object_id": 40236101,
                                          "n_quant": null,
                                          "n_unit_id": 2009,
                                          "d_begin": "2011-01-19T23:12:48+03:00",
                                          "d_end": null,
                                          "c_fl_closed": "N",
                                          "n_line_no": 1000001,
                                          "n_par_subscription_id": 40240701,
                                          "n_prev_subscription_id": null,
                                          "n_cl_creating_state_id": 1212,
                                          "n_contract_id": 40233901,
                                          "actions": {
                                            "show": "http://example.org/rest/v2/subjects/customers/302/subscriptions/40240801",
                                            "edit": "http://example.org/rest/v2/subjects/customers/302/subscriptions/40240801/edit"
                                          }
                                        }
                                      ],
                                      "navigation": {
                                        "self": "http://example.org/rest/v2/subjects/customers/302/subscriptions?per_page=10&page=1",
                                        "customer": "http://example.org/rest/v2/subjects/customers/302"
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
