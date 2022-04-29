//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers](../index.md)/[Customer](index.md)

# Customer

[jvm]\
class [Customer](index.md)(**client**: HttpClient)

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) : [Logged](../../com.hydra_billing.camunda.Logger/-logged/index.md) |
| [CreateParams](-create-params/index.md) | [jvm]<br>data class [CreateParams](-create-params/index.md)(**vc_code**: String?, **n_base_subject_id**: Long, **t_tags**: Array<String>?, **n_subj_group_id**: Long, **group_ids**: Array<Long>?, **vc_rem**: String?, **n_reseller_id**: Long?, **additional_values**: Array<[AdditionalValue](../../com.hydra_billing.camunda.api.hydra.common_types/-additional-value/index.md)>?) |
| [Customer](-customer/index.md) | [jvm]<br>data class [Customer](-customer/index.md)(**n_subject_id**: Long, **n_customer_id**: Long, **n_base_subject_id**: Long, **vc_base_subject_name**: String, **n_base_subj_type_id**: [SubjectType](../../com.hydra_billing.camunda.api.hydra.common_types/-subject-type/index.md), **n_subj_state_id**: [SubjectState](../../com.hydra_billing.camunda.api.hydra.common_types/-subject-state/index.md), **vc_name**: String, **vc_code**: String, **d_created**: String, **t_tags**: Array<String>, **vc_rem**: String?, **n_firm_id**: Long, **n_subj_group_id**: Long, **n_reseller_id**: Long?, **group_ids**: Array<Long>, **vc_base_subject_code**: String, **additional_values**: Array<[AdditionalValue](../../com.hydra_billing.camunda.api.hydra.common_types/-additional-value/index.md)>) |
| [Response](-response/index.md) | [jvm]<br>data class [Response](-response/index.md)(**customer**: [Customer.Customer](-customer/index.md)) |
| [UpdateParams](-update-params/index.md) | [jvm]<br>data class [UpdateParams](-update-params/index.md)(**n_subj_state_id**: [SubjectState](../../com.hydra_billing.camunda.api.hydra.common_types/-subject-state/index.md)?, **vc_code**: String?, **t_tags**: Array<String>?, **n_subj_group_id**: Long?, **group_ids**: Array<Long>?, **vc_rem**: String?, **n_reseller_id**: Long?, **additional_values**: Array<[AdditionalValue](../../com.hydra_billing.camunda.api.hydra.common_types/-additional-value/index.md)>?) |

## Functions

| Name | Summary |
|---|---|
| [create](create.md) | [jvm]<br>fun [create](create.md)(params: [Customer.CreateParams](-create-params/index.md)): [Customer.Customer](-customer/index.md) |
| [get](get.md) | [jvm]<br>fun [get](get.md)(id: Long): [Customer.Customer](-customer/index.md) |
| [update](update.md) | [jvm]<br>fun [update](update.md)(id: Long, params: [Customer.UpdateParams](-update-params/index.md)): [Customer.Customer](-customer/index.md) |

## Properties

| Name | Summary |
|---|---|
| [client](client.md) | [jvm]<br>val [client](client.md): HttpClient |
