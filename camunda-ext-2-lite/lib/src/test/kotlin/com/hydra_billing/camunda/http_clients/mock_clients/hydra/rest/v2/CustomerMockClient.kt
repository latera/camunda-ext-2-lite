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

object CustomerMockClient {
    fun getClient(): HttpClient {
        return HttpClient(MockEngine) {
            engine {
                addHandler { request ->
                    when (request.url.fullPath) {
                        "/rest/v2/subjects/customers/" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                                "customer": {
                                  "n_subject_id": 99940601,
                                  "n_customer_id": 99940601,
                                  "n_base_subject_id": 78194101,
                                  "vc_base_subject_name": "Майне Клаус",
                                  "n_base_subj_type_id": 18001,
                                  "n_subj_state_id": 2011,
                                  "vc_name": "Майне К.",
                                  "vc_code": "Meine created",
                                  "d_created": "2020-12-15T04:35:21+03:00",
                                  "t_tags": [
                                    "тестовый_абонент"
                                  ],
                                  "vc_rem": "Commentary for created Meine",
                                  "n_firm_id": 100,
                                  "n_subj_group_id": 55027301,
                                  "n_reseller_id": 94911101,
                                  "group_ids": [
                                    55027301,
                                    40250801
                                  ],
                                  "vc_base_subject_code": "Майне К.",
                                  "additional_values": [
                                    {
                                      "code": "SUBJ_VAL_SERVICE_SAMPLE",
                                      "name": "Служебная выборка",
                                      "value": [
                                        null,
                                        "123"
                                      ]
                                    },
                                    {
                                      "code": "SUBJ_VAL_N_WORKSTATION_COUNT",
                                      "name": "Количество рабочих станций",
                                      "value": null
                                    },
                                    {
                                      "code": "SUBJ_VAL_D_CONNECTION_DATE",
                                      "name": "Дата подключения",
                                      "value": null
                                    },
                                    {
                                      "code": "SUBJ_VAL_N_PERSONAL_CARD_STATE_ID",
                                      "name": "Состояние персональной карты",
                                      "value": null
                                    },
                                    {
                                      "code": "Дополнительный текстовый параметр",
                                      "name": "Дополнительный текстовый параметр",
                                      "value": [
                                        null
                                      ]
                                    }
                                  ]
                                },
                                "actions": {
                                  "edit": "http://example.org/rest/v2/subjects/customers/99940601/edit"
                                },
                                "navigation": {
                                  "self": "http://example.org/rest/v2/subjects/customers/",
                                  "accounts": "http://example.org/rest/v2/subjects/customers/99940601/accounts",
                                  "documents": "http://example.org/rest/v2/subjects/customers/99940601/documents",
                                  "equipment": "http://example.org/rest/v2/subjects/customers/99940601/equipment"
                                }
                              }""",
                                headers = responseHeaders
                            )
                        }
                        "/rest/v2/subjects/customers/50162901" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                                  "customer": {
                                    "vc_base_subject_code":"Оруэлл Д.",
                                    "n_customer_id":50162901,
                                    "n_base_subject_id":50155201,
                                    "vc_base_subject_name":"Оруэлл Джордж",
                                    "n_base_subj_type_id":18001,
                                    "n_subj_state_id":2011,
                                    "vc_name":"Оруэлл Д.",
                                    "vc_code":"gordon",
                                    "d_created":"2012-10-05T22:37:08+04:00",
                                    "t_tags":["поэт","сотрудник"],
                                    "vc_rem":"Абонент используется в тестах смены тарифа из ЛК",
                                    "n_firm_id":100,
                                    "n_subj_group_id":40231101,
                                    "n_reseller_id":null,
                                    "group_ids":[40231101,55027301],
                                    "n_subject_id":50162901,
                                    "additional_values": [{"code":"SUBJ_VAL_SERVICE_SAMPLE","name":"Служебная выборка","value":[null]},
                                                          {"code":"SUBJ_VAL_N_WORKSTATION_COUNT","name":"Количество рабочих станций","value":0},
                                                          {"code":"SUBJ_VAL_D_CONNECTION_DATE","name":"Дата подключения","value":null},
                                                          {"code":"SUBJ_VAL_N_PERSONAL_CARD_STATE_ID","name":"Состояние персональной карты","value":null},
                                                          {"code":"Дополнительный текстовый параметр","name":"Дополнительный текстовый параметр","value":[null]}]
                                  },
                                  "actions":{"edit":"http://127.0.0.1:5000/rest/v2/subjects/customers/50162901/edit"},
                                  "navigation":{
                                    "self":"http://127.0.0.1:5000/rest/v2/subjects/customers/50162901",
                                    "accounts":"http://127.0.0.1:5000/rest/v2/subjects/customers/50162901/accounts",
                                    "documents":"http://127.0.0.1:5000/rest/v2/subjects/customers/50162901/documents",
                                    "equipment":"http://127.0.0.1:5000/rest/v2/subjects/customers/50162901/equipment"
                                    }
                                }
                                """.trimIndent(),
                                headers = responseHeaders
                            )
                        }
                        "/rest/v2/subjects/customers/78194501" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                                  "customer": {
                                    "n_subject_id": 78194501,
                                    "n_customer_id": 78194501,
                                    "n_base_subject_id": 78194101,
                                    "vc_base_subject_name": "Майне Клаус",
                                    "n_base_subj_type_id": 18001,
                                    "n_subj_state_id": 5011,
                                    "vc_name": "Майне К.",
                                    "vc_code": "Meine updated",
                                    "d_created": "2015-08-11T23:20:57+03:00",
                                    "t_tags": [
                                      "тестовый_абонент"
                                    ],
                                    "vc_rem": "Commentary updated",
                                    "n_firm_id": 100,
                                    "n_subj_group_id": 55054601,
                                    "n_reseller_id": 94911101,
                                    "group_ids": [
                                      55054601,
                                      55027301
                                    ],
                                    "vc_base_subject_code": "Майне К.",
                                    "additional_values": [
                                      {
                                        "code": "SUBJ_VAL_SERVICE_SAMPLE",
                                        "name": "Служебная выборка",
                                        "value": [
                                          null
                                        ]
                                      },
                                      {
                                        "code": "SUBJ_VAL_N_WORKSTATION_COUNT",
                                        "name": "Количество рабочих станций",
                                        "value": 2
                                      },
                                      {
                                        "code": "SUBJ_VAL_D_CONNECTION_DATE",
                                        "name": "Дата подключения",
                                        "value": null
                                      },
                                      {
                                        "code": "SUBJ_VAL_N_PERSONAL_CARD_STATE_ID",
                                        "name": "Состояние персональной карты",
                                        "value": null
                                      },
                                      {
                                        "code": "Дополнительный текстовый параметр",
                                        "name": "Дополнительный текстовый параметр",
                                        "value": [
                                          null
                                        ]
                                      }
                                    ]
                                  },
                                  "actions": {
                                    "edit": "http://example.org/rest/v2/subjects/customers/78194501/edit"
                                  },
                                  "navigation": {
                                    "self": "http://example.org/rest/v2/subjects/customers/78194501",
                                    "accounts": "http://example.org/rest/v2/subjects/customers/78194501/accounts",
                                    "documents": "http://example.org/rest/v2/subjects/customers/78194501/documents",
                                    "equipment": "http://example.org/rest/v2/subjects/customers/78194501/equipment"
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
