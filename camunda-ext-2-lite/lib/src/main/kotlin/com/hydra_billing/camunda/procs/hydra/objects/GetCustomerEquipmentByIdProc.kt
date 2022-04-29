package com.hydra_billing.camunda.procs.hydra.objects

import com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers.CustomerEquipment
import com.hydra_billing.camunda.helpers.camunda.getLong
import com.hydra_billing.camunda.helpers.common.DataClassHelper
import com.hydra_billing.camunda.helpers.hydra.rest.v2.LoginHelper
import com.hydra_billing.camunda.procs.BaseProc
import io.ktor.client.*
import org.camunda.bpm.engine.delegate.DelegateExecution

/**
 * This delegate is designed to show a subjects equipments via Hydra REST API.
 *
 * This delegate is using the following execution variables:
 * - <code>hydraCustomerId</code> - Customer ID (*required) /Long/
 * - <code>hydraCustomerEquipmentId</code> - Equipment ID (*required) /Long/
 *
 * The result of this delegate execution is the following variables stored in the Camunda execution:
 * - <code>hydraCustomerEquipment</code> -  Customer equipment /CustomerEquipment.CustomerEquipment/
 */
class GetCustomerEquipmentByIdProc : BaseProc() {

    override fun perform(execution: DelegateExecution) {
        val restApi = LoginHelper.getRestApiClient()
        val customerId = getLong(execution, "hydraCustomerId")
        val equipmentId = getLong(execution, "hydraCustomerEquipmentId")
        val customerEquipment: CustomerEquipment.CustomerEquipment = doAction(restApi, customerId, equipmentId)
        setToExecution(execution, customerEquipment)
    }

    fun doAction(
        restApi: HttpClient,
        customerId: Long,
        equipmentId: Long
    ): CustomerEquipment.CustomerEquipment {
        return CustomerEquipment(restApi).getEquipmentById(customerId, equipmentId)
    }

    private fun setToExecution(
        execution: DelegateExecution,
        customerEquipment: CustomerEquipment.CustomerEquipment
    ) {
        execution.setVariable(
            "hydraCustomerEquipment",
            DataClassHelper.convertDataClassToMap<CustomerEquipment.CustomerEquipment>(
                customerEquipment
            )
        )
    }
}
