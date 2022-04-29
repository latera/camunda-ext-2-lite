package com.hydra_billing.camunda.procs.hydra.subjects

import com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers.Customer
import com.hydra_billing.camunda.helpers.camunda.getLong
import com.hydra_billing.camunda.helpers.common.DataClassHelper
import com.hydra_billing.camunda.helpers.hydra.rest.v2.LoginHelper
import com.hydra_billing.camunda.procs.BaseProc
import io.ktor.client.*
import org.camunda.bpm.engine.delegate.DelegateExecution

/**
 * This delegate is designed to show a customer via Hydra REST API.
 *
 * This delegate is using the following execution variables:
 * - <code>hydraCustomerId</code> - Customer ID (*required) /Long/
 *
 * The result of this delegate execution is the following variables stored in the Camunda execution:
 * - <code>hydraCustomer</code> - personal account /Customer.Customer/
 */
class GetCustomerProc : BaseProc() {

    override fun perform(execution: DelegateExecution) {
        val restApi = LoginHelper.getRestApiClient()
        val customerId = getLong(execution, "hydraCustomerId")
        val personalAccount = doAction(restApi, customerId)
        setToExecution(execution, personalAccount)
    }

    fun doAction(
        restApi: HttpClient,
        customerId: Long,
    ): Customer.Customer {
        return Customer(restApi).get(customerId)
    }

    private fun setToExecution(
        execution: DelegateExecution,
        customer: Customer.Customer
    ) {
        execution.setVariable(
            "hydraCustomer",
            DataClassHelper.convertDataClassToMap<Customer.Customer>(
                customer
            )
        )
    }
}
