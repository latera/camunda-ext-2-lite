package com.hydra_billing.camunda.procs.hydra.accounts

import com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers.CustomerAccount
import com.hydra_billing.camunda.helpers.camunda.getLong
import com.hydra_billing.camunda.helpers.camunda.getString
import com.hydra_billing.camunda.helpers.common.DataClassHelper
import com.hydra_billing.camunda.helpers.hydra.rest.v2.LoginHelper
import com.hydra_billing.camunda.procs.BaseProc
import io.ktor.client.*
import org.camunda.bpm.engine.delegate.DelegateExecution

/**
 * This delegate is designed to list customer account charges via Hydra REST API.
 *
 * This delegate is using the following execution variables:
 * - <code>hydraCustomerAccountId</code> - Customer account ID (*required) /Long/
 * - <code>hydraCustomerAccountChargesBeginDate</code> - Period begin (*required) /String/
 * - <code>hydraCustomerAccountChargesEndDate</code> - Period end (*required) /String/
 *
 * The result of this delegate execution is the following variables stored in the Camunda execution:
 * - <code>hydraCustomerAccountCharges</code> - customer account charges for defined period /Array<CustomerAccount.Charge>/
 */
class GetCustomerAccountChargesProc : BaseProc() {

    override fun perform(execution: DelegateExecution) {
        val restApi = LoginHelper.getRestApiClient()
        val accountId = getLong(execution, "hydraCustomerAccountId")
        val beginDate = getString(execution, "hydraCustomerAccountChargesBeginDate")
        val endDate = getString(execution, "hydraCustomerAccountChargesEndDate")
        val customerAccountCharges = doAction(restApi, accountId, beginDate, endDate)
        setToExecution(execution, customerAccountCharges)
    }

    fun doAction(
        restApi: HttpClient,
        accountId: Long,
        beginDate: String,
        endDate: String
    ): Array<CustomerAccount.Charge> {
        return CustomerAccount(restApi).listCustomerAccountCharges(accountId, beginDate, endDate)
    }

    private fun setToExecution(
        execution: DelegateExecution,
        customerAccountCharges: Array<CustomerAccount.Charge>
    ) {
        execution.setVariable(
            "hydraPersonalAccount",
            DataClassHelper.convertArrayOfDataClassToArrayOfMap<CustomerAccount.Charge>(
                customerAccountCharges
            )
        )
    }
}
