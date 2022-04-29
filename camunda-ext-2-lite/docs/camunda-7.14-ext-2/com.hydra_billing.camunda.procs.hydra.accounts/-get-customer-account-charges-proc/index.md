//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.procs.hydra.accounts](../index.md)/[GetCustomerAccountChargesProc](index.md)

# GetCustomerAccountChargesProc

[jvm]\
class [GetCustomerAccountChargesProc](index.md) : [BaseProc](../../com.hydra_billing.camunda.procs/-base-proc/index.md)

This delegate is designed to list customer account charges via Hydra REST API.

This delegate is using the following execution variables:

<ul><li><code>hydraCustomerAccountId</code> - Customer account ID (*required) /Long/</li><li><code>hydraCustomerAccountChargesBeginDate</code> - Period begin (*required) /String/</li><li><code>hydraCustomerAccountChargesEndDate</code> - Period end (*required) /String/</li></ul>

The result of this delegate execution is the following variables stored in the Camunda execution:

<ul><li><code>hydraCustomerAccountCharges</code> - customer account charges for defined period /Array<CustomerAccount.Charge>/</li></ul>

## Constructors

| | |
|---|---|
| [GetCustomerAccountChargesProc](-get-customer-account-charges-proc.md) | [jvm]<br>fun [GetCustomerAccountChargesProc](-get-customer-account-charges-proc.md)() |

## Functions

| Name | Summary |
|---|---|
| [doAction](do-action.md) | [jvm]<br>fun [doAction](do-action.md)(restApi: HttpClient, accountId: Long, beginDate: String, endDate: String): Array<[CustomerAccount.Charge](../../com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers/-customer-account/-charge/index.md)> |
| [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md) | [jvm]<br>open override fun [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md)(execution: DelegateExecution) |
| [perform](perform.md) | [jvm]<br>open override fun [perform](perform.md)(execution: DelegateExecution) |
| [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md) | [jvm]<br>fun [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md)(execution: DelegateExecution, e: Exception) |
