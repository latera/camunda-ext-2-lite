package com.hydra_billing.camunda.helpers.common

import com.hydra_billing.camunda.api.SMTPApi
import com.hydra_billing.camunda.http_clients.GoogleMapClient
import com.hydra_billing.camunda.http_clients.HomsClient
import com.hydra_billing.camunda.http_clients.ImprintClient
import com.hydra_billing.camunda.xml_rpc_clients.HidClient

object ConfigHelper {
    data class RestConfig(
        val url: String,
        val useSSL: Boolean,
        val login: String,
        val password: String,
        val timeout: Long
    )

    data class OdooConfig(
        val url: String,
        val useSSL: Boolean,
        val login: String,
        val token: String,
        val oa_name: String,
        val timeout: Long
    )

    data class PlanadoConfig(
        val url: String,
        val token: String,
        val timeout: Long
    )

    // default timeout 3 min
    const val defaultTimeout: Long = 180000

    fun getDefaultRestConfig(): RestConfig {
        return RestConfig(
            url = System.getenv("HOPER_URL").orEmpty(),
            useSSL = System.getenv("HOPER_USE_SSL").orEmpty().toBoolean(),
            login = System.getenv("HOPER_USER").orEmpty(),
            password = System.getenv("HOPER_PASSWORD").orEmpty(),
            timeout = System.getenv("HOPER_TIMEOUT")?.toLongOrNull() ?: defaultTimeout
        )
    }

    fun getDefaultGoogleMapConfig(): GoogleMapClient.Config {
        return GoogleMapClient.Config(
            url = System.getenv("GOOGLE_MAPS_URL").orEmpty(),
            token = System.getenv("GOOGLE_MAPS_TOKEN").orEmpty(),
            timeout = System.getenv("GOOGLE_MAPS_TIMEOUT")?.toLongOrNull() ?: defaultTimeout
        )
    }

    fun getDefaultHOMSConfig(): HomsClient.Config {
        return HomsClient.Config(
            url = System.getenv("HOMS_URL").orEmpty(),
            user = System.getenv("HOMS_USER").orEmpty(),
            password = System.getenv("HOMS_TOKEN").orEmpty(),
            useSSL = System.getenv("HOMS_SSL").orEmpty().toBoolean(),
            timeout = System.getenv("HOMS_TIMEOUT")?.toLongOrNull() ?: defaultTimeout
        )
    }

    fun getDefaultImprintConfig(): ImprintClient.Config {
        return ImprintClient.Config(
            url = System.getenv("IMPRINT_URL").orEmpty(),
            version = System.getenv("IMPRINT_VERSION").orEmpty(),
            token = System.getenv("IMPRINT_TOKEN").orEmpty(),
            useSSL = System.getenv("IMPRINT_SSL").orEmpty().toBoolean(),
            timeout = System.getenv("IMPRINT_TIMEOUT")?.toLongOrNull() ?: defaultTimeout
        )
    }

    fun getDefaultOdooConfig(): OdooConfig {
        return OdooConfig(
            url = System.getenv("ODOO_URL").orEmpty(),
            useSSL = System.getenv("ODOO_USE_SSL").orEmpty().toBoolean(),
            login = System.getenv("ODOO_USER").orEmpty(),
            token = System.getenv("ODOO_TOKEN").orEmpty(),
            oa_name = System.getenv("ODOO_OA_NAME").orEmpty(),
            timeout = System.getenv("ODOO_TIMEOUT")?.toLongOrNull() ?: defaultTimeout
        )
    }

    fun getDefaultHIDConfig(): HidClient.Config {
        return HidClient.Config(
            url = System.getenv("HID_URL").orEmpty(),
            user = System.getenv("HID_USER").orEmpty(),
            password = System.getenv("HID_PASSWORD").orEmpty(),
            timeout = System.getenv("HID_TIMEOUT")?.toIntOrNull() ?: defaultTimeout.toInt()
        )
    }

    fun getDefaultSMTPConfig(): SMTPApi.Config {
        return SMTPApi.Config(
            host = System.getenv("SMTP_HOST").orEmpty(),
            port = System.getenv("SMTP_PORT").toIntOrNull() ?: 587,
            user = System.getenv("SMTP_USER").orEmpty(),
            password = System.getenv("SMTP_PASSWORD").orEmpty(),
            tls = System.getenv("SMTP_TLS").orEmpty().toBoolean(),
            ssl = System.getenv("SMTP_SSL").orEmpty().toBoolean(),
            timeout = System.getenv("SMTP_TIMEOUT")?.toLongOrNull() ?: defaultTimeout
        )
    }

    fun getDefaultPlanadoConfig(): PlanadoConfig {
        return PlanadoConfig(
            url = System.getenv("PLANADO_URL").orEmpty(),
            token = System.getenv("PLANADO_TOKEN").orEmpty(),
            timeout = System.getenv("PLANADO_TIMEOUT")?.toLongOrNull() ?: defaultTimeout
        )
    }
}
