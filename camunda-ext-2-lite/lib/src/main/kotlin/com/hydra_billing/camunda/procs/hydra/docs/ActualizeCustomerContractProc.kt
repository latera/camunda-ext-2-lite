package com.hydra_billing.camunda.procs.hydra.docs

import com.hydra_billing.camunda.api.hydra.common_types.DocumentState
import com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers.CustomerContract
import com.hydra_billing.camunda.helpers.camunda.getLong
import com.hydra_billing.camunda.helpers.common.DataClassHelper
import com.hydra_billing.camunda.helpers.hydra.rest.v2.LoginHelper
import com.hydra_billing.camunda.procs.BaseProc
import io.ktor.client.*
import org.camunda.bpm.engine.delegate.DelegateExecution

/**
 * This delegate is designed to actualize the Customer Contract via Hydra REST API.
 *
 * This delegate is using the following execution variables:
 * - <code>hydraCustomerId</code> - Customer ID (*required*) /Long/
 * - <code>hydraCustomerContractId</code> - Customer Contract ID (*required*) /Long/
 *
 * The result of this delegate execution is the actualized customer contract and the following
 * variables stored in the Camunda execution:
 * - <code>hydraCustomerContractActualized</code> - If the customer contract was actualized /Boolean/
 * - <code>hydraCustomerContract</code> - Created Customer Contract /CustomerContract.CustomerContract/
 */
class ActualizeCustomerContractProc : BaseProc() {

    override fun perform(execution: DelegateExecution) {
        val restApi = LoginHelper.getRestApiClient()
        val customerId = getLong(execution, "hydraCustomerId")
        val customerContractId = getLong(execution, "hydraCustomerContractId")
        val customerContract = doAction(restApi, customerId, customerContractId)
        setToExecution(execution, customerContract)
    }

    fun doAction(
        restApi: HttpClient,
        customerId: Long,
        customerContractId: Long
    ): CustomerContract.CustomerContract {
        val customerContractInitial = getCustomerContract(restApi, customerId, customerContractId)
        val customerContract = customerContractInitial.copy(n_doc_state_id = DocumentState.Actual)
        return CustomerContract(restApi).update(customerContract, customerId)
    }

    private fun getCustomerContract(
        restApi: HttpClient,
        customerId: Long,
        customerContractId: Long
    ): CustomerContract.CustomerContract {
        return CustomerContract(restApi).get(customerId, customerContractId)
    }

    private fun setToExecution(
        execution: DelegateExecution,
        customerContract: CustomerContract.CustomerContract
    ) {
        execution.setVariable(
            "hydraCustomerContractActualized",
            customerContract.n_doc_state_id == DocumentState.Actual
        )

        execution.setVariable(
            "hydraCustomerContract",
            DataClassHelper.convertDataClassToMap<CustomerContract.CustomerContract>(
                customerContract
            )
        )
    }
}
