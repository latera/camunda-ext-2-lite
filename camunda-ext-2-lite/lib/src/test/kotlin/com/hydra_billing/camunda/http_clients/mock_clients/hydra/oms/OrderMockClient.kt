package com.hydra_billing.camunda.http_clients.mock_clients.hydra.oms

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

object OrderMockClient {
    fun getClient(): HttpClient {
        return HttpClient(MockEngine) {
            engine {
                addHandler { request ->
                    when (request.url.fullPath) {
                        "/api/orders/ORD-1" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                    "order": {
                        "id": 4,
                        "code": "ORD-1",
                        "ext_code": null,
                        "bp_id": null,
                        "bp_state": null,
                        "state": "to_execute",
                        "archived": false,
                        "data": {
                            "employeeFirstName": "James",
                            "employeeLastName": "Carter",
                            "employeeEmail": "james@example.com",
                            "beginDate": "2016-07-15T14:45:03.000+00:00",
                            "endDate": "2016-07-16T14:49:42.000+00:00",
                            "motivationText": "I had a lot of work last 7 years",
                            "resolution": null,
                            "resolutionText": null,
                            "adjustResult": null
                        },
                        "done_at": null,
                        "order_type_code": "vacation_request",
                        "user_email": null
                    }
                }""",
                                headers = responseHeaders
                            )
                        }
                        "/api/orders?page_size=2&page=2" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                    "orders": [
                        {
                            "id": 1,
                            "code": "ORD-1",
                            "ext_code": null,
                            "bp_id": null,
                            "bp_state": null,
                            "state": "to_execute",
                            "archived": false,
                            "data": {
                                "employeeFirstName": "James",
                                "employeeLastName": "Carter",
                                "employeeEmail": "james@example.com",
                                "beginDate": "2016-07-15T14:45:03.000+00:00",
                                "endDate": "2016-07-16T14:49:42.000+00:00",
                                "motivationText": "I had a lot of work last 7 years",
                                "resolution": null,
                                "resolutionText": null,
                                "adjustResult": null
                            },
                            "done_at": null,
                            "order_type_code": "vacation_request",
                            "user_email": null
                        }
                    ]
                }""",
                                headers = responseHeaders
                            )
                        }
                        "/api/orders" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                    "order": {
                        "id": 10,
                        "code": "ORD-4",
                        "ext_code": "ext_code",
                        "bp_id": "bp_id",
                        "bp_state": "bp_state",
                        "state": "in_progress",
                        "archived": false,
                        "data": {
                            "employeeFirstName": "James",
                            "employeeLastName": "Carter",
                            "employeeEmail": "james@example.com",
                            "beginDate": "2016-07-15T14:45:03.000+00:00",
                            "endDate": "2016-07-16T14:49:42.000+00:00",
                            "motivationText": "I had a lot of work last 7 years",
                            "resolution": "Resolution",
                            "resolutionText": "Resolution Text",
                            "adjustResult": "Adjust Result"
                        },
                        "done_at": "2016-05-16T13:52:48+03:00",
                        "order_type_code": "vacation_request",
                        "user_email": null
                    }
                }""",
                                headers = responseHeaders
                            )
                        }
                        "/api/orders/ORD-2" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                    "order": {
                        "id": 11,
                        "code": "ORD-2",
                        "ext_code": "ext_code",
                        "bp_id": "bp_id",
                        "bp_state": "bp_state",
                        "state": "in_progress",
                        "archived": false,
                        "data": {
                            "requesterName": "Frank",
                            "requesterPhone": "123123123",
                            "subject": null,
                            "description": null,
                            "resolution": null,
                            "resolutionText": null
                        },
                        "done_at": null,
                        "order_type_code": "support_request",
                        "user_email": null
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
