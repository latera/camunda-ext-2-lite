package com.hydra_billing.camunda.procs.hydra.docs

import com.hydra_billing.camunda.api.hydra.common_types.DocumentType
import com.hydra_billing.camunda.api.hydra.common_types.DocumentWorkflow
import com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers.CustomerContract
import com.hydra_billing.camunda.helpers.camunda.getLong
import com.hydra_billing.camunda.helpers.camunda.getNullableLong
import com.hydra_billing.camunda.helpers.camunda.getNullableString
import com.hydra_billing.camunda.helpers.common.DataClassHelper
import com.hydra_billing.camunda.helpers.hydra.rest.v2.LoginHelper
import com.hydra_billing.camunda.procs.BaseProc
import io.ktor.client.*
import org.camunda.bpm.engine.delegate.DelegateExecution

/**
 * This delegate is designed to create a Customer Contract via Hydra REST API.
 *
 * This delegate is using the following execution variables:
 * - <code>hydraCustomerContractBaseContractId</code> - Customer Contract base contract ID
 * (*required*) /Long/
 * - <code>hydraCustomerContractProviderId</code> - Customer Contract provider ID (default is 100)
 * /Long?/
 * - <code>hydraCustomerContractFirmId</code> - Customer Contract firm ID (default is 100) /Long?/
 * - <code>hydraCustomerContractNo</code> - Customer Contract number /String?/
 * - <code>hydraCustomerContractDate</code> - Customer Contract date /String?/
 * - <code>hydraCustomerContractBeginDate</code> - Customer Contract begin date /String?/
 * - <code>hydraCustomerContractEndDate</code> - Customer Contract end date /String?/
 * - <code>hydraCustomerContractComment</code> - Customer Contract comment /String?/
 *
 * The result of this delegate execution is the created customer contract and the following
 * variables stored in the Camunda execution:
 * - <code>hydraCustomerContract</code> - Created Customer Contract /CustomerContract.CustomerContract/
 */
class CreateCustomerContractProc : BaseProc() {

    override fun perform(execution: DelegateExecution) {
        val restApi = LoginHelper.getRestApiClient()
        val customerId = getLong(execution, "hydraCustomerId")
        val customerContract = doAction(
            restApi,
            customerId,
            prepareCustomerContractParams(execution)
        )
        setToExecution(execution, customerContract)
    }

    fun doAction(
        restApi: HttpClient,
        customerId: Long,
        createCustomerContractParams: CustomerContract.CreateParams
    ): CustomerContract.CustomerContract {
        return CustomerContract(restApi).create(createCustomerContractParams, customerId)
    }

    private fun prepareCustomerContractParams(
        execution: DelegateExecution
    ): CustomerContract.CreateParams {
        return CustomerContract.CreateParams(
            n_doc_type_id = DocumentType.CustomerContract,
            n_provider_id = getNullableLong(execution, "hydraCustomerContractProviderId") ?: 100,
            n_firm_id = getNullableLong(execution, "hydraCustomerContractFirmId") ?: 100,
            n_workflow_id = DocumentWorkflow.SubscriberContract,
            n_parent_doc_id = getLong(execution, "hydraCustomerContractBaseContractId"),
            vc_doc_no = getNullableString(execution, "hydraCustomerContractNo"),
            d_doc = getNullableString(execution, "hydraCustomerContractDate"),
            d_begin = getNullableString(execution, "hydraCustomerContractBeginDate"),
            d_end = getNullableString(execution, "hydraCustomerContractEndDate"),
            vc_rem = getNullableString(execution, "hydraCustomerContractComment")
        )
    }

    private fun setToExecution(
        execution: DelegateExecution,
        customerContract: CustomerContract.CustomerContract
    ) {
        execution.setVariable(
            "hydraCustomerContract",
            DataClassHelper.convertDataClassToMap<CustomerContract.CustomerContract>(
                customerContract
            )
        )
    }
}
