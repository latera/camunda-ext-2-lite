//[camunda-7.14-ext-2-lite](../../../index.md)/[com.hydra_billing.camunda.procs.oms](../index.md)/[UploadFileProc](index.md)

# UploadFileProc

[jvm]\
class [UploadFileProc](index.md) : [BaseProc](../../com.hydra_billing.camunda.procs/-base-proc/index.md)

This delegate is designed to upload file to minio via HOMS REST API.

This delegate is using the following execution variables:

<ul><li><code>homsFileName</code> - File name (*required) /String/</li><li><code>homsFileContent</code> - File content (*required) /String/</li><li><code>homsFileFieldName</code> - Field name /String?/</li></ul>

The result of this delegate execution is the following variables stored in the Camunda execution:

<ul><li><code>homsFiles</code> - files uploaded to minio /Array<File.File>/</li></ul>

## Constructors

| | |
|---|---|
| [UploadFileProc](-upload-file-proc.md) | [jvm]<br>fun [UploadFileProc](-upload-file-proc.md)() |

## Functions

| Name | Summary |
|---|---|
| [addClient](../../com.hydra_billing.camunda.procs/-base-proc/add-client.md) | [jvm]<br>fun [addClient](../../com.hydra_billing.camunda.procs/-base-proc/add-client.md)(client: HttpClient) |
| [closeConnections](../../com.hydra_billing.camunda.procs/-base-proc/close-connections.md) | [jvm]<br>fun [closeConnections](../../com.hydra_billing.camunda.procs/-base-proc/close-connections.md)() |
| [doAction](do-action.md) | [jvm]<br>fun [doAction](do-action.md)(restApi: HttpClient, file: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[File.FileParams](../../com.hydra_billing.camunda.api.hydra.oms/-file/-file-params/index.md)>): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[File.File](../../com.hydra_billing.camunda.api.hydra.oms/-file/-file/index.md)> |
| [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md) | [jvm]<br>open override fun [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md)(execution: DelegateExecution) |
| [perform](perform.md) | [jvm]<br>open override fun [perform](perform.md)(execution: DelegateExecution) |
| [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md) | [jvm]<br>fun [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md)(execution: DelegateExecution, e: [Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)) |
| [wrapJDBIException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-j-d-b-i-exception.md) | [jvm]<br>fun [wrapJDBIException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-j-d-b-i-exception.md)(execution: DelegateExecution, e: [Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)) |
| [wrapRequestException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-request-exception.md) | [jvm]<br>fun [wrapRequestException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-request-exception.md)(execution: DelegateExecution, e: [Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)) |
| [wrapResponseException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-response-exception.md) | [jvm]<br>fun [wrapResponseException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-response-exception.md)(execution: DelegateExecution, e: [BaseRequestException](../../com.hydra_billing.camunda.exceptions/-base-request-exception/index.md)) |
| [wrapSMTPException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-s-m-t-p-exception.md) | [jvm]<br>fun [wrapSMTPException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-s-m-t-p-exception.md)(execution: DelegateExecution, e: [Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)) |
| [wrapSocketException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-socket-exception.md) | [jvm]<br>fun [wrapSocketException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-socket-exception.md)(execution: DelegateExecution, e: [Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)) |
