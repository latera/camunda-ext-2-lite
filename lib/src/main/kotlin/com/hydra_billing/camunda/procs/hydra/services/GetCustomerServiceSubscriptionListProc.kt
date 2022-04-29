package com.hydra_billing.camunda.procs.hydra.objects

import com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers.CustomerSubscription
import com.hydra_billing.camunda.helpers.camunda.getLong
import com.hydra_billing.camunda.helpers.common.DataClassHelper
import com.hydra_billing.camunda.helpers.hydra.rest.v2.LoginHelper
import com.hydra_billing.camunda.procs.BaseProc
import io.ktor.client.*
import org.camunda.bpm.engine.delegate.DelegateExecution

/**
 * This delegate is designed to show a subject subscription list via Hydra REST API.
 *
 * This delegate is using the following execution variables:
 * - <code>hydraCustomerId</code> - Customer ID (*required) /Long/
 *
 * The result of this delegate execution is the following variables stored in the Camunda execution:
 * - <code>hydraCustomerServiceSubscriptionList</code> - Array of CustomerSubscription /Array<CustomerSubscription.CustomerSubscription>/
 */
class GetCustomerServiceSubscriptionListProc : BaseProc() {

    override fun perform(execution: DelegateExecution) {
        val restApi = LoginHelper.getRestApiClient()
        val customerId = getLong(execution, "hydraCustomerId")
        val customerEquipmentList: Array<CustomerSubscription.CustomerSubscription> = doAction(restApi, customerId)
        setToExecution(execution, customerEquipmentList)
    }

    fun doAction(
        restApi: HttpClient,
        customerId: Long,
    ): Array<CustomerSubscription.CustomerSubscription> {
        return CustomerSubscription(restApi).list(customerId)
    }

    private fun setToExecution(
        execution: DelegateExecution,
        customerServiceSubscriptionList: Array<CustomerSubscription.CustomerSubscription>
    ) {
        execution.setVariable(
            "hydraCustomerServiceSubscriptionList",
            DataClassHelper.convertArrayOfDataClassToArrayOfMap<CustomerSubscription.CustomerSubscription>(
                customerServiceSubscriptionList
            )
        )
    }
}
