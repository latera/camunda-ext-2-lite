package com.hydra_billing.camunda.api.hydra.rest.v2.subjects.persons

import com.hydra_billing.camunda.Logger.*
import com.hydra_billing.camunda.api.hydra.common_types.AddressState
import com.hydra_billing.camunda.api.hydra.common_types.AddressType
import com.hydra_billing.camunda.api.hydra.common_types.BindAddressType
import io.ktor.client.HttpClient
import io.ktor.client.request.*
import kotlinx.coroutines.*

class PersonAddress(val client: HttpClient) {
    companion object : Logged {
        val logger = getLogger()
    }
    data class CreateParams(
        val n_addr_type_id: AddressType,
        val n_subj_addr_type_id: BindAddressType,
        val vc_address: String? = null,
        val vc_code: String? = null,
        val n_addr_state_id: AddressState,
        val n_floor_no: Long? = null,
        val n_region_id: Long? = null,
        val d_begin: String? = null,
        val d_end: String? = null,
        val vc_rem: String? = null,
        val c_fl_main: String? = null,
        val vc_intercom_code: String? = null,
        val vc_entrance_no: String? = null,
        val vc_flat: String? = null,
        val n_bind_addr_id: Long? = null,
        val n_par_addr_id: Long? = null
    )

    data class Response(val address: Address)

    data class Address(
        val n_address_id: Long,
        val n_addr_type_id: AddressType,
        val n_par_addr_id: Long?,
        val vc_code: String,
        val vc_visual_code: String,
        val vc_address: String,
        val vc_flat: String?,
        val n_region_id: Long,
        val vc_entrance_no: String?,
        val n_floor_no: Long?,
        val n_firm_id: Long?,
        val n_subj_address_id: Long,
        val n_subj_addr_type_id: BindAddressType,
        val n_addr_state_id: AddressState,
        val vc_rem: String?,
        val n_bind_addr_id: Long?,
        val d_begin: String?,
        val d_end: String?,
        val c_fl_main: String,
        val vc_intercom_code: String?
    )

    fun create(params: CreateParams, personId: Long): Address {
        val client = this.client

        logger.info("Create address for person $personId with $params")

        val response = runBlocking {
            client.post<Response> {
                url { encodedPath = "/rest/v2/subjects/persons/$personId/addresses" }

                body = mapOf("address" to params)
            }
        }

        return response.address
    }
}
