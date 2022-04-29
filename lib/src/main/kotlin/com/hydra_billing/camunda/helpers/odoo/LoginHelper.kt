package com.hydra_billing.camunda.helpers.odoo

import com.hydra_billing.camunda.helpers.common.ConfigHelper
import com.hydra_billing.camunda.http_clients.OdooRestClient
import io.ktor.client.HttpClient

object LoginHelper {
    fun getOdooClient(odooConfig: ConfigHelper.OdooConfig = ConfigHelper.getDefaultOdooConfig()): HttpClient {
        val config = OdooRestClient.Config(
            url = odooConfig.url,
            useSSL = odooConfig.useSSL,
            oa_name = odooConfig.oa_name,
            login = odooConfig.login,
            token = odooConfig.token,
            timeout = odooConfig.timeout
        )
        return OdooRestClient.getClient(config)
    }
}
