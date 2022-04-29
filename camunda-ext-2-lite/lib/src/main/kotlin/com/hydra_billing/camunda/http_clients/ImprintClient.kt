package com.hydra_billing.camunda.http_clients

import io.ktor.client.HttpClient
import io.ktor.client.engine.apache.Apache
import io.ktor.client.features.*
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.*
import io.ktor.http.*
import org.apache.http.conn.ssl.*
import org.apache.http.ssl.SSLContextBuilder

object ImprintClient {
    data class Config(
        val url: String,
        val version: String,
        val token: String,
        val useSSL: Boolean = true,
        val timeout: Long
    )

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

            if (!config.useSSL) {
                engine {
                    customizeClient {
                        setSSLContext(SSLContextBuilder.create().loadTrustMaterial(TrustAllStrategy()).build())
                        setSSLHostnameVerifier(NoopHostnameVerifier())
                    }
                }
            }

            defaultRequest {
                host = urlObject.host
                port = urlObject.port
                url { protocol = urlObject.protocol }
                header("Accept", "application/json")
                header("Content-Type", "application/json")
                header("X_IMPRINT_API_TOKEN", config.token)
                header("X_IMPRINT_API_VERSION", config.version)
            }
        }
    }
}
