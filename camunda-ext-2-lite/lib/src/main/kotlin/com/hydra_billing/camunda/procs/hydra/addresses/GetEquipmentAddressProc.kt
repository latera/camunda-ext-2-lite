package com.hydra_billing.camunda.procs.hydra.addresses

import com.hydra_billing.camunda.api.hydra.rest.v2.net_devices.Address
import com.hydra_billing.camunda.api.hydra.rest.v2.net_devices.types.*
import com.hydra_billing.camunda.helpers.camunda.getLong
import com.hydra_billing.camunda.helpers.common.DataClassHelper
import com.hydra_billing.camunda.helpers.hydra.rest.v2.LoginHelper
import com.hydra_billing.camunda.procs.BaseProc
import io.ktor.client.*
import org.camunda.bpm.engine.delegate.DelegateExecution

/**
 * This delegate is designed to show equipment address via Hydra REST API.
 *
 * This delegate is using the following execution variables:
 * - <code>hydraEquipmentId</code> - Equipment ID (*required) /Long/
 * - <code>hydraEquipmentAddressId</code> - Equipment address ID (*required) /Long/
 *
 * The result of this delegate execution is the following variables stored in the Camunda execution:
 * - <code>hydraEquipmentAddress</code> -  Equipment address /net_devices.types.AddressParams/
 */
class GetEquipmentAddressProc : BaseProc() {

    override fun perform(execution: DelegateExecution) {
        val restApi = LoginHelper.getRestApiClient()
        val equipmentId = getLong(execution, "hydraEquipmentId")
        val addressId = getLong(execution, "hydraEquipmentAddressId")
        setToExecution(execution, doAction(restApi, equipmentId, addressId))
    }

    fun doAction(
        restApi: HttpClient,
        equipmentId: Long,
        addressId: Long
    ): AddressParams {
        return Address(restApi).get(equipmentId, addressId)
    }

    private fun setToExecution(
        execution: DelegateExecution,
        equipmentAddress: AddressParams
    ) {
        execution.setVariable(
            "hydraEquipmentAddress",
            DataClassHelper.convertDataClassToMap<AddressParams>(
                equipmentAddress
            )
        )
    }
}
