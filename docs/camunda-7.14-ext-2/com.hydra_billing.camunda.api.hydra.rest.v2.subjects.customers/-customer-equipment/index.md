//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers](../index.md)/[CustomerEquipment](index.md)

# CustomerEquipment

[jvm]\
class [CustomerEquipment](index.md)(**client**: HttpClient)

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) : [Logged](../../com.hydra_billing.camunda.Logger/-logged/index.md) |
| [CreateParams](-create-params/index.md) | [jvm]<br>data class [CreateParams](-create-params/index.md)(**n_good_id**: Long, **n_main_object_id**: Long?, **vc_code**: String?) |
| [CustomerEquipment](-customer-equipment/index.md) | [jvm]<br>data class [CustomerEquipment](-customer-equipment/index.md)(**n_object_id**: Long, **n_good_id**: Long, **n_firm_id**: Long, **n_obj_state_id**: [ObjectState](../../com.hydra_billing.camunda.api.hydra.common_types/-object-state/index.md), **vc_name**: String, **vc_code**: String, **vc_code_add**: String?, **vc_rem**: String?, **n_main_object_id**: Long?, **n_owner_id**: Long, **vc_serial_number**: String?, **vc_inventory_number**: String?, **d_warranty_end**: String?, **additional_values**: Array<[AdditionalValue](../../com.hydra_billing.camunda.api.hydra.common_types/-additional-value/index.md)>) |
| [ListResponse](-list-response/index.md) | [jvm]<br>data class [ListResponse](-list-response/index.md)(**equipment**: Array<[CustomerEquipment.CustomerEquipment](-customer-equipment/index.md)>) |
| [Response](-response/index.md) | [jvm]<br>data class [Response](-response/index.md)(**equipment**: [CustomerEquipment.CustomerEquipment](-customer-equipment/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [create](create.md) | [jvm]<br>fun [create](create.md)(params: [CustomerEquipment.CreateParams](-create-params/index.md), customerId: Long): [CustomerEquipment.CustomerEquipment](-customer-equipment/index.md) |
| [getEquipmentById](get-equipment-by-id.md) | [jvm]<br>fun [getEquipmentById](get-equipment-by-id.md)(customerId: Long, equipmentId: Long): [CustomerEquipment.CustomerEquipment](-customer-equipment/index.md) |
| [list](list.md) | [jvm]<br>fun [list](list.md)(customerId: Long): Array<[CustomerEquipment.CustomerEquipment](-customer-equipment/index.md)> |

## Properties

| Name | Summary |
|---|---|
| [client](client.md) | [jvm]<br>val [client](client.md): HttpClient |
