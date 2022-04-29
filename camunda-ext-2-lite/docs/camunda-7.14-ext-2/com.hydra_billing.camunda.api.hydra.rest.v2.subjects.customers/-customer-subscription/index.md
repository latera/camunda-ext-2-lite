//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers](../index.md)/[CustomerSubscription](index.md)

# CustomerSubscription

[jvm]\
class [CustomerSubscription](index.md)(**client**: HttpClient)

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) : [Logged](../../com.hydra_billing.camunda.Logger/-logged/index.md) |
| [CreateParams](-create-params/index.md) | [jvm]<br>data class [CreateParams](-create-params/index.md)(**n_service_id**: Long, **n_par_subscription_id**: Long?, **n_account_id**: Long, **n_object_id**: Long?, **n_contract_id**: Long, **d_begin**: String?, **n_quant**: Long?, **d_end**: String?) |
| [CustomerSubscription](-customer-subscription/index.md) | [jvm]<br>data class [CustomerSubscription](-customer-subscription/index.md)(**n_subscription_id**: Long, **n_service_id**: Long, **n_customer_id**: Long, **n_account_id**: Long, **n_object_id**: Long, **n_quant**: Long?, **n_unit_id**: Long?, **d_begin**: String, **d_end**: String?, **c_fl_closed**: String, **n_line_no**: Long, **n_par_subscription_id**: Long?, **n_prev_subscription_id**: Long?, **n_cl_creating_state_id**: [ChargeLogCreatingState](../../com.hydra_billing.camunda.api.hydra.common_types/-charge-log-creating-state/index.md), **n_contract_id**: Long) |
| [ListResponse](-list-response/index.md) | [jvm]<br>data class [ListResponse](-list-response/index.md)(**subscriptions**: Array<[CustomerSubscription.CustomerSubscription](-customer-subscription/index.md)>) |
| [Response](-response/index.md) | [jvm]<br>data class [Response](-response/index.md)(**subscription**: [CustomerSubscription.CustomerSubscription](-customer-subscription/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [create](create.md) | [jvm]<br>fun [create](create.md)(params: [CustomerSubscription.CreateParams](-create-params/index.md), customerId: Long): [CustomerSubscription.CustomerSubscription](-customer-subscription/index.md) |
| [get](get.md) | [jvm]<br>fun [get](get.md)(customerId: Long, subscriptionId: Long): [CustomerSubscription.CustomerSubscription](-customer-subscription/index.md) |
| [list](list.md) | [jvm]<br>fun [list](list.md)(customerId: Long): Array<[CustomerSubscription.CustomerSubscription](-customer-subscription/index.md)> |

## Properties

| Name | Summary |
|---|---|
| [client](client.md) | [jvm]<br>val [client](client.md): HttpClient |
