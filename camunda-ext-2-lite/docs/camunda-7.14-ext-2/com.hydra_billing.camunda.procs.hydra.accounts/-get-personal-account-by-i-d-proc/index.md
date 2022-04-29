//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.procs.hydra.accounts](../index.md)/[GetPersonalAccountByIDProc](index.md)

# GetPersonalAccountByIDProc

[jvm]\
class [GetPersonalAccountByIDProc](index.md) : [BaseProc](../../com.hydra_billing.camunda.procs/-base-proc/index.md)

This delegate is designed to show a personal account via Hydra REST API.

This delegate is using the following execution variables:

<ul><li><code>hydraPersonalAccountId</code> - Personal account ID (*required) /Long/</li></ul>

The result of this delegate execution is the following variables stored in the Camunda execution:

<ul><li><code>hydraPersonalAccount</code> - personal account /CustomerAccount.PersonalAccount/</li></ul>

## Constructors

| | |
|---|---|
| [GetPersonalAccountByIDProc](-get-personal-account-by-i-d-proc.md) | [jvm]<br>fun [GetPersonalAccountByIDProc](-get-personal-account-by-i-d-proc.md)() |

## Functions

| Name | Summary |
|---|---|
| [doAction](do-action.md) | [jvm]<br>fun [doAction](do-action.md)(restApi: HttpClient, accountId: Long): [CustomerAccount.PersonalAccount](../../com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers/-customer-account/-personal-account/index.md) |
| [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md) | [jvm]<br>open override fun [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md)(execution: DelegateExecution) |
| [perform](perform.md) | [jvm]<br>open override fun [perform](perform.md)(execution: DelegateExecution) |
| [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md) | [jvm]<br>fun [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md)(execution: DelegateExecution, e: Exception) |
