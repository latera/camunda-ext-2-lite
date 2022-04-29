package com.hydra_billing.camunda.procs.hydra.subjects

import com.hydra_billing.camunda.api.hydra.rest.v2.subjects.SubjectAddresses
import com.hydra_billing.camunda.helpers.camunda.*
import com.hydra_billing.camunda.helpers.common.DataClassHelper
import com.hydra_billing.camunda.helpers.hydra.rest.v2.LoginHelper
import com.hydra_billing.camunda.procs.BaseProc
import io.ktor.client.*
import org.camunda.bpm.engine.delegate.DelegateExecution

/**
 * This delegate is designed to show a base subjects addresses via Hydra REST API.
 *
 * This delegate is using the following execution variables:
 * - <code>hydraBaseSubjectIds</code> - Subjects Ids separated by commas (*required) /String/
 *
 * The result of this delegate execution is the following variables stored in the Camunda execution:
 * - <code>hydraBaseSubjectsAddresses</code> - array of Address /Subject.Address/
 */
class GetBaseSubjectAddressesProc : BaseProc() {

    override fun perform(execution: DelegateExecution) {
        val restApi = LoginHelper.getRestApiClient()
        val subjectIds: Array<Long> = getString(execution, "hydraBaseSubjectIds").split(',').map { it.toLong() }.toTypedArray()
        val baseSubjectsAddresses: Array<SubjectAddresses.Address> = doAction(restApi, subjectIds)
        setToExecution(execution, baseSubjectsAddresses)
    }

    fun doAction(
        restApi: HttpClient,
        subjectIds: Array<Long>,
    ): Array<SubjectAddresses.Address> {
        return SubjectAddresses(restApi).list(subjectIds)
    }

    private fun setToExecution(
        execution: DelegateExecution,
        addresses: Array<SubjectAddresses.Address>
    ) {
        execution.setVariable(
            "hydraBaseSubjectsAddresses",
            DataClassHelper.convertArrayOfDataClassToArrayOfMap<SubjectAddresses.Address>(
                addresses
            )
        )
    }
}
