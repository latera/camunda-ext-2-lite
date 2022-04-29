//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.procs.hydra.catalog](../index.md)/[GetCatalogItemByIdProc](index.md)

# GetCatalogItemByIdProc

[jvm]\
class [GetCatalogItemByIdProc](index.md) : [BaseProc](../../com.hydra_billing.camunda.procs/-base-proc/index.md)

This delegate is designed to show a catalog item via Hydra REST API.

This delegate is using the following execution variables:

<ul><li><code>hydraCatalogItemId</code> - Catalog item ID (*required) /Long/</li></ul>

The result of this delegate execution is the following variables stored in the Camunda execution:

<ul><li><code>hydraCatalogItem</code> -  Catalog item /CatalogItem.CatalogItem/</li></ul>

## Constructors

| | |
|---|---|
| [GetCatalogItemByIdProc](-get-catalog-item-by-id-proc.md) | [jvm]<br>fun [GetCatalogItemByIdProc](-get-catalog-item-by-id-proc.md)() |

## Functions

| Name | Summary |
|---|---|
| [doAction](do-action.md) | [jvm]<br>fun [doAction](do-action.md)(restApi: HttpClient, catalogItemId: Long): [CatalogItem.CatalogItem](../../com.hydra_billing.camunda.api.hydra.rest.v2.catalog/-catalog-item/-catalog-item/index.md) |
| [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md) | [jvm]<br>open override fun [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md)(execution: DelegateExecution) |
| [perform](perform.md) | [jvm]<br>open override fun [perform](perform.md)(execution: DelegateExecution) |
| [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md) | [jvm]<br>fun [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md)(execution: DelegateExecution, e: Exception) |
