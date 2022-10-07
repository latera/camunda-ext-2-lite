//[camunda-7.14-ext-2-lite](../../../index.md)/[com.hydra_billing.camunda.procs](../index.md)/[BaseProc](index.md)

# BaseProc

[jvm]\
abstract class [BaseProc](index.md) : JavaDelegate

## Functions

| Name | Summary |
|---|---|
| [addClient](add-client.md) | [jvm]<br>fun [addClient](add-client.md)(client: HttpClient) |
| [closeConnections](close-connections.md) | [jvm]<br>fun [closeConnections](close-connections.md)() |
| [execute](execute.md) | [jvm]<br>open override fun [execute](execute.md)(execution: DelegateExecution) |
| [perform](perform.md) | [jvm]<br>abstract fun [perform](perform.md)(execution: DelegateExecution) |
| [wrapExecutionException](wrap-execution-exception.md) | [jvm]<br>fun [wrapExecutionException](wrap-execution-exception.md)(execution: DelegateExecution, e: [Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)) |
| [wrapJDBIException](wrap-j-d-b-i-exception.md) | [jvm]<br>fun [wrapJDBIException](wrap-j-d-b-i-exception.md)(execution: DelegateExecution, e: [Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)) |
| [wrapRequestException](wrap-request-exception.md) | [jvm]<br>fun [wrapRequestException](wrap-request-exception.md)(execution: DelegateExecution, e: [Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)) |
| [wrapResponseException](wrap-response-exception.md) | [jvm]<br>fun [wrapResponseException](wrap-response-exception.md)(execution: DelegateExecution, e: [BaseRequestException](../../com.hydra_billing.camunda.exceptions/-base-request-exception/index.md)) |
| [wrapSMTPException](wrap-s-m-t-p-exception.md) | [jvm]<br>fun [wrapSMTPException](wrap-s-m-t-p-exception.md)(execution: DelegateExecution, e: [Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)) |
| [wrapSocketException](wrap-socket-exception.md) | [jvm]<br>fun [wrapSocketException](wrap-socket-exception.md)(execution: DelegateExecution, e: [Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)) |

## Inheritors

| Name |
|---|
| [UploadFileProc](../../com.hydra_billing.camunda.procs.oms/-upload-file-proc/index.md) |
