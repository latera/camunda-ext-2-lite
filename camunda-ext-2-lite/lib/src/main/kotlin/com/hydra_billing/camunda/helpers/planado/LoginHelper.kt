package com.hydra_billing.camunda.helpers.planado

import com.hydra_billing.camunda.helpers.common.ConfigHelper
import com.hydra_billing.camunda.http_clients.PlanadoRestClient
import io.ktor.client.*

object LoginHelper {
    fun getPlanadoClient(planadoConfig: ConfigHelper.PlanadoConfig = ConfigHelper.getDefaultPlanadoConfig()): HttpClient {
        val config = PlanadoRestClient.Config(url = planadoConfig.url, token = planadoConfig.token, timeout = planadoConfig.timeout)
        return PlanadoRestClient.getClient(config)
    }
}
