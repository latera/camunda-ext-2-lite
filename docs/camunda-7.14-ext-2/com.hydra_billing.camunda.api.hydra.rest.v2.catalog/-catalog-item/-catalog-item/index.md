//[camunda-7.14-ext-2](../../../../index.md)/[com.hydra_billing.camunda.api.hydra.rest.v2.catalog](../../index.md)/[CatalogItem](../index.md)/[CatalogItem](index.md)

# CatalogItem

[jvm]\
data class [CatalogItem](index.md)(**n_good_group_id**: [CatalogItemGroup](../../../com.hydra_billing.camunda.api.hydra.common_types/-catalog-item-group/index.md), **n_unit_id**: Long?, **vc_code**: String, **vc_name**: String, **n_quant**: Long?, **t_tags**: Array<String>, **vc_tags**: String?, **n_service_id**: Long, **n_service_type_id**: [CatalogItemType](../../../com.hydra_billing.camunda.api.hydra.common_types/-catalog-item-type/index.md), **n_base_service_id**: Long?, **n_parent_service_id**: Long?, **vc_service_code**: String, **vc_service_name**: String, **additional_values**: Array<[AdditionalValue](../../../com.hydra_billing.camunda.api.hydra.common_types/-additional-value/index.md)>)

## Properties

| Name | Summary |
|---|---|
| [additional_values](additional_values.md) | [jvm]<br>val [additional_values](additional_values.md): Array<[AdditionalValue](../../../com.hydra_billing.camunda.api.hydra.common_types/-additional-value/index.md)> |
| [n_base_service_id](n_base_service_id.md) | [jvm]<br>val [n_base_service_id](n_base_service_id.md): Long? |
| [n_good_group_id](n_good_group_id.md) | [jvm]<br>val [n_good_group_id](n_good_group_id.md): [CatalogItemGroup](../../../com.hydra_billing.camunda.api.hydra.common_types/-catalog-item-group/index.md) |
| [n_parent_service_id](n_parent_service_id.md) | [jvm]<br>val [n_parent_service_id](n_parent_service_id.md): Long? |
| [n_quant](n_quant.md) | [jvm]<br>val [n_quant](n_quant.md): Long? |
| [n_service_id](n_service_id.md) | [jvm]<br>val [n_service_id](n_service_id.md): Long |
| [n_service_type_id](n_service_type_id.md) | [jvm]<br>val [n_service_type_id](n_service_type_id.md): [CatalogItemType](../../../com.hydra_billing.camunda.api.hydra.common_types/-catalog-item-type/index.md) |
| [n_unit_id](n_unit_id.md) | [jvm]<br>val [n_unit_id](n_unit_id.md): Long? = null |
| [t_tags](t_tags.md) | [jvm]<br>val [t_tags](t_tags.md): Array<String> |
| [vc_code](vc_code.md) | [jvm]<br>val [vc_code](vc_code.md): String |
| [vc_name](vc_name.md) | [jvm]<br>val [vc_name](vc_name.md): String |
| [vc_service_code](vc_service_code.md) | [jvm]<br>val [vc_service_code](vc_service_code.md): String |
| [vc_service_name](vc_service_name.md) | [jvm]<br>val [vc_service_name](vc_service_name.md): String |
| [vc_tags](vc_tags.md) | [jvm]<br>val [vc_tags](vc_tags.md): String? |
