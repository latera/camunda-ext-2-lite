package com.hydra_billing.camunda.procs.hydra.services

import com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers.CustomerSubscription
import com.hydra_billing.camunda.helpers.camunda.getLong
import com.hydra_billing.camunda.helpers.camunda.getNullableLong
import com.hydra_billing.camunda.helpers.camunda.getNullableString
import com.hydra_billing.camunda.helpers.common.DataClassHelper
import com.hydra_billing.camunda.helpers.hydra.rest.v2.LoginHelper
import com.hydra_billing.camunda.procs.BaseProc
import io.ktor.client.*
import org.camunda.bpm.engine.delegate.DelegateExecution

/**
 * This delegate is designed to create a Customer service subscription via Hydra REST API.
 *
 * This delegate is using the following execution variables:
 * - <code>hydraCustomerId</code> - Customer ID (*required) /Long/
 * - <code>hydraCustomerServiceSubscriptionGoodId</code> - Customer service subscription good ID
 * (*required*) /Long/
 * - <code>hydraCustomerServiceSubscriptionParSubscriptionId</code> - Customer service subscription parent
 * subscriptions /Long?/
 * - <code>hydraCustomerServiceSubscriptionAccountId</code> - Customer service subscription account ID
 * (*required*) /Long/
 * - <code>hydraCustomerServiceSubscriptionObjectId</code> - Customer service subscription object ID
 * /Long?/
 * - <code>hydraCustomerServiceSubscriptionContractId</code> - Customer service subscription contract ID
 * (*required*) /Long/
 * - <code>hydraCustomerServiceSubscriptionBeginDate</code> - Customer service subscription begin date
 * /String?/
 * - <code>hydraCustomerServiceSubscriptionEndDate</code> - Customer service subscription end date
 * /String?/
 * - <code>hydraCustomerServiceSubscriptionQuantity</code> - Customer service subscription quantity /Long?/
 *
 * The result of this delegate execution is the created Customer service subscription and the
 * following variables stored in the Camunda execution:
 * - <code>hydraCustomerServiceSubscription</code> - Сreated Customer service subscription /CustomerSubscription.CustomerSubscription/
 */
class CreateCustomerServiceSubscriptionProc : BaseProc() {

    override fun perform(execution: DelegateExecution) {
        val restApi = LoginHelper.getRestApiClient()
        val customerId = getLong(execution, "hydraCustomerId")
        val customerServiceSubscription = doAction(restApi, customerId, prepareCustomerServiceSubscriptionParams(execution))
        setToExecution(execution, customerServiceSubscription)
    }

    fun doAction(
        restApi: HttpClient,
        customerId: Long,
        createCustomerEquipmentParams: CustomerSubscription.CreateParams
    ): CustomerSubscription.CustomerSubscription {
        return CustomerSubscription(restApi).create(createCustomerEquipmentParams, customerId)
    }

    private fun prepareCustomerServiceSubscriptionParams(
        execution: DelegateExecution
    ): CustomerSubscription.CreateParams {
        return CustomerSubscription.CreateParams(
            n_service_id = getLong(execution, "hydraCustomerServiceSubscriptionGoodId"),
            n_par_subscription_id = getNullableLong(execution, "hydraCustomerServiceSubscriptionParSubscriptionId"),
            n_account_id = getLong(execution, "hydraCustomerServiceSubscriptionAccountId"),
            n_object_id = getNullableLong(execution, "hydraCustomerServiceSubscriptionObjectId"),
            n_contract_id = getLong(execution, "hydraCustomerServiceSubscriptionContractId"),
            d_begin = getNullableString(execution, "hydraCustomerServiceSubscriptionBeginDate"),
            d_end = getNullableString(execution, "hydraCustomerServiceSubscriptionEndDate"),
            n_quant = getNullableLong(execution, "hydraCustomerServiceSubscriptionQuantity")
        )
    }

    private fun setToExecution(
        execution: DelegateExecution,
        customerServiceSubscription: CustomerSubscription.CustomerSubscription
    ) {
        execution.setVariable(
            "hydraCustomerServiceSubscriptionId",
            DataClassHelper.convertDataClassToMap<CustomerSubscription.CustomerSubscription>(
                customerServiceSubscription
            )
        )
    }
}
