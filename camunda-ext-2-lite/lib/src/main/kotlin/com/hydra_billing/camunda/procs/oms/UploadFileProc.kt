package com.hydra_billing.camunda.procs.oms

import com.hydra_billing.camunda.api.hydra.oms.File
import com.hydra_billing.camunda.helpers.camunda.getNullableString
import com.hydra_billing.camunda.helpers.camunda.getString
import com.hydra_billing.camunda.helpers.common.DataClassHelper
import com.hydra_billing.camunda.helpers.hydra.oms.LoginHelper
import com.hydra_billing.camunda.procs.BaseProc
import io.ktor.client.*
import org.camunda.bpm.engine.delegate.DelegateExecution

/**
 * This delegate is designed to upload file to minio via HOMS REST API.
 *
 * This delegate is using the following execution variables:
 * - <code>homsFileName</code> - File name (*required) /String/
 * - <code>homsFileContent</code> - File content (*required) /String/
 * - <code>homsFileFieldName</code> - Field name /String?/
 *
 * The result of this delegate execution is the following variables stored in the Camunda execution:
 * - <code>homsFiles</code> - files uploaded to minio /Array<File.File>/
 */
class UploadFileProc : BaseProc() {

    override fun perform(execution: DelegateExecution) {
        val restApi = LoginHelper.getHomsClient()
        val fileName = getString(execution, "homsFileName")
        val fileContent = getString(execution, "homsFileContent")
        val fieldName = getNullableString(execution, "homsFileFieldName")

        val file = arrayOf(File.FileParams(fileName, fileContent, fieldName))
        val uploadedFile = doAction(restApi, file)
        setToExecution(execution, uploadedFile)
    }

    fun doAction(
        restApi: HttpClient,
        file: Array<File.FileParams>,
    ): Array<File.File> {
        return File(restApi).upload(file)
    }

    private fun setToExecution(
        execution: DelegateExecution,
        uploadedFile: Array<File.File>
    ) {
        execution.setVariable(
            "homsFiles",
            DataClassHelper.convertArrayOfDataClassToArrayOfMap<File.File>(
                uploadedFile
            )
        )
    }
}
