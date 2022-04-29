package com.hydra_billing.camunda.procs.mail

import com.hydra_billing.camunda.api.SMTPApi
import com.hydra_billing.camunda.helpers.camunda.*
import com.hydra_billing.camunda.helpers.common.ConfigHelper
import com.hydra_billing.camunda.procs.BaseProc
import org.camunda.bpm.engine.delegate.DelegateExecution
import javax.mail.BodyPart

/**
 * This delegate is designed to send email. DONT USE FOR BULK MAILING!
 *
 * This delegate is using the following execution variables:
 * - <code>mailRecipientAddresses</code> - Recipient addresses separated by commas (*required) /String/
 * - <code>mailSubject</code> - Mail subject (*required) /String/
 * - <code>mailText</code> - Text part of the mail /String?/
 * - <code>mailHTML</code> - HTML part of the mail /String?/
 * - <code>mailFilePath</code> - Attachment path /String?/
 * - <code>mailFilePathName</code> - Attachment name /String?/
 * - <code>mailFileUrl</code> - Attachment URL /String?/
 * - <code>mailFileUrlName</code> - Attachment name /String?/
 * - <code>mailFileBase64</code> - Base64 Attachment /String?/
 * - <code>mailFileBase64Name</code> - Attachment name /String?/
 * - <code>mailFileBase64Type</code> - Attachment type /String?/
 */
class SendMultipartMailProc : BaseProc() {

    override fun perform(execution: DelegateExecution) {
        val addresses = getString(execution, "mailRecipientAddresses").split(',').toTypedArray()
        val subject = getString(execution, "mailSubject")
        val text = getNullableString(execution, "mailText")
        val html = getNullableString(execution, "mailHTML")
        val filePath = getNullableString(execution, "mailFilePath")
        val filePathName = getNullableString(execution, "mailFilePathName")
        val fileUrl = getNullableString(execution, "mailFileUrl")
        val fileUrlName = getNullableString(execution, "mailFileUrlName")
        val fileBase64 = getNullableString(execution, "mailFileBase64")
        val fileBase64Name = getNullableString(execution, "mailFileBase64Name")
        val fileBase64Type = getNullableString(execution, "mailFileBase64Type")

        doAction(
            addresses,
            subject,
            text,
            html,
            filePath,
            filePathName,
            fileUrl,
            fileUrlName,
            fileBase64,
            fileBase64Name,
            fileBase64Type
        )
    }

    fun doAction(
        addresses: Array<String>,
        subject: String,
        text: String?,
        html: String?,
        filePath: String?,
        filePathName: String?,
        fileUrl: String?,
        fileUrlName: String?,
        fileBase64: String?,
        fileBase64Name: String?,
        fileBase64Type: String?
    ) {

        val conf = ConfigHelper.getDefaultSMTPConfig()
        val session = SMTPApi.getSession(conf)
        val parts = mutableListOf<BodyPart>()

        if (text != null) {
            parts.add(SMTPApi.createTextPart(text))
        }

        if (html != null) {
            parts.add(SMTPApi.createHTMLPart(html))
        }

        if (filePath != null && filePathName != null) {
            parts.add(SMTPApi.createAttachmentPart(filePath, filePathName))
        }

        if (fileUrl != null && fileUrlName != null) {
            parts.add(SMTPApi.createAttachmentPartFromUrl(fileUrl, fileUrlName))
        }

        if (fileBase64 != null && fileBase64Name != null && fileBase64Type != null) {
            parts.add(SMTPApi.createAttachmentPartFromString(fileBase64, fileBase64Name, fileBase64Type))
        }

        if (parts.size == 0) {
            throw Exception("eMail cant be empty")
        }

        SMTPApi.sendMultipartMessage(
            session = session,
            from = conf.user,
            addresses = addresses,
            subject = subject,
            parts = parts.toTypedArray()
        )
    }
}
