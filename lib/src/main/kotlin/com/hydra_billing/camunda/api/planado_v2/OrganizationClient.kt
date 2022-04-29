package com.hydra_billing.camunda.api.planado_v2

import com.hydra_billing.camunda.api.planado_v2.common_types.Contact
import com.hydra_billing.camunda.api.planado_v2.common_types.SiteAddress
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.runBlocking

class OrganizationClient(val client: HttpClient) {
    private val initialPath = "/v2/clients"

    data class CreateParams(
        val organization: Boolean = true,
        val organization_name: String,
        val external_id: String? = null,
        val site_address: SiteAddress? = null,
        val contacts: Array<Contact>? = arrayOf<Contact>()
    )

    data class UpdateParams(
        val organization: Boolean = true,
        val organization_name: String = "",
        val site_address: SiteAddress? = null,
        val contacts: Array<Contact>? = arrayOf<Contact>()
    )

    data class ClientData(
        val uuid: String? = null,
        val external_id: String? = null,
        val name: String? = null,
        val organization_name: String? = null,
        val organization: Boolean? = null,
        val first_name: String? = null,
        val last_name: String? = null,
        val middle_name: String? = null,
        val site_address: SiteAddress? = null,
        val contacts: Array<Contact>,
        val version: Long? = null,
        val created_at: String? = null,
        val updated_at: String? = null
    )

    data class GetResponse(val client: ClientData)

    data class CreateOrUpdateResponse(val client_uuid: String)

    /**
     * - <code>id</code> - Client uuid or external_id /String/
     */
    fun get(id: String): ClientData {
        val path = "$initialPath/$id"
        val response = runBlocking { client.get<GetResponse> { url { encodedPath = path } } }
        return response.client
    }

    fun create(params: CreateParams): CreateOrUpdateResponse {
        val path = "$initialPath"
        return runBlocking {
            client.post<CreateOrUpdateResponse> {
                url { encodedPath = path }
                body = params
            }
        }
    }

    /**
     * - <code>id</code> - Client uuid or external_id /String/
     */
    fun update(id: String, params: UpdateParams): CreateOrUpdateResponse {
        val path = "$initialPath/$id"
        return runBlocking {
            client.patch<CreateOrUpdateResponse> {
                url { encodedPath = path }
                body = params
            }
        }
    }
}
