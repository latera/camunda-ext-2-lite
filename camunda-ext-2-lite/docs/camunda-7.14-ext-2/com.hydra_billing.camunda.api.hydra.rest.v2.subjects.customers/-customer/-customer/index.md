//[camunda-7.14-ext-2](../../../../index.md)/[com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers](../../index.md)/[Customer](../index.md)/[Customer](index.md)

# Customer

[jvm]\
data class [Customer](index.md)(**n_subject_id**: Long, **n_customer_id**: Long, **n_base_subject_id**: Long, **vc_base_subject_name**: String, **n_base_subj_type_id**: [SubjectType](../../../com.hydra_billing.camunda.api.hydra.common_types/-subject-type/index.md), **n_subj_state_id**: [SubjectState](../../../com.hydra_billing.camunda.api.hydra.common_types/-subject-state/index.md), **vc_name**: String, **vc_code**: String, **d_created**: String, **t_tags**: Array<String>, **vc_rem**: String?, **n_firm_id**: Long, **n_subj_group_id**: Long, **n_reseller_id**: Long?, **group_ids**: Array<Long>, **vc_base_subject_code**: String, **additional_values**: Array<[AdditionalValue](../../../com.hydra_billing.camunda.api.hydra.common_types/-additional-value/index.md)>)

## Properties

| Name | Summary |
|---|---|
| [additional_values](additional_values.md) | [jvm]<br>val [additional_values](additional_values.md): Array<[AdditionalValue](../../../com.hydra_billing.camunda.api.hydra.common_types/-additional-value/index.md)> |
| [d_created](d_created.md) | [jvm]<br>val [d_created](d_created.md): String |
| [group_ids](group_ids.md) | [jvm]<br>val [group_ids](group_ids.md): Array<Long> |
| [n_base_subj_type_id](n_base_subj_type_id.md) | [jvm]<br>val [n_base_subj_type_id](n_base_subj_type_id.md): [SubjectType](../../../com.hydra_billing.camunda.api.hydra.common_types/-subject-type/index.md) |
| [n_base_subject_id](n_base_subject_id.md) | [jvm]<br>val [n_base_subject_id](n_base_subject_id.md): Long |
| [n_customer_id](n_customer_id.md) | [jvm]<br>val [n_customer_id](n_customer_id.md): Long |
| [n_firm_id](n_firm_id.md) | [jvm]<br>val [n_firm_id](n_firm_id.md): Long |
| [n_reseller_id](n_reseller_id.md) | [jvm]<br>val [n_reseller_id](n_reseller_id.md): Long? |
| [n_subj_group_id](n_subj_group_id.md) | [jvm]<br>val [n_subj_group_id](n_subj_group_id.md): Long |
| [n_subj_state_id](n_subj_state_id.md) | [jvm]<br>val [n_subj_state_id](n_subj_state_id.md): [SubjectState](../../../com.hydra_billing.camunda.api.hydra.common_types/-subject-state/index.md) |
| [n_subject_id](n_subject_id.md) | [jvm]<br>val [n_subject_id](n_subject_id.md): Long |
| [t_tags](t_tags.md) | [jvm]<br>val [t_tags](t_tags.md): Array<String> |
| [vc_base_subject_code](vc_base_subject_code.md) | [jvm]<br>val [vc_base_subject_code](vc_base_subject_code.md): String |
| [vc_base_subject_name](vc_base_subject_name.md) | [jvm]<br>val [vc_base_subject_name](vc_base_subject_name.md): String |
| [vc_code](vc_code.md) | [jvm]<br>val [vc_code](vc_code.md): String |
| [vc_name](vc_name.md) | [jvm]<br>val [vc_name](vc_name.md): String |
| [vc_rem](vc_rem.md) | [jvm]<br>val [vc_rem](vc_rem.md): String? |
