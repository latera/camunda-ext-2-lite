//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.procs.hydra.subjects](../index.md)/[GetBaseSubjectAddressesProc](index.md)

# GetBaseSubjectAddressesProc

[jvm]\
class [GetBaseSubjectAddressesProc](index.md) : [BaseProc](../../com.hydra_billing.camunda.procs/-base-proc/index.md)

This delegate is designed to show a base subjects addresses via Hydra REST API.

This delegate is using the following execution variables:

<ul><li><code>hydraBaseSubjectIds</code> - Subjects Ids separated by commas (*required) /String/</li></ul>

The result of this delegate execution is the following variables stored in the Camunda execution:

<ul><li><code>hydraBaseSubjectsAddresses</code> - array of Address /Subject.Address/</li></ul>

## Constructors

| | |
|---|---|
| [GetBaseSubjectAddressesProc](-get-base-subject-addresses-proc.md) | [jvm]<br>fun [GetBaseSubjectAddressesProc](-get-base-subject-addresses-proc.md)() |

## Functions

| Name | Summary |
|---|---|
| [doAction](do-action.md) | [jvm]<br>fun [doAction](do-action.md)(restApi: HttpClient, subjectIds: Array<Long>): Array<[SubjectAddresses.Address](../../com.hydra_billing.camunda.api.hydra.rest.v2.subjects/-subject-addresses/-address/index.md)> |
| [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md) | [jvm]<br>open override fun [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md)(execution: DelegateExecution) |
| [perform](perform.md) | [jvm]<br>open override fun [perform](perform.md)(execution: DelegateExecution) |
| [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md) | [jvm]<br>fun [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md)(execution: DelegateExecution, e: Exception) |
