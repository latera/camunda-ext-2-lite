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

object NetworkServiceSubscriptionMockClient {
    fun getClient(): HttpClient {
        return HttpClient(MockEngine) {
            engine {
                addHandler { request ->
                    when (request.url.fullPath) {
                        "/rest/v2/subjects/50293401/network_service_subscriptions?page=1&per_page=1000" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                                      "network_service_subscriptions": [
                                        {
                                          "n_subj_serv_id": 54913901,
                                          "n_subj_serv_type_id": 3066,
                                          "n_subject_id": 50293401,
                                          "n_service_id": 54300101,
                                          "vc_user_service_name": "sms-server(служба уведомлений)-1 (sms-server(служба уведомлений))",
                                          "n_object_id": null,
                                          "n_auth_type_id": 1019,
                                          "vc_auth_type": "Логин/пароль",
                                          "vc_login": null,
                                          "actions": {
                                            "index": "http://example.org/rest/v2/subjects/50293401/network_service_subscriptions"
                                          }
                                        }
                                      ]
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
