//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.procs.hydra.subjects](../index.md)/[GetCustomerNetworkServiceSubcriptionsProc](index.md)

# GetCustomerNetworkServiceSubcriptionsProc

[jvm]\
class [GetCustomerNetworkServiceSubcriptionsProc](index.md) : [BaseProc](../../com.hydra_billing.camunda.procs/-base-proc/index.md)

This delegate is designed to show a customer network service subscriptions via Hydra REST API.

This delegate is using the following execution variables:

<ul><li><code>hydraCustomerId</code> - Subject Id (*required) /Long/</li></ul>

The result of this delegate execution is the following variables stored in the Camunda execution:

<ul><li><code>hydraCustomerNetworkServiceSubscriptions</code> - array of subscriptions /NetworkServiceSubscription.NetworkServiceSubscription/</li></ul>

## Constructors

| | |
|---|---|
| [GetCustomerNetworkServiceSubcriptionsProc](-get-customer-network-service-subcriptions-proc.md) | [jvm]<br>fun [GetCustomerNetworkServiceSubcriptionsProc](-get-customer-network-service-subcriptions-proc.md)() |

## Functions

| Name | Summary |
|---|---|
| [doAction](do-action.md) | [jvm]<br>fun [doAction](do-action.md)(restApi: HttpClient, subjectId: Long): Array<[NetworkServiceSubscription.NetworkServiceSubscription](../../com.hydra_billing.camunda.api.hydra.rest.v2/-network-service-subscription/-network-service-subscription/index.md)> |
| [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md) | [jvm]<br>open override fun [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md)(execution: DelegateExecution) |
| [perform](perform.md) | [jvm]<br>open override fun [perform](perform.md)(execution: DelegateExecution) |
| [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md) | [jvm]<br>fun [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md)(execution: DelegateExecution, e: Exception) |
