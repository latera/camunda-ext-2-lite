package com.hydra_billing.camunda.procs.hydra.objects

import com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers.CustomerEquipment
import com.hydra_billing.camunda.helpers.camunda.getLong
import com.hydra_billing.camunda.helpers.camunda.getNullableLong
import com.hydra_billing.camunda.helpers.camunda.getNullableString
import com.hydra_billing.camunda.helpers.common.DataClassHelper
import com.hydra_billing.camunda.helpers.hydra.rest.v2.LoginHelper
import com.hydra_billing.camunda.procs.BaseProc
import io.ktor.client.*
import org.camunda.bpm.engine.delegate.DelegateExecution

/**
 * This delegate is designed to create a Customer equipment via Hydra REST API.
 *
 * This delegate is using the following execution variables:
 * - <code>hydraCustomerId</code> - Customer ID (*required) /Long/
 * - <code>hydraCustomerEquipmentGoodId</code> - Equipment good ID (*required*) /Long/
 * - <code>hydraCustomerEquipmentMainObjectId</code> - Equipment main object ID /Long?/
 * - <code>hydraCustomerEquipmentCode</code> - Equipment code /String?/
 *
 * The result of this delegate execution is the created Customer equipment and the following
 * variables stored in the Camunda execution:
 * - <code>hydraCustomerEquipment</code> - created Customer equipment /CustomerEquipment.CustomerEquipment/
 */
class CreateCustomerEquipmentProc : BaseProc() {

    override fun perform(execution: DelegateExecution) {
        val restApi = LoginHelper.getRestApiClient()
        val customerId = getLong(execution, "hydraCustomerId")
        val customerEquipment = doAction(restApi, customerId, prepareCustomerEquipmentParams(execution))
        setToExecution(execution, customerEquipment)
    }

    fun doAction(
        restApi: HttpClient,
        customerId: Long,
        createCustomerEquipmentParams: CustomerEquipment.CreateParams
    ): CustomerEquipment.CustomerEquipment {
        return CustomerEquipment(restApi).create(createCustomerEquipmentParams, customerId)
    }

    private fun prepareCustomerEquipmentParams(
        execution: DelegateExecution
    ): CustomerEquipment.CreateParams {
        return CustomerEquipment.CreateParams(
            n_good_id = getLong(execution, "hydraCustomerEquipmentGoodId"),
            n_main_object_id = getNullableLong(execution, "hydraCustomerEquipmentMainObjectId"),
            vc_code = getNullableString(execution, "hydraCustomerEquipmentCode")
        )
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
