package com.hydra_billing.camunda.http_clients

import io.ktor.client.HttpClient
import io.ktor.client.engine.apache.Apache
import io.ktor.client.features.*
import io.ktor.client.features.auth.Auth
import io.ktor.client.features.auth.providers.*
import io.ktor.client.request.*
import io.ktor.http.URLBuilder
import org.apache.http.conn.ssl.*
import org.apache.http.ssl.SSLContextBuilder

object HomsClient {
    data class Config(
        val url: String,
        val useSSL: Boolean = true,
        val user: String,
        val password: String,
        val timeout: HTTPTimeoutsConfig,
        val token: String? = null
    )

    fun getClient(config: Config): HttpClient {
        val urlObject = URLBuilder(config.url)

        return HttpClient(Apache) {
            installGsonSerializer()
            installTimeOutConfig(config.timeout)

            HttpResponseValidator {
                errorValidation()
            }

            install(Auth) {
                basic {
                    username = config.user
                    password = config.password
                    sendWithoutRequest = true
                }
            }

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
            }
        }
    }
}
