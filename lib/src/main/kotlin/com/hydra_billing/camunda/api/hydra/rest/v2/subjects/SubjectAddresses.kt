package com.hydra_billing.camunda.api.hydra.rest.v2.subjects

import com.hydra_billing.camunda.Logger.*
import com.hydra_billing.camunda.api.hydra.common_types.AddressState
import com.hydra_billing.camunda.api.hydra.common_types.AddressType
import com.hydra_billing.camunda.api.hydra.common_types.BindAddressType
import io.ktor.client.HttpClient
import io.ktor.client.request.*
import kotlinx.coroutines.*

class SubjectAddresses(val client: HttpClient) {
    companion object : Logged {
        val logger = getLogger()
    }

    data class ListResponse(val subject_addresses: Array<Address>)

    data class Address(
        val n_address_id: Long,
        val n_addr_type_id: AddressType,
        val vc_code: String?,
        val vc_visual_code: String?,
        val vc_address: String?,
        val n_subj_address_id: Long,
        val n_subject_id: Long,
        val n_subj_addr_type_id: BindAddressType,
        val n_addr_state_id: AddressState,
        val vc_rem: String?,
        val vc_subj_addr_type_name: String,
        val c_fl_main: String,
        val n_par_addr_id: Long?,
        val n_bind_addr_id: Long?,
        val n_region_id: Long?,
        val d_begin: String?,
        val d_end: String?,
        val n_firm_id: Long?,
        val vc_entrance_no: String?,
        val n_floor_no: Long?,
        val vc_flat: String?,
        val vc_intercom_code: String?
    )

    fun list(subjectIds: Array<Long>): Array<Address> {
        val perPage = 1000
        var page = 1
        val client = this.client
        val result: ArrayList<Address> = ArrayList()

        logger.info("Get addresses for subjects ${subjectIds.joinToString() }")

        while (true) {
            val response = runBlocking {
                client.get<ListResponse> {
                    url { encodedPath = "/rest/v2/subject_addresses" }

                    subjectIds.forEach { parameter("subject_id[]", it) }
                    parameter("page", page)
                    parameter("per_page", perPage)
                }
            }
            result.addAll(response.subject_addresses)
            page += 1

            if (response.subject_addresses.size < perPage) {
                break
            }
        }

        return result.toTypedArray()
    }
}
