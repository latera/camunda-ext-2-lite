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

object PersonalAccountMockClient {
    fun getClient(): HttpClient {
        return HttpClient(MockEngine) {
            engine {
                addHandler { request ->
                    when (request.url.fullPath) {
                        "rest/v2/subjects/accounts/90471001/charges" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                                    "charges": [
                                        {
                                            "n_doc_id": 163345201,
                                            "n_service_id": 90474401,
                                            "n_sum": "50",
                                            "d_begin": "2022-01-01T11:02:40+03:00",
                                            "d_end": "2022-02-01T10:59:59+03:00",
                                            "vc_rem": null,
                                            "n_currency_id": 1044,
                                            "vc_currency": "CURR_Ruble"
                                        },
                                        {
                                            "n_doc_id": 163345201,
                                            "n_service_id": 90349001,
                                            "n_sum": "0",
                                            "d_begin": "2022-01-01T11:02:40+03:00",
                                            "d_end": "2022-02-01T10:59:59+03:00",
                                            "vc_rem": null,
                                            "vc_currency": "CURR_Ruble"
                                        }
                                    ],
                                    "navigation": {
                                        "self": "https://study.dev.latera.ru/rest/v2/subjects/accounts/90471001/charges?d_begin=2021-12-10T00%3A40%3A37%2B03%3A00&d_end=2022-10-08T00%3A40%3A37%2B03%3A00",
                                        "customer": "https://study.dev.latera.ru/rest/v2/subjects/customers/88961901"
                                    }
                                }""",
                                headers = responseHeaders
                            )
                        }
                        "/rest/v2/subjects/customers/88961901/accounts" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                                    "account": {
                                        "n_account_id": 325390501,
                                        "n_currency_id": 1044,
                                        "vc_currency_code": "RUB",
                                        "vc_name": "New test account №test_account",
                                        "vc_code": "New test account",
                                        "vc_account": "test_account",
                                        "vc_rem": null,
                                        "n_sum_bal": "0",
                                        "n_sum_free": "0",
                                        "n_max_credit_limit": null,
                                        "n_sum_reserved_total": "0",
                                        "n_sum_reserved": "0",
                                        "has_actual_atu": false,
                                        "permanent_credit_limit": {
                                            "n_sum": null
                                        },
                                        "temporary_credit_limit": {
                                            "n_sum": null,
                                            "d_end": null
                                        },
                                        "scheduled_services_credit_limit": {
                                            "n_sum": null,
                                            "d_end": null
                                        },
                                        "unscheduled_services_credit_limit": {
                                            "n_sum": null,
                                            "d_end": null
                                        },
                                        "actual_charge_logs_amount": 0,
                                        "actions": {
                                            "edit": "https://study.dev.latera.ru/rest/v2/subjects/customers/88961901/accounts/325390501/edit"
                                        }
                                    }
                                }""",
                                headers = responseHeaders
                            )
                        }
                        "/rest/v2/personal_accounts/78299501" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                                "personal_account": {
                                  "vc_subj_code": "api_account_user",
                                  "vc_subj_name": "Маркони Г.",
                                  "n_subj_state_id":2011,
                                  "n_firm_id":100,
                                  "n_account_id":78299501,
                                  "n_account_type_id":2042,
                                  "vc_account_type_name":"Лицевой счет",
                                  "n_bank_id":100,
                                  "vc_bank_name":"Offline Telecom",
                                  "n_currency_id":1044,
                                  "vc_currency_code":"RUB",
                                  "vc_name":"Лицевой счет №1099",
                                  "vc_code":"1099",
                                  "vc_account":"1099",
                                  "d_open":null,
                                  "d_close":null,
                                  "n_max_overdraft":null,
                                  "vc_bank":null,
                                  "vc_rem":null,
                                  "vc_code_ex":"1099 (Лицевой счет №1099)",
                                  "n_subject_id":78299201
                                },
                                "navigation":{
                                  "self":"http://127.0.0.1:5000/rest/v2/personal_accounts/78299501"
                                }}""",
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
