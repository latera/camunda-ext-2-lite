package com.hydra_billing.camunda.procs.hydra.docs.files

import com.hydra_billing.camunda.api.hydra.rest.v2.documents.DocumentAttachment
import com.hydra_billing.camunda.helpers.camunda.getLong
import com.hydra_billing.camunda.helpers.common.DataClassHelper
import com.hydra_billing.camunda.helpers.hydra.rest.v2.LoginHelper
import com.hydra_billing.camunda.procs.BaseProc
import io.ktor.client.*
import org.camunda.bpm.engine.delegate.DelegateExecution

/**
 * This delegate is designed to show files attached to document via Hydra REST API.
 *
 * This delegate is using the following execution variables:
 * - <code>hydraDocumentId</code> - Document ID (*required*) /Long/
 *
 * The result of this delegate execution is the actualized customer contract and the following
 * variables stored in the Camunda execution:
 * - <code>hydraDocumentAttachments</code> - Files attached to document  /Array<DocFile.File>/
 * /Boolean/
 */
class GetAttachmentsByDocumentProc : BaseProc() {

    override fun perform(execution: DelegateExecution) {
        val restApi = LoginHelper.getRestApiClient()

        val documentId = getLong(execution, "hydraDocumentId")

        val files = doAction(restApi, documentId)
        setToExecution(execution, files)
    }

    fun doAction(
        restApi: HttpClient,
        documentId: Long,
    ): Array<DocumentAttachment.File> {

        return DocumentAttachment(restApi).list(documentId)
    }

    private fun setToExecution(
        execution: DelegateExecution,
        files: Array<DocumentAttachment.File>
    ) {
        execution.setVariable(
            "hydraDocumentAttachments",
            DataClassHelper.convertArrayOfDataClassToArrayOfMap<DocumentAttachment.File>(files)
        )
    }
}
