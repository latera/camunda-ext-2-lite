//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.api.hydra.rest.v2.catalog](../index.md)/[CatalogItem](index.md)

# CatalogItem

[jvm]\
class [CatalogItem](index.md)(**client**: HttpClient)

## Types

| Name | Summary |
|---|---|
| [CatalogItem](-catalog-item/index.md) | [jvm]<br>data class [CatalogItem](-catalog-item/index.md)(**n_good_group_id**: [CatalogItemGroup](../../com.hydra_billing.camunda.api.hydra.common_types/-catalog-item-group/index.md), **n_unit_id**: Long?, **vc_code**: String, **vc_name**: String, **n_quant**: Long?, **t_tags**: Array<String>, **vc_tags**: String?, **n_service_id**: Long, **n_service_type_id**: [CatalogItemType](../../com.hydra_billing.camunda.api.hydra.common_types/-catalog-item-type/index.md), **n_base_service_id**: Long?, **n_parent_service_id**: Long?, **vc_service_code**: String, **vc_service_name**: String, **additional_values**: Array<[AdditionalValue](../../com.hydra_billing.camunda.api.hydra.common_types/-additional-value/index.md)>) |
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) : [Logged](../../com.hydra_billing.camunda.Logger/-logged/index.md) |
| [Response](-response/index.md) | [jvm]<br>data class [Response](-response/index.md)(**catalog**: [CatalogItem.CatalogItem](-catalog-item/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [get](get.md) | [jvm]<br>fun [get](get.md)(catalogItemId: Long): [CatalogItem.CatalogItem](-catalog-item/index.md) |

## Properties

| Name | Summary |
|---|---|
| [client](client.md) | [jvm]<br>val [client](client.md): HttpClient |
