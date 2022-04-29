//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.api.hydra.rest.v2.subjects.persons](../index.md)/[Person](index.md)

# Person

[jvm]\
class [Person](index.md)(**client**: HttpClient)

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) : [Logged](../../com.hydra_billing.camunda.Logger/-logged/index.md) |
| [CreateParams](-create-params/index.md) | [jvm]<br>data class [CreateParams](-create-params/index.md)(**vc_first_name**: String, **vc_surname**: String, **vc_second_name**: String?, **n_subj_state_id**: [SubjectState](../../com.hydra_billing.camunda.api.hydra.common_types/-subject-state/index.md), **n_opf_id**: Long?, **n_firm_id**: Long?, **n_sex_id**: [SubjectSex](../../com.hydra_billing.camunda.api.hydra.common_types/-subject-sex/index.md)?, **vc_inn**: String?, **vc_doc_serial**: String?, **vc_doc_no**: String?, **d_doc**: String?, **vc_document**: String?, **vc_doc_department**: String?, **d_birth**: String?, **vc_birth_place**: String?, **vc_pens_insurance**: String?, **vc_med_insurance**: String?, **n_citizenship_id**: Long?, **vc_kpp**: String?, **vc_rem**: String?, **t_tags**: Array<String>?, **additional_values**: Array<[AdditionalValue](../../com.hydra_billing.camunda.api.hydra.common_types/-additional-value/index.md)>?) |
| [Person](-person/index.md) | [jvm]<br>data class [Person](-person/index.md)(**n_person_id**: Long, **n_opf_id**: Long?, **vc_opf_code**: String?, **vc_opf_name**: String?, **vc_first_name**: String, **vc_surname**: String, **vc_second_name**: String?, **n_sex_id**: [SubjectSex](../../com.hydra_billing.camunda.api.hydra.common_types/-subject-sex/index.md)?, **vc_sex**: String, **vc_inn**: String?, **n_doc_auth_type_id**: Long?, **vc_doc_auth_type_code**: String?, **vc_doc_auth_type_name**: String?, **vc_doc_serial**: String?, **vc_doc_no**: String?, **d_doc**: String?, **vc_document**: String?, **vc_doc_department**: String?, **d_birth**: String?, **vc_birth_place**: String?, **vc_pens_insurance**: String?, **vc_med_insurance**: String?, **n_subject_id**: Long, **n_subj_type_id**: [SubjectType](../../com.hydra_billing.camunda.api.hydra.common_types/-subject-type/index.md), **n_parent_subj_id**: Long?, **n_subj_state_id**: [SubjectState](../../com.hydra_billing.camunda.api.hydra.common_types/-subject-state/index.md), **vc_subj_state_name**: String, **n_base_subject_id**: Long, **n_firm_id**: Long, **vc_firm**: String, **n_region_id**: Long?, **vc_region**: String?, **n_owner_id**: Long, **vc_subj_name**: String, **vc_subj_code**: String, **vc_name**: String, **vc_code**: String, **d_created**: String, **n_creator_id**: Long?, **t_tags**: Array<String>, **vc_tags**: String?, **vc_rem**: String?, **vc_code_upper**: String, **vc_name_upper**: String, **n_subj_group_id**: Long, **vc_subj_group_name**: String?, **n_citizenship_id**: Long?, **vc_citizenship**: String?, **vc_kpp**: String?, **additional_values**: Array<[AdditionalValue](../../com.hydra_billing.camunda.api.hydra.common_types/-additional-value/index.md)>) |
| [Response](-response/index.md) | [jvm]<br>data class [Response](-response/index.md)(**person**: [Person.Person](-person/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [create](create.md) | [jvm]<br>fun [create](create.md)(params: [Person.CreateParams](-create-params/index.md)): [Person.Person](-person/index.md) |

## Properties

| Name | Summary |
|---|---|
| [client](client.md) | [jvm]<br>val [client](client.md): HttpClient |
