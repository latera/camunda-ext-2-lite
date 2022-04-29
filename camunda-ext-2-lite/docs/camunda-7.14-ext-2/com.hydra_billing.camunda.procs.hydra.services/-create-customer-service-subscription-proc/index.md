//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.procs.hydra.services](../index.md)/[CreateCustomerServiceSubscriptionProc](index.md)

# CreateCustomerServiceSubscriptionProc

[jvm]\
class [CreateCustomerServiceSubscriptionProc](index.md) : [BaseProc](../../com.hydra_billing.camunda.procs/-base-proc/index.md)

This delegate is designed to create a Customer service subscription via Hydra REST API.

This delegate is using the following execution variables:

<ul><li><code>hydraCustomerId</code> - Customer ID (*required) /Long/</li><li><code>hydraCustomerServiceSubscriptionGoodId</code> - Customer service subscription good ID (*required*) /Long/</li><li><code>hydraCustomerServiceSubscriptionParSubscriptionId</code> - Customer service subscription parent subscriptions /Long?/</li><li><code>hydraCustomerServiceSubscriptionAccountId</code> - Customer service subscription account ID (*required*) /Long/</li><li><code>hydraCustomerServiceSubscriptionObjectId</code> - Customer service subscription object ID /Long?/</li><li><code>hydraCustomerServiceSubscriptionContractId</code> - Customer service subscription contract ID (*required*) /Long/</li><li><code>hydraCustomerServiceSubscriptionBeginDate</code> - Customer service subscription begin date /String?/</li><li><code>hydraCustomerServiceSubscriptionEndDate</code> - Customer service subscription end date /String?/</li><li><code>hydraCustomerServiceSubscriptionQuantity</code> - Customer service subscription quantity /Long?/</li></ul>

The result of this delegate execution is the created Customer service subscription and the following variables stored in the Camunda execution:

<ul><li><code>hydraCustomerServiceSubscription</code> - Сreated Customer service subscription /CustomerSubscription.CustomerSubscription/</li></ul>

## Constructors

| | |
|---|---|
| [CreateCustomerServiceSubscriptionProc](-create-customer-service-subscription-proc.md) | [jvm]<br>fun [CreateCustomerServiceSubscriptionProc](-create-customer-service-subscription-proc.md)() |

## Functions

| Name | Summary |
|---|---|
| [doAction](do-action.md) | [jvm]<br>fun [doAction](do-action.md)(restApi: HttpClient, customerId: Long, createCustomerEquipmentParams: [CustomerSubscription.CreateParams](../../com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers/-customer-subscription/-create-params/index.md)): [CustomerSubscription.CustomerSubscription](../../com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers/-customer-subscription/-customer-subscription/index.md) |
| [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md) | [jvm]<br>open override fun [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md)(execution: DelegateExecution) |
| [perform](perform.md) | [jvm]<br>open override fun [perform](perform.md)(execution: DelegateExecution) |
| [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md) | [jvm]<br>fun [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md)(execution: DelegateExecution, e: Exception) |
