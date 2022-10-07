package com.hydra_billing.camunda.http_clients

import com.hydra_billing.camunda.exceptions.*
import io.ktor.client.HttpClientConfig
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.statement.*
import java.net.ConnectException

data class HTTPTimeoutsConfig(
    val requestTimeout: Long,
    val connectTimeout: Long,
    val socketTimeout: Long
)

fun HttpClientConfig<*>.installGsonSerializer() = install(JsonFeature) {
    serializer =
        GsonSerializer {
            disableHtmlEscaping()
            registerTypeAdapterFactory(NullableTypeAdapterFactory())
        }
}

fun HttpClientConfig<*>.installTimeOutConfig(config: HTTPTimeoutsConfig) = install(HttpTimeout) {
    requestTimeoutMillis = config.requestTimeout
    connectTimeoutMillis = config.connectTimeout
    socketTimeoutMillis = config.socketTimeout
}

fun HttpCallValidator.Config.errorValidation() {
    handleResponseException { exception ->
        when (exception) {
            is ResponseException -> {
                val exceptionResponse = exception.response
                val statusCode = exceptionResponse.status.value
                if (statusCode !in 200..299) {
                    val exceptionResponseText = exceptionResponse.readText()
                    when (exceptionResponse.status.value) {
                        in 300..399 -> throw RedirectException(statusCode, exceptionResponseText)
                        in 400..499 -> throw BadRequestException(statusCode, exceptionResponseText)
                        in 500..599 -> throw ServerErrorException(statusCode, exceptionResponseText)
                    }
                }
            }
            is ConnectException -> throw ConnectionException(exception.toString())
            else -> {
                return@handleResponseException
            }
        }
    }
}
