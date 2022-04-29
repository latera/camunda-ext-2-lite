package com.hydra_billing.camunda.procs.hydra.subjects

import com.hydra_billing.camunda.api.hydra.common_types.AdditionalValue
import com.hydra_billing.camunda.api.hydra.common_types.SubjectState
import com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers.Customer
import com.hydra_billing.camunda.helpers.camunda.*
import com.hydra_billing.camunda.helpers.common.DataClassHelper
import com.hydra_billing.camunda.helpers.hydra.rest.v2.LoginHelper
import com.hydra_billing.camunda.procs.BaseProc
import io.ktor.client.*
import org.camunda.bpm.engine.delegate.DelegateExecution

/**
 * This delegate is designed to create a Customer via Hydra REST API.
 *
 * This delegate is using the following execution variables:
 * - <code>hydraCustomerId</code> - Customer ID (*required) /Long/
 * - <code>hydraCustomerSubjectStateId</code> - Customer base subject ID (*required*)/
 * [com.hydra_billing.camunda.api.hydra.common_types.SubjectState]/
 * - <code>hydraCustomerCode</code> - Customer code /String?/
 * - <code>hydraCustomerTags</code> - Array of Customer tags /Array<String>?/
 * - <code>hydraCustomerMainGroupId</code> - Customer main group ID (*required*) /Long/
 * - <code>hydraCustomerGroupIds</code> - Array of Customer group IDs /Array<Long>?/
 * - <code>hydraCustomerRem</code> - Customer comment /String?/
 * - <code>hydraCustomerResellerId</code> - Customer reseller ID /Long?/
 * - <code>hydraCustomerAdditionalValues</code> - Customer additional values /Array<
 * [com.hydra_billing.camunda.api.hydra.common_types.AdditionalValue]>?/
 *
 * The result of this delegate execution is the created customer and the following variables stored
 * in the Camunda execution:
 * - <code>hydraCustomer</code> - Created Customer /Long/
 * - <code>hydraCustomerUpdated</code> - Customer updated flag /Boolean/
 */
class UpdateCustomerProc : BaseProc() {

    override fun perform(execution: DelegateExecution) {
        val restApi = LoginHelper.getRestApiClient()
        val customerId = getLong(execution, "hydraCustomerId")
        val updateParams = prepareCustomerParams(execution)
        val customer = doAction(restApi, customerId, updateParams)
        setToExecution(execution, customer)
    }

    fun doAction(
        restApi: HttpClient,
        customerId: Long,
        updateCustomerParams: Customer.UpdateParams
    ): Customer.Customer {
        return Customer(restApi).update(customerId, updateCustomerParams)
    }

    private fun prepareCustomerParams(execution: DelegateExecution): Customer.UpdateParams {
        return Customer.UpdateParams(
            n_subj_state_id = getNullableHydraConstant<SubjectState>(execution, "hydraCustomerSubjectStateId"),
            vc_code = getNullableString(execution, "hydraCustomerCode"),
            t_tags = getVariableAs<Array<String>?>(execution, "hydraCustomerTags"),
            n_subj_group_id = getLong(execution, "hydraCustomerMainGroupId"),
            group_ids = getVariableAs<Array<Long>?>(execution, "hydraCustomerGroupIds"),
            vc_rem = getNullableString(execution, "hydraCustomerRem"),
            n_reseller_id = getNullableLong(execution, "hydraCustomerResellerId"),
            additional_values = getVariableAs<Array<AdditionalValue>?>(execution, "hydraCustomerAdditionalValues")
        )
    }

    private fun setToExecution(execution: DelegateExecution, customer: Customer.Customer) {
        execution.setVariable(
            "hydraCustomerUpdated",
            true
        )

        execution.setVariable(
            "hydraCustomer",
            DataClassHelper.convertDataClassToMap<Customer.Customer>(
                customer
            )
        )
    }
}
