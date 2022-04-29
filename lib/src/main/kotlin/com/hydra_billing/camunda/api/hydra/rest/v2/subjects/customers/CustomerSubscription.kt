package com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers

import com.hydra_billing.camunda.Logger.*
import com.hydra_billing.camunda.api.hydra.common_types.ChargeLogCreatingState
import io.ktor.client.HttpClient
import io.ktor.client.request.*
import kotlinx.coroutines.*
import java.util.ArrayList

class CustomerSubscription(val client: HttpClient) {
    companion object : Logged {
        val logger = getLogger()
    }

    data class CreateParams(
        val n_service_id: Long,
        val n_par_subscription_id: Long? = null,
        val n_account_id: Long,
        val n_object_id: Long?,
        val n_contract_id: Long,
        val d_begin: String? = null,
        val n_quant: Long? = null,
        val d_end: String? = null
    )

    data class CustomerSubscription(
        val n_subscription_id: Long,
        val n_service_id: Long,
        val n_customer_id: Long,
        val n_account_id: Long,
        val n_object_id: Long,
        val n_quant: Long?,
        val n_unit_id: Long?,
        val d_begin: String,
        val d_end: String?,
        val c_fl_closed: String,
        val n_line_no: Long,
        val n_par_subscription_id: Long?,
        val n_prev_subscription_id: Long?,
        val n_cl_creating_state_id: ChargeLogCreatingState,
        val n_contract_id: Long
    )

    data class Response(val subscription: CustomerSubscription)
    data class ListResponse(val subscriptions: Array<CustomerSubscription>)

    fun create(params: CreateParams, customerId: Long): CustomerSubscription {
        val client = this.client

        logger.info("Create subscription for customer $customerId with $params")

        val response = runBlocking {
            client.post<Response> {
                url { encodedPath = "/rest/v2/subjects/customers/$customerId/subscriptions" }

                body = mapOf("subscription" to params)
            }
        }

        return response.subscription
    }

    fun get(customerId: Long, subscriptionId: Long): CustomerSubscription {
        val client = this.client

        logger.info("Get subscription for customer $customerId with id $subscriptionId")

        val response = runBlocking {
            client.get<Response> {
                url { encodedPath = "/rest/v2/subjects/customers/$customerId/subscriptions/$subscriptionId" }
            }
        }

        return response.subscription
    }

    fun list(customerId: Long): Array<CustomerSubscription> {
        val perPage = 1000
        var page = 1
        val client = this.client

        val result: ArrayList<CustomerSubscription> = ArrayList()

        logger.info("Show subscription list for customer $customerId")

        while (true) {
            val response = runBlocking {
                client.get<ListResponse> {
                    url { encodedPath = "/rest/v2/subjects/customers/$customerId/subscriptions" }
                    parameter("page", page)
                    parameter("per_page", perPage)
                }
            }
            result.addAll(response.subscriptions)
            page += 1

            if (response.subscriptions.size < perPage) {
                break
            }
        }
        return result.toTypedArray()
    }
}
