package com.hydra_billing.camunda.xml_rpc_clients.mock_clients

import org.apache.xmlrpc.client.XmlRpcClient

class SelectMockClient() : XmlRpcClient() {
    override fun execute(pMethodName: String?, pParams: Array<out Any>?): Any {
        val obj =
            arrayOf(
                "0",
                "1",
                null,
                "2",
                "not null string",
                null,
                "another not null string",
                "Y",
                null,
                "N",
                "123,1",
                null,
                "123.2"
            )
        val resultList = arrayOf(obj)
        return mapOf<Any, Any>("SelectResult" to resultList)
    }
}
