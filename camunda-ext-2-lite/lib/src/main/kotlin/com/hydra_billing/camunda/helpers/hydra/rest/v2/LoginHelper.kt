package com.hydra_billing.camunda.helpers.hydra.rest.v2

import com.hydra_billing.camunda.api.hydra.rest.v2.Login
import com.hydra_billing.camunda.helpers.common.ConfigHelper
import com.hydra_billing.camunda.http_clients.HydraRestClient
import io.ktor.client.HttpClient

object LoginHelper {
    fun getRestApiClient(restConfig: ConfigHelper.RestConfig = ConfigHelper.getDefaultRestConfig()): HttpClient {
        val config = HydraRestClient.Config(
            url = restConfig.url,
            useSSL = restConfig.useSSL,
            timeout = restConfig.timeout
        )

        val client = HydraRestClient.getClient(config)
        val loginParams = Login.LoginParams(login = restConfig.login, password = restConfig.password)
        val token: String = Login(client).login(loginParams).token
        return HydraRestClient.getClient(config.copy(token = token))
    }
}
