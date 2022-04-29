package com.hydra_billing.camunda.procs.hydra.references

import com.hydra_billing.camunda.api.hydra.rest.v2.Reference
import com.hydra_billing.camunda.helpers.camunda.*
import com.hydra_billing.camunda.helpers.common.DataClassHelper
import com.hydra_billing.camunda.helpers.hydra.rest.v2.LoginHelper
import com.hydra_billing.camunda.procs.BaseProc
import io.ktor.client.*
import org.camunda.bpm.engine.delegate.DelegateExecution

/**
 * This delegate is designed to show a references by type code via Hydra REST API.
 *
 * This delegate is using the following execution variables:
 * - <code>hydraRefTypeCode</code> - References type code (*required) /String/
 *
 * The result of this delegate execution is the following variables stored in the Camunda execution:
 * - <code>hydraReferences</code> - array of References  /References.References/
 */
class GetReferencesByTypeCodeProc : BaseProc() {

    override fun perform(execution: DelegateExecution) {
        val restApi = LoginHelper.getRestApiClient()
        val code = getString(execution, "hydraRefTypeCode")
        setToExecution(execution, doAction(restApi, code))
    }

    fun doAction(
        restApi: HttpClient,
        code: String,
    ): Array<Reference.Reference> {
        return Reference(restApi).listByTypeCode(code)
    }

    private fun setToExecution(
        execution: DelegateExecution,
        references: Array<Reference.Reference>
    ) {
        execution.setVariable(
            "hydraReferences",
            DataClassHelper.convertArrayOfDataClassToArrayOfMap<Reference.Reference>(
                references
            )
        )
    }
}
