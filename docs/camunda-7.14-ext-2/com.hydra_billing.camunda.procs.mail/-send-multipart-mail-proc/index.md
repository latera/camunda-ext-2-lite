//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.procs.mail](../index.md)/[SendMultipartMailProc](index.md)

# SendMultipartMailProc

[jvm]\
class [SendMultipartMailProc](index.md) : [BaseProc](../../com.hydra_billing.camunda.procs/-base-proc/index.md)

This delegate is designed to send email. DONT USE FOR BULK MAILING!

This delegate is using the following execution variables:

<ul><li><code>mailRecipientAddresses</code> - Recipient addresses separated by commas (*required) /String/</li><li><code>mailSubject</code> - Mail subject (*required) /String/</li><li><code>mailText</code> - Text part of the mail /String?/</li><li><code>mailHTML</code> - HTML part of the mail /String?/</li><li><code>mailFilePath</code> - Attachment path /String?/</li><li><code>mailFilePathName</code> - Attachment name /String?/</li><li><code>mailFileUrl</code> - Attachment URL /String?/</li><li><code>mailFileUrlName</code> - Attachment name /String?/</li><li><code>mailFileBase64</code> - Base64 Attachment /String?/</li><li><code>mailFileBase64Name</code> - Attachment name /String?/</li><li><code>mailFileBase64Type</code> - Attachment type /String?/</li></ul>

## Constructors

| | |
|---|---|
| [SendMultipartMailProc](-send-multipart-mail-proc.md) | [jvm]<br>fun [SendMultipartMailProc](-send-multipart-mail-proc.md)() |

## Functions

| Name | Summary |
|---|---|
| [doAction](do-action.md) | [jvm]<br>fun [doAction](do-action.md)(addresses: Array<String>, subject: String, text: String?, html: String?, filePath: String?, filePathName: String?, fileUrl: String?, fileUrlName: String?, fileBase64: String?, fileBase64Name: String?, fileBase64Type: String?) |
| [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md) | [jvm]<br>open override fun [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md)(execution: DelegateExecution) |
| [perform](perform.md) | [jvm]<br>open override fun [perform](perform.md)(execution: DelegateExecution) |
| [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md) | [jvm]<br>fun [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md)(execution: DelegateExecution, e: Exception) |
