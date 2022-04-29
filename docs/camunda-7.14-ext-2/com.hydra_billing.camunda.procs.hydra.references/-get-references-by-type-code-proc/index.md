//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.procs.hydra.references](../index.md)/[GetReferencesByTypeCodeProc](index.md)

# GetReferencesByTypeCodeProc

[jvm]\
class [GetReferencesByTypeCodeProc](index.md) : [BaseProc](../../com.hydra_billing.camunda.procs/-base-proc/index.md)

This delegate is designed to show a references by type code via Hydra REST API.

This delegate is using the following execution variables:

<ul><li><code>hydraRefTypeCode</code> - References type code (*required) /String/</li></ul>

The result of this delegate execution is the following variables stored in the Camunda execution:

<ul><li><code>hydraReferences</code> - array of References  /References.References/</li></ul>

## Constructors

| | |
|---|---|
| [GetReferencesByTypeCodeProc](-get-references-by-type-code-proc.md) | [jvm]<br>fun [GetReferencesByTypeCodeProc](-get-references-by-type-code-proc.md)() |

## Functions

| Name | Summary |
|---|---|
| [doAction](do-action.md) | [jvm]<br>fun [doAction](do-action.md)(restApi: HttpClient, code: String): Array<[Reference.Reference](../../com.hydra_billing.camunda.api.hydra.rest.v2/-reference/-reference/index.md)> |
| [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md) | [jvm]<br>open override fun [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md)(execution: DelegateExecution) |
| [perform](perform.md) | [jvm]<br>open override fun [perform](perform.md)(execution: DelegateExecution) |
| [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md) | [jvm]<br>fun [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md)(execution: DelegateExecution, e: Exception) |
