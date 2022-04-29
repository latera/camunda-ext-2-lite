package com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers

import com.hydra_billing.camunda.Logger.*
import com.hydra_billing.camunda.api.hydra.common_types.AdditionalValue
import com.hydra_billing.camunda.api.hydra.common_types.SubjectState
import com.hydra_billing.camunda.api.hydra.common_types.SubjectType
import io.ktor.client.HttpClient
import io.ktor.client.request.*
import kotlinx.coroutines.*
import java.util.*

class Customer(val client: HttpClient) {
    companion object : Logged {
        val logger = getLogger()
    }

    data class CreateParams(
        val vc_code: String? = null,
        val n_base_subject_id: Long,
        val t_tags: Array<String>? = null,
        val n_subj_group_id: Long,
        val group_ids: Array<Long>? = null,
        val vc_rem: String? = null,
        val n_reseller_id: Long? = null,
        val additional_values: Array<AdditionalValue>? = null
    )

    data class UpdateParams(
        val n_subj_state_id: SubjectState? = null,
        val vc_code: String? = null,
        val t_tags: Array<String>? = null,
        val n_subj_group_id: Long? = null,
        val group_ids: Array<Long>? = null,
        val vc_rem: String? = null,
        val n_reseller_id: Long? = null,
        val additional_values: Array<AdditionalValue>? = null
    )

    data class Customer(
        val n_subject_id: Long,
        val n_customer_id: Long,
        val n_base_subject_id: Long,
        val vc_base_subject_name: String,
        val n_base_subj_type_id: SubjectType,
        val n_subj_state_id: SubjectState,
        val vc_name: String,
        val vc_code: String,
        val d_created: String,
        val t_tags: Array<String>,
        val vc_rem: String?,
        val n_firm_id: Long,
        val n_subj_group_id: Long,
        val n_reseller_id: Long?,
        val group_ids: Array<Long>,
        val vc_base_subject_code: String,
        val additional_values: Array<AdditionalValue>
    )

    data class Response(val customer: Customer)

    fun create(params: CreateParams): Customer {
        val client = this.client

        logger.info("Create customer with $params")

        val response = runBlocking {
            client.post<Response> {
                url { encodedPath = "/rest/v2/subjects/customers/" }

                body = mapOf("customer" to params)
            }
        }

        return response.customer
    }

    fun get(id: Long): Customer {
        val client = this.client

        logger.info("Get customer by id=$id")

        val response = runBlocking {
            client.get<Response> { url { encodedPath = "/rest/v2/subjects/customers/$id" } }
        }

        return response.customer
    }

    fun update(id: Long, params: UpdateParams): Customer {
        val client = this.client

        logger.info("Update customer with id=$id")

        val response = runBlocking {
            client.put<Response> {
                url { encodedPath = "/rest/v2/subjects/customers/$id" }

                body = mapOf("customer" to params)
            }
        }

        return response.customer
    }
}
