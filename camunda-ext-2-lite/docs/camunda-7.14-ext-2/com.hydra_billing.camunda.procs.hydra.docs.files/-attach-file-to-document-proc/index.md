//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.procs.hydra.docs.files](../index.md)/[AttachFileToDocumentProc](index.md)

# AttachFileToDocumentProc

[jvm]\
class [AttachFileToDocumentProc](index.md) : [BaseProc](../../com.hydra_billing.camunda.procs/-base-proc/index.md)

This delegate is designed to attach file to document via Hydra REST API.

This delegate is using the following execution variables:

<ul><li><code>hydraDocumentId</code> - Document ID (*required*) /Long/</li><li><code>hydraDocumentAttachmentName</code> - File name (*required*) /String/</li><li><code>hydraDocumentAttachmentDisplayName</code> - Name (*required*) /String/</li><li><code>hydraDocumentAttachmentBase64Content</code> - Base64 file content (*required*) /String/</li></ul>

The result of this delegate execution is the actualized customer contract and the following variables stored in the Camunda execution:

<ul><li><code>hydraDocumentAttachment</code> - File  /DocFile.File/ /Boolean/</li></ul>

## Constructors

| | |
|---|---|
| [AttachFileToDocumentProc](-attach-file-to-document-proc.md) | [jvm]<br>fun [AttachFileToDocumentProc](-attach-file-to-document-proc.md)() |

## Functions

| Name | Summary |
|---|---|
| [doAction](do-action.md) | [jvm]<br>fun [doAction](do-action.md)(restApi: HttpClient, documentId: Long, fileName: String, displayName: String, content: String): [DocumentAttachment.File](../../com.hydra_billing.camunda.api.hydra.rest.v2.documents/-document-attachment/-file/index.md) |
| [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md) | [jvm]<br>open override fun [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md)(execution: DelegateExecution) |
| [perform](perform.md) | [jvm]<br>open override fun [perform](perform.md)(execution: DelegateExecution) |
| [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md) | [jvm]<br>fun [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md)(execution: DelegateExecution, e: Exception) |
