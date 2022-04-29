package com.hydra_billing.camunda.xml_rpc_clients

import org.apache.ws.commons.util.NamespaceContextImpl
import org.apache.xmlrpc.client.XmlRpcClient
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl
import org.apache.xmlrpc.common.TypeFactoryImpl
import org.apache.xmlrpc.common.XmlRpcController
import org.apache.xmlrpc.common.XmlRpcStreamConfig
import org.apache.xmlrpc.parser.NullParser
import org.apache.xmlrpc.parser.TypeParser
import org.apache.xmlrpc.serializer.NullSerializer
import org.apache.xmlrpc.serializer.TypeSerializer
import java.net.URL

object HidClient {
    data class Config(val url: String, val user: String, val password: String, val timeout: Int)

    fun getClient(config: Config): XmlRpcClient {
        val client = XmlRpcClient()
        val cfg = XmlRpcClientConfigImpl()

        cfg.serverURL = URL(config.url)
        cfg.basicUserName = config.user
        cfg.basicPassword = config.password
        cfg.connectionTimeout = config.timeout
        cfg.replyTimeout = config.timeout
        cfg.setEnabledForExtensions(true)
        client.setTypeFactory(XmlRpcTypeNil(client))
        client.setConfig(cfg)

        return client
    }
}

class XmlRpcTypeNil(pController: XmlRpcController?) : TypeFactoryImpl(pController) {
    override fun getParser(
        pConfig: XmlRpcStreamConfig,
        pContext: NamespaceContextImpl,
        pURI: String,
        pLocalName: String
    ): TypeParser {
        return if (NullSerializer.NIL_TAG == pLocalName || NullSerializer.EX_NIL_TAG == pLocalName)
            NullParser()
        else super.getParser(pConfig, pContext, pURI, pLocalName)
    }

    override fun getSerializer(pConfig: XmlRpcStreamConfig, pObject: Any): TypeSerializer {
        return if (pObject is XmlRpcTypeNil) NullSerializer() else super.getSerializer(pConfig, pObject)
    }
}
