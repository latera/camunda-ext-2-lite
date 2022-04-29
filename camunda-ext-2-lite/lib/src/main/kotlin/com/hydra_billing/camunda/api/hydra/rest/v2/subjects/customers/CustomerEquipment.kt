package com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers

import com.hydra_billing.camunda.Logger.*
import com.hydra_billing.camunda.api.hydra.common_types.AdditionalValue
import com.hydra_billing.camunda.api.hydra.common_types.ObjectState
import io.ktor.client.HttpClient
import io.ktor.client.request.*
import kotlinx.coroutines.*
import java.util.*

class CustomerEquipment(val client: HttpClient) {
    companion object : Logged {
        val logger = getLogger()
    }
    data class CreateParams(
        val n_good_id: Long,
        val n_main_object_id: Long? = null,
        val vc_code: String? = null
    )

    data class CustomerEquipment(
        val n_object_id: Long,
        val n_good_id: Long,
        val n_firm_id: Long,
        val n_obj_state_id: ObjectState,
        val vc_name: String,
        val vc_code: String,
        val vc_code_add: String?,
        val vc_rem: String?,
        val n_main_object_id: Long?,
        val n_owner_id: Long,
        val vc_serial_number: String?,
        val vc_inventory_number: String?,
        val d_warranty_end: String?,
        val additional_values: Array<AdditionalValue>
    )

    data class Response(val equipment: CustomerEquipment)
    data class ListResponse(val equipment: Array<CustomerEquipment>)

    fun create(params: CreateParams, customerId: Long): CustomerEquipment {
        val client = this.client

        logger.info("Create equipment for customer $customerId with $params")

        val response = runBlocking {
            client.post<Response> {
                url { encodedPath = "/rest/v2/subjects/customers/$customerId/equipment" }

                body = mapOf("equipment" to params)
            }
        }

        return response.equipment
    }

    fun list(customerId: Long): Array<CustomerEquipment> {
        val perPage = 1000
        var page = 1
        val client = this.client

        val result: ArrayList<CustomerEquipment> = ArrayList()

        logger.info("Show equipment list for customer $customerId")
        while (true) {
            val response = runBlocking {
                client.get<ListResponse> {
                    url { encodedPath = "/rest/v2/subjects/customers/$customerId/equipment" }
                    parameter("page", page)
                    parameter("per_page", perPage)
                }
            }
            result.addAll(response.equipment)
            page += 1

            if (response.equipment.size < perPage) {
                break
            }
        }
        return result.toTypedArray()
    }

    fun getEquipmentById(customerId: Long, equipmentId: Long): CustomerEquipment {
        logger.info("Get equipment by customerId $customerId and equipmentId $equipmentId")

        val client = this.client
        val response = runBlocking {
            client.get<Response> {
                url { encodedPath = "/rest/v2/subjects/customers/$customerId/equipment/$equipmentId" }
            }
        }

        return response.equipment
    }
}
