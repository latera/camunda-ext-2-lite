package com.hydra_billing.camunda.procs.hydra.addresses

import com.hydra_billing.camunda.api.hydra.rest.v2.net_devices.entries.Address
import com.hydra_billing.camunda.helpers.camunda.getLong
import com.hydra_billing.camunda.helpers.hydra.rest.v2.LoginHelper
import com.hydra_billing.camunda.procs.BaseProc
import io.ktor.client.*
import org.camunda.bpm.engine.delegate.DelegateExecution

/**
 * This delegate is designed to delete the equipment component address via Hydra REST API.
 *
 * This delegate is using the following execution variables:
 * - <code>hydraEquipmentId</code> - Equipment ID (*required*) /Long/
 * - <code>hydraEquipmentComponentId</code> - Equipment component ID (*required*) /Long/
 * - <code>hydraEquipmentComponentAddressId</code> - Equipment component address ID (*required*) /Long/
 *
 * The result of this delegate execution is the deleted Equipment component address and the following
 * variables stored in the Camunda execution:
 * - <code>hydraEquipmentComponentAddressDeleted</code> - Is Equipment component address deleted /Boolean/
 */
class DeleteEquipmentComponentAddressProc : BaseProc() {

    override fun perform(execution: DelegateExecution) {
        val restApi = LoginHelper.getRestApiClient()
        val equipmentId = getLong(execution, "hydraEquipmentComponentId")
        val equipmentComponentId = getLong(execution, "hydraEquipmentComponentId")
        val equipmentComponentAddressId = getLong(execution, "hydraEquipmentComponentAddressId")
        val isEquipmentComponentAddressDeleted = doAction(restApi, equipmentId, equipmentComponentId, equipmentComponentAddressId)
        setToExecution(execution, isEquipmentComponentAddressDeleted)
    }

    fun doAction(
        restApi: HttpClient,
        equipmentId: Long,
        equipmentComponentId: Long,
        equipmentComponentAddressId: Long
    ): Boolean {
        return Address(restApi)
            .delete(equipmentId, equipmentId, equipmentComponentId)
    }

    private fun setToExecution(
        execution: DelegateExecution,
        isEquipmentComponentAddressDeleted: Boolean
    ) {
        execution.setVariable(
            "hydraEquipmentComponentAddressDeleted", isEquipmentComponentAddressDeleted
        )
    }
}
