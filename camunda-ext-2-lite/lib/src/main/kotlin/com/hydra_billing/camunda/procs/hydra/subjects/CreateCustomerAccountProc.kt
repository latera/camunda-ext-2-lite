package com.hydra_billing.camunda.procs.hydra.subjects

import com.hydra_billing.camunda.api.hydra.common_types.Currency
import com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers.CustomerAccount
import com.hydra_billing.camunda.helpers.camunda.getHydraConstant
import com.hydra_billing.camunda.helpers.camunda.getLong
import com.hydra_billing.camunda.helpers.camunda.getNullableBigDecimal
import com.hydra_billing.camunda.helpers.camunda.getNullableString
import com.hydra_billing.camunda.helpers.common.DataClassHelper
import com.hydra_billing.camunda.helpers.hydra.rest.v2.LoginHelper
import com.hydra_billing.camunda.procs.BaseProc
import io.ktor.client.*
import org.camunda.bpm.engine.delegate.DelegateExecution

/**
 * This delegate is designed to create a Customer account via Hydra REST API.
 *
 * This delegate is using the following execution variables:
 * - <code>hydraCustomerId</code> - Customer ID (*required) /Long/
 * - <code>hydraCustomerAccountCurrencyId</code> - Account currency ID (*required*) /
 * [com.hydra_billing.camunda.api.hydra.common_types.Currency]/
 * - <code>hydraCustomerAccountCode</code> - Account code /String?/
 * - <code>hydraCustomerAccountName</code> - Account name /String?/
 * - <code>hydraCustomerAccountNumber</code> - Account number /String?/
 * - <code>hydraCustomerAccountRem</code> - Account comment /String?/
 * - <code>hydraCustomerAccountMaxCreditLimit</code> - Account credit limit maximum value /BigDecimal?/
 *
 * The result of this delegate execution is the created Customer account and the following variables
 * stored in the Camunda execution:
 * - <code>hydraCustomerAccount</code> - created Customer Account ID /CustomerAccount.CustomerAccount/
 */
class CreateCustomerAccountProc : BaseProc() {

    override fun perform(execution: DelegateExecution) {
        val restApi = LoginHelper.getRestApiClient()
        val customerId = getLong(execution, "hydraCustomerId")
        val customerAccount = doAction(restApi, customerId, prepareCustomerAccountParams(execution))
        setToExecution(execution, customerAccount)
    }

    fun doAction(
        restApi: HttpClient,
        customerId: Long,
        createCustomerAccountParams: CustomerAccount.CreateParams
    ): CustomerAccount.CustomerAccount {
        return CustomerAccount(restApi).create(createCustomerAccountParams, customerId)
    }

    private fun prepareCustomerAccountParams(
        execution: DelegateExecution
    ): CustomerAccount.CreateParams {
        return CustomerAccount.CreateParams(
            n_currency_id = getHydraConstant<Currency>(execution, "hydraCustomerAccountCurrencyId"),
            vc_code = getNullableString(execution, "hydraCustomerAccountCode"),
            vc_name = getNullableString(execution, "hydraCustomerAccountName"),
            vc_account = getNullableString(execution, "hydraCustomerAccountNo"),
            vc_rem = getNullableString(execution, "hydraCustomerAccountRem"),
            n_max_credit_limit = getNullableBigDecimal(execution, "hydraCustomerAccountMaxCreditLimit")
        )
    }

    private fun setToExecution(
        execution: DelegateExecution,
        customerAccount: CustomerAccount.CustomerAccount
    ) {
        execution.setVariable(
            "hydraCustomerAccount",
            DataClassHelper.convertDataClassToMap<CustomerAccount.CustomerAccount>(
                customerAccount
            )
        )
    }
}
