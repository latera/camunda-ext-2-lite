//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.api.jasper](../index.md)/[Report](index.md)/[getFileFromReport](get-file-from-report.md)

# getFileFromReport

[jvm]\
fun [getFileFromReport](get-file-from-report.md)(requestId: String, exportId: String, fileName: String, attachmentsPrefix: String = "attachments"): String

Performs 'Requesting Report Output' method. Downloads attachments.

#### Return

request response.

## Parameters

jvm

| | |
|---|---|
| requestId | request id. |
| exportId | export id. |
| fileName | filename. |
| attachmentsPrefix | attachment prefix, default value = 'attachments'. |
