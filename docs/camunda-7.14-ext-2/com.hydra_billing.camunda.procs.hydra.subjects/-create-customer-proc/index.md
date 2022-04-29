//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.procs.hydra.subjects](../index.md)/[CreateCustomerProc](index.md)

# CreateCustomerProc

[jvm]\
class [CreateCustomerProc](index.md) : [BaseProc](../../com.hydra_billing.camunda.procs/-base-proc/index.md)

This delegate is designed to create a Customer via Hydra REST API.

This delegate is using the following execution variables:

<ul><li><code>hydraCustomerBaseSubjectId</code> - Customer base subject ID (*required*) /Long/</li><li><code>hydraCustomerMainGroupId</code> - Customer main group ID (*required*) /Long/</li><li><code>hydraCustomerCode</code> - Customer code /String?/</li><li><code>hydraCustomerTags</code> - Array of Customer tags /Array<String>?/</li><li><code>hydraCustomerGroupIds</code> - Array of Customer group IDs /Array<Long>?/</li><li><code>hydraCustomerRem</code> - Customer comment /String?/</li><li><code>hydraCustomerResellerId</code> - Customer reseller ID /Long?/</li><li><code>hydraCustomerAdditionalValues</code> - Customer additional values /Array< [com.hydra_billing.camunda.api.hydra.common_types.AdditionalValue](../../com.hydra_billing.camunda.api.hydra.common_types/-additional-value/index.md)>?/</li></ul>

The result of this delegate execution is the created customer and the following variables stored in the Camunda execution:

<ul><li><code>hydraCustomer</code> - Created Customer /Long/</li></ul>

## Constructors

| | |
|---|---|
| [CreateCustomerProc](-create-customer-proc.md) | [jvm]<br>fun [CreateCustomerProc](-create-customer-proc.md)() |

## Functions

| Name | Summary |
|---|---|
| [doAction](do-action.md) | [jvm]<br>fun [doAction](do-action.md)(restApi: HttpClient, createCustomerParams: [Customer.CreateParams](../../com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers/-customer/-create-params/index.md)): [Customer.Customer](../../com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers/-customer/-customer/index.md) |
| [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md) | [jvm]<br>open override fun [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md)(execution: DelegateExecution) |
| [perform](perform.md) | [jvm]<br>open override fun [perform](perform.md)(execution: DelegateExecution) |
| [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md) | [jvm]<br>fun [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md)(execution: DelegateExecution, e: Exception) |
