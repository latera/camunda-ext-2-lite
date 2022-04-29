package com.hydra_billing.camunda.api.hydra.rest.v2.subjects.persons

import com.hydra_billing.camunda.Logger.*
import com.hydra_billing.camunda.api.hydra.common_types.AdditionalValue
import com.hydra_billing.camunda.api.hydra.common_types.SubjectSex
import com.hydra_billing.camunda.api.hydra.common_types.SubjectState
import com.hydra_billing.camunda.api.hydra.common_types.SubjectType
import io.ktor.client.HttpClient
import io.ktor.client.request.*
import kotlinx.coroutines.*

class Person(val client: HttpClient) {
    companion object : Logged {
        val logger = getLogger()
    }

    data class CreateParams(
        val vc_first_name: String,
        val vc_surname: String,
        val vc_second_name: String? = null,
        val n_subj_state_id: SubjectState = SubjectState.On,
        val n_opf_id: Long? = null,
        val n_firm_id: Long? = 100,
        val n_sex_id: SubjectSex? = null,
        val vc_inn: String? = null,
        val vc_doc_serial: String? = null,
        val vc_doc_no: String? = null,
        val d_doc: String? = null,
        val vc_document: String? = null,
        val vc_doc_department: String? = null,
        val d_birth: String? = null,
        val vc_birth_place: String? = null,
        val vc_pens_insurance: String? = null,
        val vc_med_insurance: String? = null,
        val n_citizenship_id: Long? = null,
        val vc_kpp: String? = null,
        val vc_rem: String? = null,
        val t_tags: Array<String>? = null,
        val additional_values: Array<AdditionalValue>? = null
    )

    data class Response(val person: Person)

    data class Person(
        val n_person_id: Long,
        val n_opf_id: Long?,
        val vc_opf_code: String?,
        val vc_opf_name: String?,
        val vc_first_name: String,
        val vc_surname: String,
        val vc_second_name: String?,
        val n_sex_id: SubjectSex?,
        val vc_sex: String,
        val vc_inn: String?,
        val n_doc_auth_type_id: Long?,
        val vc_doc_auth_type_code: String?,
        val vc_doc_auth_type_name: String?,
        val vc_doc_serial: String?,
        val vc_doc_no: String?,
        val d_doc: String?,
        val vc_document: String?,
        val vc_doc_department: String?,
        val d_birth: String?,
        val vc_birth_place: String?,
        val vc_pens_insurance: String?,
        val vc_med_insurance: String?,
        val n_subject_id: Long,
        val n_subj_type_id: SubjectType,
        val n_parent_subj_id: Long?,
        val n_subj_state_id: SubjectState,
        val vc_subj_state_name: String,
        val n_base_subject_id: Long,
        val n_firm_id: Long,
        val vc_firm: String,
        val n_region_id: Long?,
        val vc_region: String?,
        val n_owner_id: Long,
        val vc_subj_name: String,
        val vc_subj_code: String,
        val vc_name: String,
        val vc_code: String,
        val d_created: String,
        val n_creator_id: Long?,
        val t_tags: Array<String>,
        val vc_tags: String?,
        val vc_rem: String?,
        val vc_code_upper: String,
        val vc_name_upper: String,
        val n_subj_group_id: Long,
        val vc_subj_group_name: String?,
        val n_citizenship_id: Long?,
        val vc_citizenship: String?,
        val vc_kpp: String?,
        val additional_values: Array<AdditionalValue>
    )

    fun create(params: CreateParams): Person {
        val client = this.client

        logger.info("Create person with $params")

        val response = runBlocking {
            client.post<Response> {
                url { encodedPath = "/rest/v2/subjects/persons/" }

                body = mapOf("person" to params)
            }
        }

        return response.person
    }
}
