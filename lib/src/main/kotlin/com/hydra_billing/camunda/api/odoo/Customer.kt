package com.hydra_billing.camunda.api.odoo

import com.hydra_billing.camunda.api.odoo.common_types.EntityTypes
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.runBlocking

class Customer(val client: HttpClient) {
    private val entityType = EntityTypes.Customer.value

    data class CustomerData(
        var id: Long? = null,
        var name: String? = null,
        var email: String? = null,
        var is_company: Boolean? = false,
        var company_name: String? = null,
        var company_id: Long? = null,
        var user_id: Long? = null,
        var phone: String? = null,
        var country_id: Long? = null,
        var state_id: Long? = null,
        var city: String? = null,
        var street: String? = null,
        var street2: String? = null,
        var zip: String? = null,
        var hydra_customer_id: String? = null,
        var comment: String? = null
    )

    data class SearchBody(
        val args: Array<Array<Array<Any>>>
    )

    fun getByNativeId(id: Long): CustomerData {
        return runBlocking {
            client.get<CustomerData>("$entityType/$id")
        }
    }

    fun getByHydraId(hydraCustomerId: Long): CustomerData {
        val response = runBlocking {
            client.patch<Array<Long>> {
                url { encodedPath += "$entityType/call/search" }
                body = SearchBody(
                    args = arrayOf(arrayOf(arrayOf("hydra_customer_id", "=", hydraCustomerId.toString())))
                )
            }
        }
        if (response.isNotEmpty()) {
            return getByNativeId(response[0])
        }
        return CustomerData()
    }

    fun create(params: CustomerData): CustomerData {
        return runBlocking {
            client.post<CustomerData> {
                url { encodedPath += "$entityType" }
                body = params
            }
        }
    }
}
