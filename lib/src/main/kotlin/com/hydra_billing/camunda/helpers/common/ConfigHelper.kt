package com.hydra_billing.camunda.helpers.common

import com.hydra_billing.camunda.http_clients.*

object ConfigHelper {
    // default timeout 3 min
    const val defaultRequestTimeout: Long = 180000
    const val defaultConnectTimeout: Long = 60000
    const val defaultSocketTimeout: Long = 60000

    fun getDefaultHOMSConfig(): HomsClient.Config {
        return HomsClient.Config(
            url = System.getenv("HOMS_URL").orEmpty(),
            user = System.getenv("HOMS_USER").orEmpty(),
            password = System.getenv("HOMS_TOKEN").orEmpty(),
            useSSL = System.getenv("HOMS_SSL").orEmpty().toBoolean(),
            timeout = HTTPTimeoutsConfig(
                requestTimeout = System.getenv("HOMS_REQUEST_TIMEOUT")?.toLongOrNull() ?: defaultRequestTimeout,
                connectTimeout = System.getenv("HOMS_CONNECT_TIMEOUT")?.toLongOrNull() ?: defaultConnectTimeout,
                socketTimeout = System.getenv("HOMS_SOCKET_TIMEOUT")?.toLongOrNull() ?: defaultSocketTimeout
            )
        )
    }
}
