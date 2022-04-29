package com.hydra_billing.camunda.api.planado_v2

import com.hydra_billing.camunda.api.planado_v2.common_types.*
import com.hydra_billing.camunda.api.planado_v2.common_types.job.*
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.runBlocking

class Template(val client: HttpClient) {
    private val initial_path = "/v2/templates"

    data class TemplateData(
        val uuid: String,
        val name: String,
        val description: String? = null,
        val type: JobType? = null,
        val assignee: JobAssignee? = null,
        val territory: JobTerritory? = null,
        val skills: Array<Skill> = arrayOf(),
        val custom_fields: Array<JobCustomField> = arrayOf(),
        val report_fields: Array<JobCustomField> = arrayOf(),
        val possible_resolutions: Array<JobResolution> = arrayOf(),
        val created_at: String,
        val updated_at: String
    )

    data class GetResponse(val template: TemplateData)

    /**
     * - <code>id</code> - Template uuid or external_id /String/
     */
    fun get(id: String): TemplateData {
        val path = "$initial_path/$id"
        val response = runBlocking { client.get<GetResponse> { url { encodedPath = path } } }
        return response.template
    }
}
