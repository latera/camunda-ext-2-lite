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

object NetDeviceAddressesMockClient {
    fun getClient(): HttpClient {
        return HttpClient(MockEngine) {
            engine {
                addHandler { request ->
                    when (request.url.fullPath) {
                        // Create method
                        "/rest/v2/objects/net_devices/51091001/addresses" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                                    "address": {
                                        "n_address_id": 51160101,
                                        "n_addr_type_id": 1006,
                                        "vc_addr_type_name": "Обычный адрес",
                                        "n_par_addr_id": null,
                                        "vc_code": null,
                                        "vc_address": null,
                                        "vc_flat": null,
                                        "n_region_id": 51160001,
                                        "vc_entrance_no": null,
                                        "n_floor_no": null,
                                        "n_firm_id": null,
                                        "n_bind_addr_id": null,
                                        "n_obj_address_id": 227752901,
                                        "n_obj_addr_type_id": 1016,
                                        "d_begin": "2021-12-29T08:42:07+03:00",
                                        "d_end": null,
                                        "vc_rem": null,
                                        "vc_intercom_code": null,
                                        "actions": {
                                            "edit": "https://study.dev.latera.ru/rest/v2/objects/net_devices/51091001/addresses/227752901/edit"
                                        },
                                        "navigation": {
                                            "self": "https://study.dev.latera.ru/rest/v2/objects/net_devices/51091001/addresses",
                                            "net_device": "https://study.dev.latera.ru/rest/v2/objects/net_devices/51091001",
                                            "addresses": "https://study.dev.latera.ru/rest/v2/objects/net_devices/51091001/addresses"
                                        }
                                    }
                                }
                                """.trimMargin(),
                                headers = responseHeaders
                            )
                        }
                        // Update method
                        "/rest/v2/objects/net_devices/50182709/addresses/50184301" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                                    "address": {
                                        "n_address_id": 50184301,
                                        "n_addr_type_id": 1006,
                                        "vc_addr_type_name": "Обычный адрес",
                                        "n_par_addr_id": null,
                                        "vc_code": "кв. 12",
                                        "vc_address": null,
                                        "vc_flat": "12",
                                        "n_region_id": 51160001,
                                        "vc_entrance_no": null,
                                        "n_floor_no": null,
                                        "n_firm_id": null,
                                        "n_bind_addr_id": null,
                                        "n_obj_address_id": 51165001,
                                        "n_obj_addr_type_id": 6016,
                                        "d_begin": "2018-08-31T17:19:39+03:00",
                                        "d_end": null,
                                        "vc_rem": "123",
                                        "vc_intercom_code": null,
                                        "actions": {
                                            "edit": "https://study.dev.latera.ru/rest/v2/objects/net_devices/50182709/addresses/50184301/edit"
                                        },
                                        "navigation": {
                                            "self": "https://study.dev.latera.ru/rest/v2/objects/net_devices/50182709/addresses/50184301",
                                            "net_device": "https://study.dev.latera.ru/rest/v2/objects/net_devices/50182709",
                                            "addresses": "https://study.dev.latera.ru/rest/v2/objects/net_devices/50182709/addresses"
                                        }
                                    }
                                }
                                """.trimMargin(),
                                headers = responseHeaders
                            )
                        }
                        // List method
                        "/rest/v2/objects/net_devices/50182701/addresses?page=1&per_page=1000" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                                    "addresses": [
                                        {
                                          "n_address_id": 50158501,
                                          "n_addr_type_id": 1006,
                                          "vc_addr_type_name": "Обычный адрес",
                                          "n_par_addr_id": null,
                                          "vc_code": null,
                                          "vc_address": null,
                                          "vc_flat": null,
                                          "n_region_id": 50158401,
                                          "vc_entrance_no": null,
                                          "n_floor_no": null,
                                          "n_firm_id": null,
                                          "n_bind_addr_id": null,
                                          "n_obj_address_id": 50184301,
                                          "n_obj_addr_type_id": 6016,
                                          "d_begin": "2012-10-06T01:27:37+04:00",
                                          "d_end": null,
                                          "vc_rem": null,
                                          "vc_intercom_code": null,
                                          "actions": {
                                            "show": "http://example.org/rest/v2/objects/net_devices/50182701/addresses/50184301",
                                            "edit": "http://example.org/rest/v2/objects/net_devices/50182701/addresses/50184301/edit"
                                          }
                                        }
                                      ],
                                      "navigation": {
                                        "self": "http://example.org/rest/v2/objects/net_devices/50182701/addresses?per_page=10&page=1",
                                        "net_device": "http://example.org/rest/v2/objects/net_devices/50182701"
                                      }
                                }
                                """.trimMargin(),
                                headers = responseHeaders
                            )
                        }
                        // Get method
                        "/rest/v2/objects/net_devices/50182701/addresses/50184301" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                                      "address": {
                                        "n_address_id": 50158501,
                                        "n_addr_type_id": 1006,
                                        "vc_addr_type_name": "Обычный адрес",
                                        "n_par_addr_id": null,
                                        "vc_code": null,
                                        "vc_address": null,
                                        "vc_flat": null,
                                        "n_region_id": 50158401,
                                        "vc_entrance_no": null,
                                        "n_floor_no": null,
                                        "n_firm_id": null,
                                        "n_bind_addr_id": null,
                                        "n_obj_address_id": 50184301,
                                        "n_obj_addr_type_id": 6016,
                                        "d_begin": "2012-10-06T01:27:37+04:00",
                                        "d_end": null,
                                        "vc_rem": null,
                                        "vc_intercom_code": null,
                                        "actions": {
                                          "edit": "http://example.org/rest/v2/objects/net_devices/50182701/addresses/50184301/edit"
                                        },
                                        "navigation": {
                                          "self": "http://example.org/rest/v2/objects/net_devices/50182701/addresses/50184301",
                                          "net_device": "http://example.org/rest/v2/objects/net_devices/50182701",
                                          "addresses": "http://example.org/rest/v2/objects/net_devices/50182701/addresses"
                                        }
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
