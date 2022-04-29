package com.hydra_billing.camunda.api.odoo

import com.hydra_billing.camunda.api.odoo.common_types.EntityTypes
import io.ktor.client.HttpClient
import io.ktor.client.request.*
import kotlinx.coroutines.runBlocking

class Country(val client: HttpClient) {
    private val entityType = EntityTypes.Country.value

    data class CountryData(
        var id: Long? = null,
        var code: String? = null,
        var name: String? = null,
        var currency_id: Long? = null,
        var phone_code: Long? = null,
        var address_format: String? = null,
        var vat_label: String? = null
    )

    fun getByNativeId(id: Long): CountryData {
        val client = this.client
        return runBlocking {
            client.get<CountryData>("$entityType/$id")
        }
    }
}
