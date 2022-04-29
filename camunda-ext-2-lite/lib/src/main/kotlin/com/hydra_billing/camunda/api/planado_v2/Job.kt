package com.hydra_billing.camunda.api.planado_v2

import com.hydra_billing.camunda.api.planado_v2.common_types.*
import com.hydra_billing.camunda.api.planado_v2.common_types.job.*
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.runBlocking

class Job(val client: HttpClient) {
    private val initial_path = "/v2/jobs"

    data class CreateParams(
        val external_id: String? = null,
        val external_order_id: String? = null,
        val scheduled_at: String? = null,
        val scheduled_duration: JobDuration? = null,
        val description: String? = null,
        val assignee: JobAssignee? = null,
        val job_type: JobType? = null,
        val template: JobTemplate? = null,
        val client: JobClient? = null,
        val address: SiteAddress? = null,
        val site: JobSite? = null,
        val territory: JobTerritory? = null,
        val skills: Array<Skill> = arrayOf(),
        val contacts: Array<Contact> = arrayOf(),
        val custom_fields: Array<JobCustomField> = arrayOf(),
        val possible_resolutions: Array<JobResolution>? = null
    )

    data class UpdateParams(
        val external_id: String? = null,
        val external_order_id: String? = null,
        val scheduled_at: String? = null,
        val scheduled_duration: JobDuration? = null,
        val description: String? = null,
        val assignee: JobAssignee? = null,
        val client: JobClient? = null,
        val address: SiteAddress? = null,
        val site: JobSite? = null,
        val territory: JobTerritory? = null,
        val skills: Array<Skill>? = null,
        val contacts: Array<Contact>? = null,
        val custom_fields: Array<JobCustomField>? = null,
        val possible_resolutions: Array<JobResolution>? = null
    )

    data class JobData(
        val uuid: String? = null,
        val external_id: String? = null,
        val external_order_id: String? = null,
        val serial_no: Long,
        val status: String,
        val scheduled_at: String? = null,
        val scheduled_duration: JobDuration? = null,
        val description: String? = null,
        val assignee: JobAssignee? = null,
        val type: JobType? = null,
        val template: JobTemplate? = null,
        val client: JobClient? = null,
        val site: JobSite? = null,
        val territory: JobTerritory? = null,
        val skills: Array<Skill> = arrayOf(),
        val contacts: Array<Contact> = arrayOf(),
        val custom_fields: Array<JobCustomField> = arrayOf(),
        val report_fields: Array<JobCustomField> = arrayOf(),
        val possible_resolutions: Array<JobResolution> = arrayOf(),
        val resolution: JobResolution? = null,
        val created_at: String,
        val updated_at: String
    )

    data class GetResponse(val job: JobData)

    data class CreateOrUpdateResponse(val job_uuid: String)

    /**
     * - <code>id</code> - Job uuid or external_id /String/
     */
    fun get(id: String): JobData {
        val path = "$initial_path/$id"
        val response = runBlocking { client.get<GetResponse> { url { encodedPath = path } } }
        return response.job
    }

    fun create(params: CreateParams): CreateOrUpdateResponse {
        val path = "$initial_path"
        return runBlocking {
            client.post<CreateOrUpdateResponse> {
                url { encodedPath = path }
                body = params
            }
        }
    }

    /**
     * - <code>id</code> - Job uuid or external_id /String/
     */
    fun update(id: String, params: UpdateParams): CreateOrUpdateResponse {
        val path = "$initial_path/$id"
        return runBlocking {
            client.patch<CreateOrUpdateResponse> {
                url { encodedPath = path }
                body = params
            }
        }
    }
}
