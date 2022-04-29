//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.procs.hydra.docs](../index.md)/[CreateCustomerContractProc](index.md)

# CreateCustomerContractProc

[jvm]\
class [CreateCustomerContractProc](index.md) : [BaseProc](../../com.hydra_billing.camunda.procs/-base-proc/index.md)

This delegate is designed to create a Customer Contract via Hydra REST API.

This delegate is using the following execution variables:

<ul><li><code>hydraCustomerContractBaseContractId</code> - Customer Contract base contract ID (*required*) /Long/</li><li><code>hydraCustomerContractProviderId</code> - Customer Contract provider ID (default is 100) /Long?/</li><li><code>hydraCustomerContractFirmId</code> - Customer Contract firm ID (default is 100) /Long?/</li><li><code>hydraCustomerContractNo</code> - Customer Contract number /String?/</li><li><code>hydraCustomerContractDate</code> - Customer Contract date /String?/</li><li><code>hydraCustomerContractBeginDate</code> - Customer Contract begin date /String?/</li><li><code>hydraCustomerContractEndDate</code> - Customer Contract end date /String?/</li><li><code>hydraCustomerContractComment</code> - Customer Contract comment /String?/</li></ul>

The result of this delegate execution is the created customer contract and the following variables stored in the Camunda execution:

<ul><li><code>hydraCustomerContract</code> - Created Customer Contract /CustomerContract.CustomerContract/</li></ul>

## Constructors

| | |
|---|---|
| [CreateCustomerContractProc](-create-customer-contract-proc.md) | [jvm]<br>fun [CreateCustomerContractProc](-create-customer-contract-proc.md)() |

## Functions

| Name | Summary |
|---|---|
| [doAction](do-action.md) | [jvm]<br>fun [doAction](do-action.md)(restApi: HttpClient, customerId: Long, createCustomerContractParams: [CustomerContract.CreateParams](../../com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers/-customer-contract/-create-params/index.md)): [CustomerContract.CustomerContract](../../com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers/-customer-contract/-customer-contract/index.md) |
| [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md) | [jvm]<br>open override fun [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md)(execution: DelegateExecution) |
| [perform](perform.md) | [jvm]<br>open override fun [perform](perform.md)(execution: DelegateExecution) |
| [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md) | [jvm]<br>fun [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md)(execution: DelegateExecution, e: Exception) |
