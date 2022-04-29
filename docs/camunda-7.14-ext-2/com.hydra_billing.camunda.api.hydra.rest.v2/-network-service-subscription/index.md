//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.api.hydra.rest.v2](../index.md)/[NetworkServiceSubscription](index.md)

# NetworkServiceSubscription

[jvm]\
class [NetworkServiceSubscription](index.md)(**client**: HttpClient)

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) : [Logged](../../com.hydra_billing.camunda.Logger/-logged/index.md) |
| [CreateParams](-create-params/index.md) | [jvm]<br>data class [CreateParams](-create-params/index.md)(**n_subj_serv_type_id**: [NetworkServiceSubscriptionType](../../com.hydra_billing.camunda.api.hydra.common_types/-network-service-subscription-type/index.md), **n_subject_id**: Long, **n_service_id**: Long, **n_object_id**: Long, **n_auth_type_id**: [AuthorizationType](../../com.hydra_billing.camunda.api.hydra.common_types/-authorization-type/index.md), **vc_login**: String) |
| [ListResponse](-list-response/index.md) | [jvm]<br>data class [ListResponse](-list-response/index.md)(**network_service_subscriptions**: Array<[NetworkServiceSubscription.NetworkServiceSubscription](-network-service-subscription/index.md)>) |
| [NetworkServiceSubscription](-network-service-subscription/index.md) | [jvm]<br>data class [NetworkServiceSubscription](-network-service-subscription/index.md)(**n_subj_serv_id**: Long, **n_subj_serv_type_id**: [NetworkServiceSubscriptionType](../../com.hydra_billing.camunda.api.hydra.common_types/-network-service-subscription-type/index.md), **n_subject_id**: Long, **n_service_id**: Long?, **vc_user_service_name**: String?, **n_object_id**: Long?, **n_auth_type_id**: [AuthorizationType](../../com.hydra_billing.camunda.api.hydra.common_types/-authorization-type/index.md), **vc_auth_type**: String, **vc_login**: String?) |
| [Response](-response/index.md) | [jvm]<br>data class [Response](-response/index.md)(**network_service_subscription**: [NetworkServiceSubscription.NetworkServiceSubscription](-network-service-subscription/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [create](create.md) | [jvm]<br>fun [create](create.md)(params: [NetworkServiceSubscription.CreateParams](-create-params/index.md), subjectId: Long): [NetworkServiceSubscription.NetworkServiceSubscription](-network-service-subscription/index.md) |
| [list](list.md) | [jvm]<br>fun [list](list.md)(subjectId: Long): Array<[NetworkServiceSubscription.NetworkServiceSubscription](-network-service-subscription/index.md)> |

## Properties

| Name | Summary |
|---|---|
| [client](client.md) | [jvm]<br>val [client](client.md): HttpClient |
