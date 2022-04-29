package com.hydra_billing.camunda.procs.hydra.subjects

import com.hydra_billing.camunda.api.hydra.rest.v2.NetworkServiceSubscription
import com.hydra_billing.camunda.helpers.camunda.*
import com.hydra_billing.camunda.helpers.common.DataClassHelper
import com.hydra_billing.camunda.helpers.hydra.rest.v2.LoginHelper
import com.hydra_billing.camunda.procs.BaseProc
import io.ktor.client.*
import org.camunda.bpm.engine.delegate.DelegateExecution

/**
 * This delegate is designed to show a customer network service subscriptions via Hydra REST API.
 *
 * This delegate is using the following execution variables:
 * - <code>hydraCustomerId</code> - Subject Id (*required) /Long/
 *
 * The result of this delegate execution is the following variables stored in the Camunda execution:
 * - <code>hydraCustomerNetworkServiceSubscriptions</code> - array of subscriptions /NetworkServiceSubscription.NetworkServiceSubscription/
 */
class GetCustomerNetworkServiceSubcriptionsProc : BaseProc() {

    override fun perform(execution: DelegateExecution) {
        val restApi = LoginHelper.getRestApiClient()
        val subjectId = getLong(execution, "hydraCustomerId")
        setToExecution(execution, doAction(restApi, subjectId))
    }

    fun doAction(
        restApi: HttpClient,
        subjectId: Long,
    ): Array<NetworkServiceSubscription.NetworkServiceSubscription> {
        return NetworkServiceSubscription(restApi).list(subjectId)
    }

    private fun setToExecution(
        execution: DelegateExecution,
        addresses: Array<NetworkServiceSubscription.NetworkServiceSubscription>
    ) {
        execution.setVariable(
            "hydraBaseSubjectsAddresses",
            DataClassHelper.convertArrayOfDataClassToArrayOfMap<NetworkServiceSubscription.NetworkServiceSubscription>(
                addresses
            )
        )
    }
}
