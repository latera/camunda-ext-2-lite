package com.hydra_billing.camunda.http_clients.mock_clients.planado_v2

import com.hydra_billing.camunda.http_clients.NullableTypeAdapterFactory
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.http.*

object JobMockClient {
    fun getClient(): HttpClient {
        val initial_path = "/v2/jobs"
        return HttpClient(MockEngine) {
            engine {
                addHandler { request ->
                    when {
                        // Create job
                        request.method == HttpMethod.Post &&
                            request.url.fullPath ==
                            "$initial_path" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                            "job_uuid": "139e3f3e-eec9-6e90-1a33-7eedef81b28f"
                }""",
                                headers = responseHeaders
                            )
                        }

                        // Update job
                        request.method == HttpMethod.Patch &&
                            request.url.fullPath ==
                            "$initial_path/139e3f4b-6a42-6660-a9d1-5e3aefc1c29a" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                            "job_uuid": "139e3f4b-6a42-6660-a9d1-5e3aefc1c29a"
                }""",
                                headers = responseHeaders
                            )
                        }

                        // Get job
                        request.method == HttpMethod.Get &&
                            request.url.fullPath ==
                            "$initial_path/1399ec57-c76b-6c90-8ea4-7aa936ee4847" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                                  "job": {
                                    "uuid": "1399ec57-c76b-6c90-8ea4-7aa936ee4847",
                                    "id": 50220003971,
                                    "external_id": "123123123",
                                    "external_order_id": "123123123123123",
                                    "serial_no": 68,
                                    "status": "suspended",
                                    "scheduled_at": "2021-05-24T14:00:00Z",
                                    "scheduled_duration": {
                                      "minutes": 60
                                    },
                                    "template": {
                                      "uuid": "1399ec54-47c0-6420-e6c9-7e0e1c3a5e05",
                                      "name": "netsurf_customer_connection",
                                      "id": 50220658971
                                    },
                                    "client": {
                                      "uuid": "139b79e6-ba13-6220-758f-32061e2079b2",
                                      "external_id": "38c1a2c325cd6c445a26aa7ff698d982",
                                      "id": 50632579971
                                    },
                                    "site": null,
                                    "type": {
                                      "uuid": "138dbf6e-2a5d-6fe0-fdae-22fb66229a7f",
                                      "id": 47682255971,
                                      "code": "Монтаж"
                                    },
                                    "assignee": {
                                      "worker": {
                                        "uuid": "138dbf6e-2978-6cd0-fdae-22fb66229a7f",
                                        "email": "nikegor24@gmail.com",
                                        "id": 47682241971
                                      }
                                    },
                                    "assignees": [
                                      {
                                        "uuid": "138dbf6e-2978-6cd0-fdae-22fb66229a7f",
                                        "email": "nikegor24@gmail.com",
                                        "id": 47682241971,
                                        "access": "edit"
                                      }
                                    ],
                                    "skills": [
                                      {
                                        "uuid": "d2299ab1-a89d-4a6f-bce9-f395172c9c35",
                                        "name": "Чтение"
                                      }
                                    ],
                                    "territory": {
                                      "uuid": "29e9e04d-2c11-46ae-9aa9-f3e0525615e2",
                                      "name": "Интернет"
                                    },
                                    "timestamps": {
                                      "en_route_at": null,
                                      "started_at": "2021-05-24T13:55:54Z",
                                      "suspended_at": "2021-07-28T07:08:12Z",
                                      "finished_at": null
                                    },
                                    "durations": {
                                      "en_route": null,
                                      "suspension": {
                                        "minutes": 557
                                      },
                                      "actual": {
                                        "minutes": 2111
                                      }
                                    },
                                    "description": "Some description",
                                    "address": {
                                      "formatted": null,
                                      "apartment": null,
                                      "floor": null,
                                      "entrance_no": null,
                                      "description": null,
                                      "geolocation": null
                                    },
                                    "contacts": [
                                      {
                                        "type": "phone",
                                        "name": "Pedro",
                                        "value": "(834) 362-5246"
                                      }
                                    ],
                                    "possible_resolutions": [
                                      {
                                        "uuid": "138dbf6e-2a07-6380-fdae-22fb66229a7f",
                                        "name": "Выполнен",
                                        "id": 47682243971,
                                        "successful": true
                                      },
                                      {
                                        "uuid": "138dbf6e-2a18-6ca0-fdae-22fb66229a7f",
                                        "name": "Не выполнен",
                                        "id": 47682244971,
                                        "successful": false
                                      }
                                    ],
                                    "initial_job_uuid": null,
                                    "completion_of_uuid": null,
                                    "custom_fields": [],
                                    "report_fields": [
                                      {
                                        "uuid": "1399ec55-d904-6b60-e6c9-7e0e1c3a5e05",
                                        "name": "Equipment MAC",
                                        "field_type": "barcode",
                                        "data_type": "string",
                                        "required": false,
                                        "hidden": false,
                                        "read_only": false,
                                        "value": "1234567890005",
                                        "filled_at": "2021-05-24T13:56:09Z"
                                      },
                                      {
                                        "uuid": "1399ec55-d941-6310-e6c9-7e0e1c3a5e05",
                                        "name": "Scanned Contract",
                                        "field_type": "file",
                                        "data_type": "attachment",
                                        "required": false,
                                        "hidden": false,
                                        "read_only": false,
                                        "value": null
                                      }
                                    ],
                                    "version": 6,
                                    "created_at": "2021-05-24T13:54:31.114682Z",
                                    "updated_at": "2021-07-28T07:08:13.811353Z"
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
