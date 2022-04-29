package com.hydra_billing.camunda.procs.hydra.subjects

import com.hydra_billing.camunda.api.hydra.common_types.AdditionalValue
import com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers.Customer
import com.hydra_billing.camunda.helpers.camunda.getLong
import com.hydra_billing.camunda.helpers.camunda.getNullableLong
import com.hydra_billing.camunda.helpers.camunda.getNullableString
import com.hydra_billing.camunda.helpers.camunda.getVariableAs
import com.hydra_billing.camunda.helpers.common.DataClassHelper
import com.hydra_billing.camunda.helpers.hydra.rest.v2.LoginHelper
import com.hydra_billing.camunda.procs.BaseProc
import io.ktor.client.*
import org.camunda.bpm.engine.delegate.DelegateExecution

/**
 * This delegate is designed to create a Customer via Hydra REST API.
 *
 * This delegate is using the following execution variables:
 * - <code>hydraCustomerBaseSubjectId</code> - Customer base subject ID (*required*) /Long/
 * - <code>hydraCustomerMainGroupId</code> - Customer main group ID (*required*) /Long/
 * - <code>hydraCustomerCode</code> - Customer code /String?/
 * - <code>hydraCustomerTags</code> - Array of Customer tags /Array<String>?/
 * - <code>hydraCustomerGroupIds</code> - Array of Customer group IDs /Array<Long>?/
 * - <code>hydraCustomerRem</code> - Customer comment /String?/
 * - <code>hydraCustomerResellerId</code> - Customer reseller ID /Long?/
 * - <code>hydraCustomerAdditionalValues</code> - Customer additional values /Array<
 * [com.hydra_billing.camunda.api.hydra.common_types.AdditionalValue]>?/
 *
 * The result of this delegate execution is the created customer and the following variables stored
 * in the Camunda execution:
 * - <code>hydraCustomer</code> - Created Customer /Long/
 */
class CreateCustomerProc : BaseProc() {

    override fun perform(execution: DelegateExecution) {
        val restApi = LoginHelper.getRestApiClient()
        val customer = doAction(restApi, prepareCustomerParams(execution))
        setToExecution(execution, customer)
    }

    fun doAction(
        restApi: HttpClient,
        createCustomerParams: Customer.CreateParams
    ): Customer.Customer {
        return Customer(restApi).create(createCustomerParams)
    }

    private fun prepareCustomerParams(execution: DelegateExecution): Customer.CreateParams {
        return Customer.CreateParams(
            vc_code = getNullableString(execution, "hydraCustomerCode"),
            n_base_subject_id = getLong(execution, "hydraCustomerBaseSubjectId"),
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
            "hydraCustomerId",
            DataClassHelper.convertDataClassToMap<Customer.Customer>(
                customer
            )
        )
    }
}
