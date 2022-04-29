package com.hydra_billing.camunda.procs.hydra.services

import com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers.CustomerSubscription
import com.hydra_billing.camunda.helpers.camunda.getLong
import com.hydra_billing.camunda.helpers.common.DataClassHelper
import com.hydra_billing.camunda.helpers.hydra.rest.v2.LoginHelper
import com.hydra_billing.camunda.procs.BaseProc
import io.ktor.client.*
import org.camunda.bpm.engine.delegate.DelegateExecution

/**
 * This delegate is designed to get a Customer service subscription via Hydra REST API.
 *
 * This delegate is using the following execution variables:
 * - <code>hydraCustomerId</code> - Customer ID (*required) /Long/
 * - <code>hydraCustomerServiceSubscriptionId</code> - Customer service subscription ID
 * (*required*) /Long/
 *
 * The result of this delegate execution is the Customer service subscription and the
 * following variables stored in the Camunda execution:
 * - <code>hydraCustomerServiceSubscription</code> - Customer service subscription /CustomerSubscription.CustomerSubscription/
 */
class GetCustomerServiceSubscriptionProc : BaseProc() {

    override fun perform(execution: DelegateExecution) {
        val restApi = LoginHelper.getRestApiClient()
        val customerId = getLong(execution, "hydraCustomerId")
        val subscriptionId = getLong(execution, "hydraCustomerServiceSubscriptionId")
        val customerServiceSubscription = doAction(restApi, customerId, subscriptionId)
        setToExecution(execution, customerServiceSubscription)
    }

    fun doAction(
        restApi: HttpClient,
        customerId: Long,
        subscriptionId: Long
    ): CustomerSubscription.CustomerSubscription {
        return CustomerSubscription(restApi).get(customerId, subscriptionId)
    }

    private fun setToExecution(
        execution: DelegateExecution,
        customerServiceSubscription: CustomerSubscription.CustomerSubscription
    ) {
        execution.setVariable(
            "hydraCustomerServiceSubscription",
            DataClassHelper.convertDataClassToMap<CustomerSubscription.CustomerSubscription>(
                customerServiceSubscription
            )
        )
    }
}
