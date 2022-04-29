package com.hydra_billing.camunda.http_clients

import io.ktor.client.HttpClient
import io.ktor.client.engine.apache.Apache
import io.ktor.client.features.*
import io.ktor.client.features.auth.Auth
import io.ktor.client.features.auth.providers.*
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.*
import io.ktor.http.*
import org.apache.http.conn.ssl.NoopHostnameVerifier
import org.apache.http.conn.ssl.TrustAllStrategy
import org.apache.http.ssl.SSLContextBuilder

object OdooRestClient {

    data class Config(val url: String, val useSSL: Boolean = true, val oa_name: String, val timeout: Long, val login: String, val token: String)

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

            install(Auth) {
                basic {
                    username = config.login
                    password = config.token
                    sendWithoutRequest = true
                }
            }

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
