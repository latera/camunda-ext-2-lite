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
import io.ktor.http.content.*

object NetDeviceEntryAddressesMockClient {
    fun getClient(): HttpClient {
        return HttpClient(MockEngine) {
            engine {
                addHandler { request ->
                    when (request.url.fullPath) {
                        // Create method
                        "/rest/v2/objects/net_devices/51091001/entries/51091901/addresses" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                                    "address": {
                                        "n_address_id": 234036601,
                                        "n_addr_type_id": 3006,
                                        "vc_addr_type_name": "IPv4-адрес",
                                        "n_par_addr_id": null,
                                        "vc_code": "192.168.45.1",
                                        "vc_address": null,
                                        "vc_flat": null,
                                        "n_region_id": null,
                                        "vc_entrance_no": null,
                                        "n_floor_no": null,
                                        "n_firm_id": null,
                                        "n_bind_addr_id": null,
                                        "n_obj_address_id": 234036701,
                                        "n_obj_addr_type_id": 1016,
                                        "d_begin": "2021-12-29T08:42:08+03:00",
                                        "d_end": null,
                                        "vc_rem": null,
                                        "vc_intercom_code": null,
                                        "actions": {
                                            "edit": "https://study.dev.latera.ru/rest/v2/objects/net_devices/51091001/entries/51091901/addresses/234036701/edit"
                                        },
                                        "navigation": {
                                            "self": "https://study.dev.latera.ru/rest/v2/objects/net_devices/51091001/entries/51091901/addresses",
                                            "entry": "https://study.dev.latera.ru/rest/v2/objects/net_devices/51091001/entries/51091901",
                                            "addresses": "https://study.dev.latera.ru/rest/v2/objects/net_devices/51091001/entries/51091901/addresses"
                                        }
                                    }
                                }
                                """.trimMargin(),
                                headers = responseHeaders
                            )
                        }
                        // Update method
                        "/rest/v2/objects/net_devices/51091001/entries/51091901/addresses/234036701" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                                    "address": {
                                        "n_address_id": 234036601,
                                        "n_addr_type_id": 3006,
                                        "vc_addr_type_name": "IPv4-адрес",
                                        "n_par_addr_id": null,
                                        "vc_code": "192.168.45.1",
                                        "vc_address": null,
                                        "vc_flat": null,
                                        "n_region_id": null,
                                        "vc_entrance_no": null,
                                        "n_floor_no": null,
                                        "n_firm_id": null,
                                        "n_bind_addr_id": null,
                                        "n_obj_address_id": 234036701,
                                        "n_obj_addr_type_id": 1016,
                                        "d_begin": "2021-12-29T08:42:08+03:00",
                                        "d_end": null,
                                        "vc_rem": "123",
                                        "vc_intercom_code": null,
                                        "actions": {
                                            "edit": "https://study.dev.latera.ru/rest/v2/objects/net_devices/51091001/entries/51091901/addresses/234036701/edit"
                                        },
                                        "navigation": {
                                            "self": "https://study.dev.latera.ru/rest/v2/objects/net_devices/51091001/entries/51091901/addresses/234036701",
                                            "entry": "https://study.dev.latera.ru/rest/v2/objects/net_devices/51091001/entries/51091901",
                                            "addresses": "https://study.dev.latera.ru/rest/v2/objects/net_devices/51091001/entries/51091901/addresses"
                                        }
                                    }
                                }
                                """.trimMargin(),
                                headers = responseHeaders
                            )
                        }
                        // List method
                        "/rest/v2/objects/net_devices/50182701/entries/51091901/addresses?page=1&per_page=1000" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                                    "addresses": [
                                        {
                                            "n_address_id": 51122501,
                                            "n_addr_type_id": 3006,
                                            "vc_addr_type_name": "IPv4-адрес",
                                            "n_par_addr_id": 51121901,
                                            "vc_code": "192.168.16.2",
                                            "vc_address": null,
                                            "vc_flat": null,
                                            "n_region_id": null,
                                            "vc_entrance_no": null,
                                            "n_floor_no": null,
                                            "n_firm_id": 100,
                                            "n_bind_addr_id": null,
                                            "n_obj_address_id": 51122701,
                                            "n_obj_addr_type_id": 1016,
                                            "d_begin": "2021-01-31T17:19:39+03:00",
                                            "d_end": null,
                                            "vc_rem": null,
                                            "vc_intercom_code": null,
                                            "actions": {
                                                "show": "https://study.dev.latera.ru/rest/v2/objects/net_devices/50182709/entries/51091901/addresses/51122701",
                                                "edit": "https://study.dev.latera.ru/rest/v2/objects/net_devices/50182709/entries/51091901/addresses/51122701/edit"
                                            }
                                        },
                                        {
                                            "n_address_id": 64492401,
                                            "n_addr_type_id": 3006,
                                            "vc_addr_type_name": "IPv4-адрес",
                                            "n_par_addr_id": 32401,
                                            "vc_code": "192.168.1.1",
                                            "vc_address": null,
                                            "vc_flat": null,
                                            "n_region_id": null,
                                            "vc_entrance_no": null,
                                            "n_floor_no": null,
                                            "n_firm_id": null,
                                            "n_bind_addr_id": null,
                                            "n_obj_address_id": 228015701,
                                            "n_obj_addr_type_id": 1016,
                                            "d_begin": "2021-12-29T08:42:08+03:00",
                                            "d_end": null,
                                            "vc_rem": null,
                                            "vc_intercom_code": null,
                                            "actions": {
                                                "show": "https://study.dev.latera.ru/rest/v2/objects/net_devices/50182709/entries/51091901/addresses/228015701",
                                                "edit": "https://study.dev.latera.ru/rest/v2/objects/net_devices/50182709/entries/51091901/addresses/228015701/edit"
                                            }
                                        },
                                        {
                                            "n_address_id": 234036601,
                                            "n_addr_type_id": 3006,
                                            "vc_addr_type_name": "IPv4-адрес",
                                            "n_par_addr_id": null,
                                            "vc_code": "192.168.45.1",
                                            "vc_address": null,
                                            "vc_flat": null,
                                            "n_region_id": null,
                                            "vc_entrance_no": null,
                                            "n_floor_no": null,
                                            "n_firm_id": null,
                                            "n_bind_addr_id": null,
                                            "n_obj_address_id": 234036701,
                                            "n_obj_addr_type_id": 1016,
                                            "d_begin": "2021-12-29T08:42:08+03:00",
                                            "d_end": null,
                                            "vc_rem": "123",
                                            "vc_intercom_code": null,
                                            "actions": {
                                                "show": "https://study.dev.latera.ru/rest/v2/objects/net_devices/50182709/entries/51091901/addresses/234036701",
                                                "edit": "https://study.dev.latera.ru/rest/v2/objects/net_devices/50182709/entries/51091901/addresses/234036701/edit"
                                            }
                                        }
                                    ],
                                    "navigation": {
                                        "self": "https://study.dev.latera.ru/rest/v2/objects/net_devices/50182709/entries/51091901/addresses/",
                                        "entry": "https://study.dev.latera.ru/rest/v2/objects/net_devices/50182709/entries/51091901"
                                    }
                                }
                                """.trimMargin(),
                                headers = responseHeaders
                            )
                        }
                        // Get method
                        "/rest/v2/objects/net_devices/50182709/entries/51091901/addresses/51122701" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                                    "address": {
                                        "n_address_id": 51122501,
                                        "n_addr_type_id": 3006,
                                        "vc_addr_type_name": "IPv4-адрес",
                                        "n_par_addr_id": 51121901,
                                        "vc_code": "192.168.16.2",
                                        "vc_address": null,
                                        "vc_flat": null,
                                        "n_region_id": null,
                                        "vc_entrance_no": null,
                                        "n_floor_no": null,
                                        "n_firm_id": 100,
                                        "n_bind_addr_id": null,
                                        "n_obj_address_id": 51122701,
                                        "n_obj_addr_type_id": 1016,
                                        "d_begin": "2021-01-31T17:19:39+03:00",
                                        "d_end": null,
                                        "vc_rem": null,
                                        "vc_intercom_code": null,
                                        "actions": {
                                            "edit": "https://study.dev.latera.ru/rest/v2/objects/net_devices/50182709/entries/51091901/addresses/51122701/edit"
                                        },
                                        "navigation": {
                                            "self": "https://study.dev.latera.ru/rest/v2/objects/net_devices/50182709/entries/51091901/addresses/51122701",
                                            "entry": "https://study.dev.latera.ru/rest/v2/objects/net_devices/50182709/entries/51091901",
                                            "addresses": "https://study.dev.latera.ru/rest/v2/objects/net_devices/50182709/entries/51091901/addresses"
                                        }
                                    }
                                }
                                """.trimMargin(),
                                headers = responseHeaders
                            )
                        }
                        // Delete
                        "/rest/v2/objects/net_devices/50182709/entries/51091901/addresses/51122702" -> {
                            respond("", HttpStatusCode.NoContent)
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
