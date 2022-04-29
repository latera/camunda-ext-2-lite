//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.procs.hydra.services](../index.md)/[GetCustomerServiceSubscriptionProc](index.md)

# GetCustomerServiceSubscriptionProc

[jvm]\
class [GetCustomerServiceSubscriptionProc](index.md) : [BaseProc](../../com.hydra_billing.camunda.procs/-base-proc/index.md)

This delegate is designed to get a Customer service subscription via Hydra REST API.

This delegate is using the following execution variables:

<ul><li><code>hydraCustomerId</code> - Customer ID (*required) /Long/</li><li><code>hydraCustomerServiceSubscriptionId</code> - Customer service subscription ID (*required*) /Long/</li></ul>

The result of this delegate execution is the Customer service subscription and the following variables stored in the Camunda execution:

<ul><li><code>hydraCustomerServiceSubscription</code> - Customer service subscription /CustomerSubscription.CustomerSubscription/</li></ul>

## Constructors

| | |
|---|---|
| [GetCustomerServiceSubscriptionProc](-get-customer-service-subscription-proc.md) | [jvm]<br>fun [GetCustomerServiceSubscriptionProc](-get-customer-service-subscription-proc.md)() |

## Functions

| Name | Summary |
|---|---|
| [doAction](do-action.md) | [jvm]<br>fun [doAction](do-action.md)(restApi: HttpClient, customerId: Long, subscriptionId: Long): [CustomerSubscription.CustomerSubscription](../../com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers/-customer-subscription/-customer-subscription/index.md) |
| [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md) | [jvm]<br>open override fun [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md)(execution: DelegateExecution) |
| [perform](perform.md) | [jvm]<br>open override fun [perform](perform.md)(execution: DelegateExecution) |
| [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md) | [jvm]<br>fun [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md)(execution: DelegateExecution, e: Exception) |
