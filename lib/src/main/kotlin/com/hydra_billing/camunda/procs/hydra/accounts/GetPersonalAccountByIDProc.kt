package com.hydra_billing.camunda.procs.hydra.accounts

import com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers.CustomerAccount
import com.hydra_billing.camunda.helpers.camunda.getLong
import com.hydra_billing.camunda.helpers.common.DataClassHelper
import com.hydra_billing.camunda.helpers.hydra.rest.v2.LoginHelper
import com.hydra_billing.camunda.procs.BaseProc
import io.ktor.client.*
import org.camunda.bpm.engine.delegate.DelegateExecution

/**
 * This delegate is designed to show a personal account via Hydra REST API.
 *
 * This delegate is using the following execution variables:
 * - <code>hydraPersonalAccountId</code> - Personal account ID (*required) /Long/
 *
 * The result of this delegate execution is the following variables stored in the Camunda execution:
 * - <code>hydraPersonalAccount</code> - personal account /CustomerAccount.PersonalAccount/
 */
class GetPersonalAccountByIDProc : BaseProc() {

    override fun perform(execution: DelegateExecution) {
        val restApi = LoginHelper.getRestApiClient()
        val accountId = getLong(execution, "hydraPersonalAccountId")
        val personalAccount = doAction(restApi, accountId)
        setToExecution(execution, personalAccount)
    }

    fun doAction(
        restApi: HttpClient,
        accountId: Long,
    ): CustomerAccount.PersonalAccount {
        return CustomerAccount(restApi).getAccountById(accountId)
    }

    private fun setToExecution(
        execution: DelegateExecution,
        personalAccount: CustomerAccount.PersonalAccount
    ) {
        execution.setVariable(
            "hydraPersonalAccount",
            DataClassHelper.convertDataClassToMap<CustomerAccount.PersonalAccount>(
                personalAccount
            )
        )
    }
}
