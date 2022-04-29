package com.hydra_billing.camunda.http_clients.mock_clients.odoo

import com.hydra_billing.camunda.http_clients.NullableTypeAdapterFactory
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.features.*
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.*
import io.ktor.http.*

object OdooMockClient {
    data class Config(val url: String, val useSSL: Boolean = true, val oa_name: String, val timeout: Long, val login: String, val token: String)

    fun getClient(config: Config): HttpClient {
        val urlObject = URLBuilder(config.url)
        return HttpClient(MockEngine) {
            engine {
                addHandler { request ->
                    when (request.url.fullPath) {
                        "/api/v1/${config.oa_name}/res.partner/20" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                                    "id": 20,
                                    "name": "Edwin Hansen",
                                    "email": "edwin.hansen58@example.com",
                                    "phone": "(943)-352-2555",
                                    "website": "",
                                    "function": "Marketing Manager",
                                    "company_id": null,
                                    "contact_address": "Gemini Furniture\n317 Fairchild Dr\n\nFairfield CA 94535\nUnited States",
                                    "user_ids": [],
                                    "active": true,
                                    "is_company": false,
                                    "company_name": "",
                                    "user_id": null,
                                    "state_id": 13,
                                    "zip": "94535",
                                    "hydra_customer_id": "123",
                                    "country_id": 233,
                                    "city": "Fairfield",
                                    "street": "317 Fairchild Dr",
                                    "street2": "",
                                    "comment": "test"
                                }
                                """.trimIndent(),
                                headers = responseHeaders
                            )
                        }
                        "/api/v1/${config.oa_name}/res.partner" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                                    "id": 77,
                                    "name": "Test",
                                    "email": "",
                                    "phone": "",
                                    "website": "",
                                    "function": "CEO",
                                    "company_id": null,
                                    "contact_address": "\n\n  \n",
                                    "user_ids": [],
                                    "active": true,
                                    "is_company": false,
                                    "company_name": "",
                                    "user_id": null,
                                    "state_id": null,
                                    "zip": "",
                                    "hydra_customer_id": "",
                                    "country_id": null,
                                    "city": "",
                                    "street": "",
                                    "street2": "",
                                    "comment": ""
                                }
                                """.trimIndent(),
                                headers = responseHeaders
                            )
                        }
                        "/api/v1/${config.oa_name}/res.country/3" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                                    "id": 3,
                                    "name": "Afghanistan",
                                    "code": "AF",
                                    "currency_id": 47,
                                    "phone_code": 93,
                                    "address_format": "%(street)s\n%(street2)s\n%(city)s %(state_code)s %(zip)s\n%(country_name)s",
                                    "vat_label": ""
                                }
                                """.trimIndent(),
                                headers = responseHeaders
                            )
                        }
                        else -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """
                                {
                                    "code": 0,
                                    "message": "Error!"
                                }
                                """.trimIndent(),
                                headers = responseHeaders
                            )
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
            install(HttpTimeout) { requestTimeoutMillis = 600000 }

            defaultRequest {
                host = urlObject.host
                port = urlObject.port

                url {
                    protocol = urlObject.protocol
                    encodedPath = "/api/v1/" + config.oa_name + url.encodedPath
                }

                header("Accept", "application/json")
                header("Content-Type", "application/json")
            }
        }
    }
}
