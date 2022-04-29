package com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers

import com.hydra_billing.camunda.Logger.*
import com.hydra_billing.camunda.api.hydra.common_types.AdditionalValue
import com.hydra_billing.camunda.api.hydra.common_types.DocumentState
import com.hydra_billing.camunda.api.hydra.common_types.DocumentType
import com.hydra_billing.camunda.api.hydra.common_types.DocumentWorkflow
import io.ktor.client.HttpClient
import io.ktor.client.request.*
import kotlinx.coroutines.*

class CustomerContract(val client: HttpClient) {
    companion object : Logged {
        val logger = getLogger()
    }
    data class CreateParams(
        val n_doc_type_id: DocumentType = DocumentType.CustomerContract,
        val n_provider_id: Long,
        val n_firm_id: Long,
        val n_workflow_id: DocumentWorkflow = DocumentWorkflow.SubscriberContract,
        val n_parent_doc_id: Long? = null,
        val vc_doc_no: String? = null,
        val d_doc: String? = null,
        val d_begin: String? = null,
        val d_end: String? = null,
        val vc_rem: String? = null
    )

    data class CustomerContract(
        val n_doc_id: Long,
        val n_doc_type_id: DocumentType,
        val n_doc_state_id: DocumentState,
        val n_parent_doc_id: Long,
        val n_workflow_id: DocumentWorkflow,
        val d_doc: String,
        val d_time: String,
        val vc_doc_no: String,
        val d_begin: String,
        val d_end: String?,
        val n_firm_id: Long,
        val vc_rem: String?,
        val n_provider_id: Long,
        val additional_values: Array<AdditionalValue>
    )

    data class Response(val contract: CustomerContract)

    fun create(params: CreateParams, customerId: Long): CustomerContract {
        val client = this.client

        logger.info("Create contract for customer $customerId with $params")

        val response = runBlocking {
            client.post<Response> {
                url { encodedPath = "/rest/v2/subjects/customers/$customerId/contracts" }

                body = mapOf("contract" to params)
            }
        }

        return response.contract
    }

    fun update(params: CustomerContract, customerId: Long): CustomerContract {
        val client = this.client

        logger.info("Update contract for customer $customerId with $params")

        val response = runBlocking {
            client.put<Response> {
                url {
                    encodedPath =
                        "/rest/v2/subjects/customers/$customerId/contracts/${params.n_doc_id}"
                }

                body = mapOf("contract" to params)
            }
        }
        return response.contract
    }

    fun get(customerId: Long, contractId: Long): CustomerContract {
        val client = this.client

        val response = runBlocking {
            client.get<Response> {
                url {
                    encodedPath = "/rest/v2/subjects/customers/$customerId/contracts/$contractId"
                }
            }
        }
        return response.contract
    }
}
