//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.api.hydra.rest.v2.subjects.persons](../index.md)/[PersonAddress](index.md)

# PersonAddress

[jvm]\
class [PersonAddress](index.md)(**client**: HttpClient)

## Types

| Name | Summary |
|---|---|
| [Address](-address/index.md) | [jvm]<br>data class [Address](-address/index.md)(**n_address_id**: Long, **n_addr_type_id**: [AddressType](../../com.hydra_billing.camunda.api.hydra.common_types/-address-type/index.md), **n_par_addr_id**: Long?, **vc_code**: String, **vc_visual_code**: String, **vc_address**: String, **vc_flat**: String?, **n_region_id**: Long, **vc_entrance_no**: String?, **n_floor_no**: Long?, **n_firm_id**: Long?, **n_subj_address_id**: Long, **n_subj_addr_type_id**: [BindAddressType](../../com.hydra_billing.camunda.api.hydra.common_types/-bind-address-type/index.md), **n_addr_state_id**: [AddressState](../../com.hydra_billing.camunda.api.hydra.common_types/-address-state/index.md), **vc_rem**: String?, **n_bind_addr_id**: Long?, **d_begin**: String?, **d_end**: String?, **c_fl_main**: String, **vc_intercom_code**: String?) |
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) : [Logged](../../com.hydra_billing.camunda.Logger/-logged/index.md) |
| [CreateParams](-create-params/index.md) | [jvm]<br>data class [CreateParams](-create-params/index.md)(**n_addr_type_id**: [AddressType](../../com.hydra_billing.camunda.api.hydra.common_types/-address-type/index.md), **n_subj_addr_type_id**: [BindAddressType](../../com.hydra_billing.camunda.api.hydra.common_types/-bind-address-type/index.md), **vc_address**: String?, **vc_code**: String?, **n_addr_state_id**: [AddressState](../../com.hydra_billing.camunda.api.hydra.common_types/-address-state/index.md), **n_floor_no**: Long?, **n_region_id**: Long?, **d_begin**: String?, **d_end**: String?, **vc_rem**: String?, **c_fl_main**: String?, **vc_intercom_code**: String?, **vc_entrance_no**: String?, **vc_flat**: String?, **n_bind_addr_id**: Long?, **n_par_addr_id**: Long?) |
| [Response](-response/index.md) | [jvm]<br>data class [Response](-response/index.md)(**address**: [PersonAddress.Address](-address/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [create](create.md) | [jvm]<br>fun [create](create.md)(params: [PersonAddress.CreateParams](-create-params/index.md), personId: Long): [PersonAddress.Address](-address/index.md) |

## Properties

| Name | Summary |
|---|---|
| [client](client.md) | [jvm]<br>val [client](client.md): HttpClient |
