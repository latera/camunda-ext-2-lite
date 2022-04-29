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

object CustomerEquipmentMockClient {
    fun getClient(): HttpClient {
        return HttpClient(MockEngine) {
            engine {
                addHandler { request ->
                    when (request.url.fullPath) {
                        "/rest/v2/subjects/customers/302/equipment" -> {
                            val responseHeaders = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                                "equipment": {
                                  "n_object_id": 99943701,
                                  "n_good_id": 21501,
                                  "n_firm_id": 100,
                                  "n_obj_state_id": 1040,
                                  "vc_name": "Оконечное оборудование (testing_equipment)",
                                  "vc_code": "testing_equipment",
                                  "vc_code_add": null,
                                  "vc_rem": null,
                                  "n_main_object_id": null,
                                  "n_owner_id": 302,
                                  "vc_serial_number": null,
                                  "vc_inventory_number": null,
                                  "d_warranty_end": null,
                                  "additional_values": [
                                    {
                                      "code": "GOOD_N_Param_Units",
                                      "name": "Юниты",
                                      "value": null
                                    }
                                  ],
                                  "actions": {
                                    "show": "http://example.org/rest/v2/objects/net_devices/99943701",
                                    "edit": "http://example.org/rest/v2/objects/net_devices/99943701/edit"
                                  }
                                },
                                "navigation": {
                                  "self": "http://example.org/rest/v2/subjects/customers/302/equipment",
                                  "customer": "http://example.org/rest/v2/subjects/customers/302",
                                  "equipment": "http://example.org/rest/v2/subjects/customers/302/equipment"
                                }
                              }""",
                                headers = responseHeaders
                            )
                        }
                        "/rest/v2/subjects/customers/302/equipment/40236101" -> {
                            val responseHeaders = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                                  "equipment": {
                                    "n_object_id": 40236101,
                                    "n_good_id": 40224501,
                                    "n_firm_id": 100,
                                    "n_obj_state_id": 1040,
                                    "vc_name": "Порт №migrator",
                                    "vc_code": "migrator",
                                    "vc_code_add": null,
                                    "vc_rem": null,
                                    "n_main_object_id": 40223001,
                                    "n_owner_id": 302,
                                    "vc_serial_number": null,
                                    "vc_inventory_number": null,
                                    "d_warranty_end": null,
                                    "additional_values": [
                                      {
                                        "code": "NETSERV_CDRForceFinishTimeout",
                                        "name": "Таймаут принудительного закрытия CDR (в часах)",
                                        "value": null
                                      },
                                      {
                                        "code": "NETSERV_OldCDRDeleteTimeout",
                                        "name": "Таймаут удаления старых CDR (в днях)",
                                        "value": null
                                      },
                                      {
                                        "code": "ObjPar_CreateExDataCollJob",
                                        "name": "Создавать задание по тарификации внешней статистики по услугам",
                                        "value": null
                                      }
                                    ],
                                    "actions": {
                                      "show": "http://example.org/rest/v2/objects/net_devices/40236101",
                                      "edit": "http://example.org/rest/v2/objects/net_devices/40236101/edit"
                                    }
                                  },
                                  "navigation": {
                                    "self": "http://example.org/rest/v2/subjects/customers/302/equipment/40236101",
                                    "customer": "http://example.org/rest/v2/subjects/customers/302",
                                    "equipment": "http://example.org/rest/v2/subjects/customers/302/equipment"
                                  }
                                }""",
                                headers = responseHeaders
                            )
                        }
                        "/rest/v2/subjects/customers/302/equipment?page=1&per_page=1000" -> {
                            val responseHeaders = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                              "equipment": [
                                {
                                  "n_object_id": 40236101,
                                  "n_good_id": 40224501,
                                  "n_firm_id": 100,
                                  "n_obj_state_id": 1040,
                                  "vc_name": "Порт №migrator",
                                  "vc_code": "migrator",
                                  "vc_code_add": null,
                                  "vc_rem": null,
                                  "n_main_object_id": 40223001,
                                  "n_owner_id": 302,
                                  "vc_serial_number": null,
                                  "vc_inventory_number": null,
                                  "d_warranty_end": null,
                                  "additional_values": [
                                    {
                                      "code": "NETSERV_CDRForceFinishTimeout",
                                      "name": "Таймаут принудительного закрытия CDR (в часах)",
                                      "value": null
                                    },
                                    {
                                      "code": "NETSERV_OldCDRDeleteTimeout",
                                      "name": "Таймаут удаления старых CDR (в днях)",
                                      "value": null
                                    },
                                    {
                                      "code": "ObjPar_CreateExDataCollJob",
                                      "name": "Создавать задание по тарификации внешней статистики по услугам",
                                      "value": null
                                    }
                                  ],
                                  "actions": {
                                    "show": "http://example.org/rest/v2/objects/net_devices/40236101",
                                    "edit": "http://example.org/rest/v2/objects/net_devices/40236101/edit"
                                  }
                                },
                                {
                                  "n_object_id": 50270301,
                                  "n_good_id": 40224501,
                                  "n_firm_id": 100,
                                  "n_obj_state_id": 2040,
                                  "vc_name": "Порт №1",
                                  "vc_code": "1",
                                  "vc_code_add": null,
                                  "vc_rem": null,
                                  "n_main_object_id": 40223001,
                                  "n_owner_id": 302,
                                  "vc_serial_number": null,
                                  "vc_inventory_number": null,
                                  "d_warranty_end": null,
                                  "additional_values": [
                                    {
                                      "code": "NETSERV_CDRForceFinishTimeout",
                                      "name": "Таймаут принудительного закрытия CDR (в часах)",
                                      "value": null
                                    },
                                    {
                                      "code": "NETSERV_OldCDRDeleteTimeout",
                                      "name": "Таймаут удаления старых CDR (в днях)",
                                      "value": null
                                    },
                                    {
                                      "code": "ObjPar_CreateExDataCollJob",
                                      "name": "Создавать задание по тарификации внешней статистики по услугам",
                                      "value": null
                                    }
                                  ],
                                  "actions": {
                                    "show": "http://example.org/rest/v2/objects/net_devices/50270301",
                                    "edit": "http://example.org/rest/v2/objects/net_devices/50270301/edit"
                                  }
                                }
                              ],
                              "navigation": {
                                "self": "http://example.org/rest/v2/subjects/customers/302/equipment?per_page=10&page=1",
                                "customer": "http://example.org/rest/v2/subjects/customers/302",
                                "equipment": "http://example.org/rest/v2/subjects/customers/302/equipment"
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
