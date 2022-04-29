package com.hydra_billing.camunda.api.hydra.rest.v2

import com.hydra_billing.camunda.Logger.*
import com.hydra_billing.camunda.api.hydra.common_types.Language
import io.ktor.client.HttpClient
import io.ktor.client.request.*
import kotlinx.coroutines.*

class Reference(val client: HttpClient) {
    companion object : Logged {
        val logger = getLogger()
    }

    data class ListResponse(val references: Array<Reference>)
    data class Response(val reference: Reference)

    data class Reference(
        val n_ref_id: Long,
        val n_par_ref_id: Long?,
        val n_ref_type_id: Long,
        val n_ref_base_id: Long?,
        val n_firm_id: Long?,
        val vc_name: String,
        val vc_code: String,
        val vc_value: String?,
        val vc_value_2: String?,
        val vc_value_3: String?,
        val c_value: String?,
        val c_value_2: String?,
        val c_value_3: String?,
        val d_value: String?,
        val d_value_2: String?,
        val d_value_3: String?,
        val n_value: Long?,
        val n_value_2: Long?,
        val n_value_3: Long?,
        val c_fl_editable: String,
        val c_fl_manual: String,
        val n_lang_id: Language
    )

    fun listByTypeCode(code: String): Array<Reference> {
        val perPage = 1000
        var page = 1
        val client = this.client
        val result: ArrayList<Reference> = ArrayList()

        logger.info("Get child references for code $code")

        while (true) {
            val response = runBlocking {
                client.get<ListResponse> {
                    url { encodedPath = "/rest/v2/references" }

                    parameter("ref_type_code", code)
                    parameter("page", page)
                    parameter("per_page", perPage)
                }
            }
            result.addAll(response.references)
            page += 1

            if (response.references.size < perPage) {
                break
            }
        }

        return result.toTypedArray()
    }

    fun getByCode(code: String): Reference {
        val client = this.client

        logger.info("Get reference by code=$code")

        val response = runBlocking {
            client.get<Response> { url { encodedPath = "/rest/v2/references/$code" } }
        }

        return response.reference
    }
}
