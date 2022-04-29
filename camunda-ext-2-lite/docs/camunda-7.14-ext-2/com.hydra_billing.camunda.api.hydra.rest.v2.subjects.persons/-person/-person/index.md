//[camunda-7.14-ext-2](../../../../index.md)/[com.hydra_billing.camunda.api.hydra.rest.v2.subjects.persons](../../index.md)/[Person](../index.md)/[Person](index.md)

# Person

[jvm]\
data class [Person](index.md)(**n_person_id**: Long, **n_opf_id**: Long?, **vc_opf_code**: String?, **vc_opf_name**: String?, **vc_first_name**: String, **vc_surname**: String, **vc_second_name**: String?, **n_sex_id**: [SubjectSex](../../../com.hydra_billing.camunda.api.hydra.common_types/-subject-sex/index.md)?, **vc_sex**: String, **vc_inn**: String?, **n_doc_auth_type_id**: Long?, **vc_doc_auth_type_code**: String?, **vc_doc_auth_type_name**: String?, **vc_doc_serial**: String?, **vc_doc_no**: String?, **d_doc**: String?, **vc_document**: String?, **vc_doc_department**: String?, **d_birth**: String?, **vc_birth_place**: String?, **vc_pens_insurance**: String?, **vc_med_insurance**: String?, **n_subject_id**: Long, **n_subj_type_id**: [SubjectType](../../../com.hydra_billing.camunda.api.hydra.common_types/-subject-type/index.md), **n_parent_subj_id**: Long?, **n_subj_state_id**: [SubjectState](../../../com.hydra_billing.camunda.api.hydra.common_types/-subject-state/index.md), **vc_subj_state_name**: String, **n_base_subject_id**: Long, **n_firm_id**: Long, **vc_firm**: String, **n_region_id**: Long?, **vc_region**: String?, **n_owner_id**: Long, **vc_subj_name**: String, **vc_subj_code**: String, **vc_name**: String, **vc_code**: String, **d_created**: String, **n_creator_id**: Long?, **t_tags**: Array<String>, **vc_tags**: String?, **vc_rem**: String?, **vc_code_upper**: String, **vc_name_upper**: String, **n_subj_group_id**: Long, **vc_subj_group_name**: String?, **n_citizenship_id**: Long?, **vc_citizenship**: String?, **vc_kpp**: String?, **additional_values**: Array<[AdditionalValue](../../../com.hydra_billing.camunda.api.hydra.common_types/-additional-value/index.md)>)

## Properties

| Name | Summary |
|---|---|
| [additional_values](additional_values.md) | [jvm]<br>val [additional_values](additional_values.md): Array<[AdditionalValue](../../../com.hydra_billing.camunda.api.hydra.common_types/-additional-value/index.md)> |
| [d_birth](d_birth.md) | [jvm]<br>val [d_birth](d_birth.md): String? |
| [d_created](d_created.md) | [jvm]<br>val [d_created](d_created.md): String |
| [d_doc](d_doc.md) | [jvm]<br>val [d_doc](d_doc.md): String? |
| [n_base_subject_id](n_base_subject_id.md) | [jvm]<br>val [n_base_subject_id](n_base_subject_id.md): Long |
| [n_citizenship_id](n_citizenship_id.md) | [jvm]<br>val [n_citizenship_id](n_citizenship_id.md): Long? |
| [n_creator_id](n_creator_id.md) | [jvm]<br>val [n_creator_id](n_creator_id.md): Long? |
| [n_doc_auth_type_id](n_doc_auth_type_id.md) | [jvm]<br>val [n_doc_auth_type_id](n_doc_auth_type_id.md): Long? |
| [n_firm_id](n_firm_id.md) | [jvm]<br>val [n_firm_id](n_firm_id.md): Long |
| [n_opf_id](n_opf_id.md) | [jvm]<br>val [n_opf_id](n_opf_id.md): Long? |
| [n_owner_id](n_owner_id.md) | [jvm]<br>val [n_owner_id](n_owner_id.md): Long |
| [n_parent_subj_id](n_parent_subj_id.md) | [jvm]<br>val [n_parent_subj_id](n_parent_subj_id.md): Long? |
| [n_person_id](n_person_id.md) | [jvm]<br>val [n_person_id](n_person_id.md): Long |
| [n_region_id](n_region_id.md) | [jvm]<br>val [n_region_id](n_region_id.md): Long? |
| [n_sex_id](n_sex_id.md) | [jvm]<br>val [n_sex_id](n_sex_id.md): [SubjectSex](../../../com.hydra_billing.camunda.api.hydra.common_types/-subject-sex/index.md)? |
| [n_subj_group_id](n_subj_group_id.md) | [jvm]<br>val [n_subj_group_id](n_subj_group_id.md): Long |
| [n_subj_state_id](n_subj_state_id.md) | [jvm]<br>val [n_subj_state_id](n_subj_state_id.md): [SubjectState](../../../com.hydra_billing.camunda.api.hydra.common_types/-subject-state/index.md) |
| [n_subj_type_id](n_subj_type_id.md) | [jvm]<br>val [n_subj_type_id](n_subj_type_id.md): [SubjectType](../../../com.hydra_billing.camunda.api.hydra.common_types/-subject-type/index.md) |
| [n_subject_id](n_subject_id.md) | [jvm]<br>val [n_subject_id](n_subject_id.md): Long |
| [t_tags](t_tags.md) | [jvm]<br>val [t_tags](t_tags.md): Array<String> |
| [vc_birth_place](vc_birth_place.md) | [jvm]<br>val [vc_birth_place](vc_birth_place.md): String? |
| [vc_citizenship](vc_citizenship.md) | [jvm]<br>val [vc_citizenship](vc_citizenship.md): String? |
| [vc_code](vc_code.md) | [jvm]<br>val [vc_code](vc_code.md): String |
| [vc_code_upper](vc_code_upper.md) | [jvm]<br>val [vc_code_upper](vc_code_upper.md): String |
| [vc_doc_auth_type_code](vc_doc_auth_type_code.md) | [jvm]<br>val [vc_doc_auth_type_code](vc_doc_auth_type_code.md): String? |
| [vc_doc_auth_type_name](vc_doc_auth_type_name.md) | [jvm]<br>val [vc_doc_auth_type_name](vc_doc_auth_type_name.md): String? |
| [vc_doc_department](vc_doc_department.md) | [jvm]<br>val [vc_doc_department](vc_doc_department.md): String? |
| [vc_doc_no](vc_doc_no.md) | [jvm]<br>val [vc_doc_no](vc_doc_no.md): String? |
| [vc_doc_serial](vc_doc_serial.md) | [jvm]<br>val [vc_doc_serial](vc_doc_serial.md): String? |
| [vc_document](vc_document.md) | [jvm]<br>val [vc_document](vc_document.md): String? |
| [vc_firm](vc_firm.md) | [jvm]<br>val [vc_firm](vc_firm.md): String |
| [vc_first_name](vc_first_name.md) | [jvm]<br>val [vc_first_name](vc_first_name.md): String |
| [vc_inn](vc_inn.md) | [jvm]<br>val [vc_inn](vc_inn.md): String? |
| [vc_kpp](vc_kpp.md) | [jvm]<br>val [vc_kpp](vc_kpp.md): String? |
| [vc_med_insurance](vc_med_insurance.md) | [jvm]<br>val [vc_med_insurance](vc_med_insurance.md): String? |
| [vc_name](vc_name.md) | [jvm]<br>val [vc_name](vc_name.md): String |
| [vc_name_upper](vc_name_upper.md) | [jvm]<br>val [vc_name_upper](vc_name_upper.md): String |
| [vc_opf_code](vc_opf_code.md) | [jvm]<br>val [vc_opf_code](vc_opf_code.md): String? |
| [vc_opf_name](vc_opf_name.md) | [jvm]<br>val [vc_opf_name](vc_opf_name.md): String? |
| [vc_pens_insurance](vc_pens_insurance.md) | [jvm]<br>val [vc_pens_insurance](vc_pens_insurance.md): String? |
| [vc_region](vc_region.md) | [jvm]<br>val [vc_region](vc_region.md): String? |
| [vc_rem](vc_rem.md) | [jvm]<br>val [vc_rem](vc_rem.md): String? |
| [vc_second_name](vc_second_name.md) | [jvm]<br>val [vc_second_name](vc_second_name.md): String? |
| [vc_sex](vc_sex.md) | [jvm]<br>val [vc_sex](vc_sex.md): String |
| [vc_subj_code](vc_subj_code.md) | [jvm]<br>val [vc_subj_code](vc_subj_code.md): String |
| [vc_subj_group_name](vc_subj_group_name.md) | [jvm]<br>val [vc_subj_group_name](vc_subj_group_name.md): String? |
| [vc_subj_name](vc_subj_name.md) | [jvm]<br>val [vc_subj_name](vc_subj_name.md): String |
| [vc_subj_state_name](vc_subj_state_name.md) | [jvm]<br>val [vc_subj_state_name](vc_subj_state_name.md): String |
| [vc_surname](vc_surname.md) | [jvm]<br>val [vc_surname](vc_surname.md): String |
| [vc_tags](vc_tags.md) | [jvm]<br>val [vc_tags](vc_tags.md): String? |
