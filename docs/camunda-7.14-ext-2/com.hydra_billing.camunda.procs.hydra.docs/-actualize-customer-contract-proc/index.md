//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.procs.hydra.docs](../index.md)/[ActualizeCustomerContractProc](index.md)

# ActualizeCustomerContractProc

[jvm]\
class [ActualizeCustomerContractProc](index.md) : [BaseProc](../../com.hydra_billing.camunda.procs/-base-proc/index.md)

This delegate is designed to actualize the Customer Contract via Hydra REST API.

This delegate is using the following execution variables:

<ul><li><code>hydraCustomerId</code> - Customer ID (*required*) /Long/</li><li><code>hydraCustomerContractId</code> - Customer Contract ID (*required*) /Long/</li></ul>

The result of this delegate execution is the actualized customer contract and the following variables stored in the Camunda execution:

<ul><li><code>hydraCustomerContractActualized</code> - If the customer contract was actualized /Boolean/</li><li><code>hydraCustomerContract</code> - Created Customer Contract /CustomerContract.CustomerContract/</li></ul>

## Constructors

| | |
|---|---|
| [ActualizeCustomerContractProc](-actualize-customer-contract-proc.md) | [jvm]<br>fun [ActualizeCustomerContractProc](-actualize-customer-contract-proc.md)() |

## Functions

| Name | Summary |
|---|---|
| [doAction](do-action.md) | [jvm]<br>fun [doAction](do-action.md)(restApi: HttpClient, customerId: Long, customerContractId: Long): [CustomerContract.CustomerContract](../../com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers/-customer-contract/-customer-contract/index.md) |
| [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md) | [jvm]<br>open override fun [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md)(execution: DelegateExecution) |
| [perform](perform.md) | [jvm]<br>open override fun [perform](perform.md)(execution: DelegateExecution) |
| [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md) | [jvm]<br>fun [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md)(execution: DelegateExecution, e: Exception) |
