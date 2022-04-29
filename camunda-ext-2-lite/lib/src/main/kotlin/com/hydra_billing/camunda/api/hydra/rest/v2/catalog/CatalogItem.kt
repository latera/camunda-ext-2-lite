package com.hydra_billing.camunda.api.hydra.rest.v2.catalog

import com.hydra_billing.camunda.Logger.*
import com.hydra_billing.camunda.api.hydra.common_types.AdditionalValue
import com.hydra_billing.camunda.api.hydra.common_types.CatalogItemGroup
import com.hydra_billing.camunda.api.hydra.common_types.CatalogItemType
import io.ktor.client.HttpClient
import io.ktor.client.request.*
import kotlinx.coroutines.*

class CatalogItem(val client: HttpClient) {
    companion object : Logged {
        val logger = getLogger()
    }

    data class CatalogItem(
        val n_good_group_id: CatalogItemGroup,
        val n_unit_id: Long? = null,
        val vc_code: String,
        val vc_name: String,
        val n_quant: Long?,
        val t_tags: Array<String>,
        val vc_tags: String?,
        val n_service_id: Long,
        val n_service_type_id: CatalogItemType,
        val n_base_service_id: Long?,
        val n_parent_service_id: Long?,
        val vc_service_code: String,
        val vc_service_name: String,
        val additional_values: Array<AdditionalValue>
    )

    data class Response(val catalog: CatalogItem)

    fun get(catalogItemId: Long): CatalogItem {
        val client = this.client

        logger.info("Get catalog item by id=$catalogItemId")

        val response = runBlocking {
            client.get<Response> { url { encodedPath = "/rest/v2/catalog/$catalogItemId" } }
        }

        return response.catalog
    }
}
