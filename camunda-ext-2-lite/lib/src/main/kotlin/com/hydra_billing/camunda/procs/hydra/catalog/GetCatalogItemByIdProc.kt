package com.hydra_billing.camunda.procs.hydra.catalog

import com.hydra_billing.camunda.api.hydra.rest.v2.catalog.CatalogItem
import com.hydra_billing.camunda.helpers.camunda.getLong
import com.hydra_billing.camunda.helpers.common.DataClassHelper
import com.hydra_billing.camunda.helpers.hydra.rest.v2.LoginHelper
import com.hydra_billing.camunda.procs.BaseProc
import io.ktor.client.*
import org.camunda.bpm.engine.delegate.DelegateExecution

/**
 * This delegate is designed to show a catalog item via Hydra REST API.
 *
 * This delegate is using the following execution variables:
 * - <code>hydraCatalogItemId</code> - Catalog item ID (*required) /Long/
 *
 * The result of this delegate execution is the following variables stored in the Camunda execution:
 * - <code>hydraCatalogItem</code> -  Catalog item /CatalogItem.CatalogItem/
 */
class GetCatalogItemByIdProc : BaseProc() {

    override fun perform(execution: DelegateExecution) {
        val restApi = LoginHelper.getRestApiClient()
        val catalogItemId = getLong(execution, "hydraCatalogItemId")
        val catalogItem = doAction(restApi, catalogItemId)
        setToExecution(execution, catalogItem)
    }

    fun doAction(
        restApi: HttpClient,
        catalogItemId: Long
    ): CatalogItem.CatalogItem {
        return CatalogItem(restApi).get(catalogItemId)
    }

    private fun setToExecution(
        execution: DelegateExecution,
        catalogItem: CatalogItem.CatalogItem
    ) {
        execution.setVariable(
            "hydraCatalogItem",
            DataClassHelper.convertDataClassToMap<CatalogItem.CatalogItem>(
                catalogItem
            )
        )
    }
}
