//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.api.hydra.rest.v2.subjects](../index.md)/[SubjectAddresses](index.md)

# SubjectAddresses

[jvm]\
class [SubjectAddresses](index.md)(**client**: HttpClient)

## Types

| Name | Summary |
|---|---|
| [Address](-address/index.md) | [jvm]<br>data class [Address](-address/index.md)(**n_address_id**: Long, **n_addr_type_id**: [AddressType](../../com.hydra_billing.camunda.api.hydra.common_types/-address-type/index.md), **vc_code**: String?, **vc_visual_code**: String?, **vc_address**: String?, **n_subj_address_id**: Long, **n_subject_id**: Long, **n_subj_addr_type_id**: [BindAddressType](../../com.hydra_billing.camunda.api.hydra.common_types/-bind-address-type/index.md), **n_addr_state_id**: [AddressState](../../com.hydra_billing.camunda.api.hydra.common_types/-address-state/index.md), **vc_rem**: String?, **vc_subj_addr_type_name**: String, **c_fl_main**: String, **n_par_addr_id**: Long?, **n_bind_addr_id**: Long?, **n_region_id**: Long?, **d_begin**: String?, **d_end**: String?, **n_firm_id**: Long?, **vc_entrance_no**: String?, **n_floor_no**: Long?, **vc_flat**: String?, **vc_intercom_code**: String?) |
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) : [Logged](../../com.hydra_billing.camunda.Logger/-logged/index.md) |
| [ListResponse](-list-response/index.md) | [jvm]<br>data class [ListResponse](-list-response/index.md)(**subject_addresses**: Array<[SubjectAddresses.Address](-address/index.md)>) |

## Functions

| Name | Summary |
|---|---|
| [list](list.md) | [jvm]<br>fun [list](list.md)(subjectIds: Array<Long>): Array<[SubjectAddresses.Address](-address/index.md)> |

## Properties

| Name | Summary |
|---|---|
| [client](client.md) | [jvm]<br>val [client](client.md): HttpClient |
