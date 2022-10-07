package com.hydra_billing.camunda.helpers.hydra.oms

import com.hydra_billing.camunda.helpers.common.ConfigHelper
import com.hydra_billing.camunda.http_clients.HomsClient
import io.ktor.client.HttpClient

object LoginHelper {
    fun getHomsClient(config: HomsClient.Config = ConfigHelper.getDefaultHOMSConfig()): HttpClient {
        return HomsClient.getClient(config)
    }
}
