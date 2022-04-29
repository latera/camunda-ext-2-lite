package com.hydra_billing.camunda.http_clients

import io.ktor.client.HttpClient
import io.ktor.client.engine.apache.Apache
import io.ktor.client.features.*
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.*
import io.ktor.http.*

object GoogleMapClient {
    data class Config(val url: String, val token: String, val timeout: Long)

    fun getClient(config: Config): HttpClient {
        val urlObject = URLBuilder(config.url)

        return HttpClient(Apache) {
            install(JsonFeature) {
                serializer =
                    GsonSerializer {
                        disableHtmlEscaping()
                        registerTypeAdapterFactory(NullableTypeAdapterFactory())
                    }
            }
            install(HttpTimeout) { requestTimeoutMillis = config.timeout }

            defaultRequest {
                host = urlObject.host
                port = urlObject.port
                url { protocol = urlObject.protocol }
                parameter("key", config.token)
                header("Accept", "application/json")
                header("Content-Type", "application/json")
            }
        }
    }
}
