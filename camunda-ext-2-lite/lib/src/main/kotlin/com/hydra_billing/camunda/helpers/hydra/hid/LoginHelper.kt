package com.hydra_billing.camunda.helpers.hydra.hid

import com.hydra_billing.camunda.helpers.common.ConfigHelper
import com.hydra_billing.camunda.xml_rpc_clients.HidClient
import org.apache.xmlrpc.client.XmlRpcClient

object LoginHelper {
    fun getHidClient(config: HidClient.Config = ConfigHelper.getDefaultHIDConfig()): XmlRpcClient {
        return HidClient.getClient(config)
    }
}
