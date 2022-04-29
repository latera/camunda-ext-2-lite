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
 * This delegate is designed to show equipment addresses via Hydra REST API.
 *
 * This delegate is using the following execution variables:
 * - <code>hydraEquipmentId</code> - Equipment ID (*required) /Long/
 *
 * The result of this delegate execution is the following variables stored in the Camunda execution:
 * - <code>hydraEquipmentAddresses</code> - array of Address /net_devices.types.AddressParams/
 */
class GetEquipmentAddressesProc : BaseProc() {

    override fun perform(execution: DelegateExecution) {
        val restApi = LoginHelper.getRestApiClient()
        val equipmentId = getLong(execution, "hydraEquipmentId")
        val equipmentAddresses: Array<AddressParams> = doAction(restApi, equipmentId)
        setToExecution(execution, equipmentAddresses)
    }

    fun doAction(
        restApi: HttpClient,
        equipmentId: Long,
    ): Array<AddressParams> {
        return Address(restApi).list(equipmentId)
    }

    private fun setToExecution(
        execution: DelegateExecution,
        addresses: Array<AddressParams>
    ) {
        execution.setVariable(
            "hydraEquipmentAddresses",
            DataClassHelper.convertArrayOfDataClassToArrayOfMap<AddressParams>(
                addresses
            )
        )
    }
}
