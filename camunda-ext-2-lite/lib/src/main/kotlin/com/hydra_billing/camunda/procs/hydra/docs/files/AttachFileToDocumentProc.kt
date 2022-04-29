package com.hydra_billing.camunda.procs.hydra.docs.files

import com.hydra_billing.camunda.api.hydra.rest.v2.documents.DocumentAttachment
import com.hydra_billing.camunda.helpers.camunda.*
import com.hydra_billing.camunda.helpers.common.DataClassHelper
import com.hydra_billing.camunda.helpers.hydra.rest.v2.LoginHelper
import com.hydra_billing.camunda.procs.BaseProc
import io.ktor.client.*
import org.camunda.bpm.engine.delegate.DelegateExecution

/**
 * This delegate is designed to attach file to document via Hydra REST API.
 *
 * This delegate is using the following execution variables:
 * - <code>hydraDocumentId</code> - Document ID (*required*) /Long/
 * - <code>hydraDocumentAttachmentName</code> - File name (*required*) /String/
 * - <code>hydraDocumentAttachmentDisplayName</code> - Name (*required*) /String/
 * - <code>hydraDocumentAttachmentBase64Content</code> - Base64 file content (*required*) /String/
 *
 * The result of this delegate execution is the actualized customer contract and the following
 * variables stored in the Camunda execution:
 * - <code>hydraDocumentAttachment</code> - File  /DocFile.File/
 * /Boolean/
 */
class AttachFileToDocumentProc : BaseProc() {

    override fun perform(execution: DelegateExecution) {
        val restApi = LoginHelper.getRestApiClient()

        val documentId = getLong(execution, "hydraDocumentId")
        val fileName = getString(execution, "hydraDocumentAttachmentName")
        val displayName = getString(execution, "hydraDocumentAttachmentDisplayName")
        val content = getString(execution, "hydraDocumentAttachmentBase64Content")

        val file = doAction(restApi, documentId, fileName, displayName, content)
        setToExecution(execution, file)
    }

    fun doAction(
        restApi: HttpClient,
        documentId: Long,
        fileName: String,
        displayName: String,
        content: String
    ): DocumentAttachment.File {
        val params = DocumentAttachment.CreateParams(content, fileName, displayName)
        return DocumentAttachment(restApi).create(documentId, params)
    }

    private fun setToExecution(
        execution: DelegateExecution,
        file: DocumentAttachment.File
    ) {
        execution.setVariable(
            "hydraDocumentAttachment",
            DataClassHelper.convertDataClassToMap<DocumentAttachment.File>(file)
        )
    }
}
