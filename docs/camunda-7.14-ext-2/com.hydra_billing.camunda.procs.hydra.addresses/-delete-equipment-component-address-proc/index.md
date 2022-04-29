//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.procs.hydra.addresses](../index.md)/[DeleteEquipmentComponentAddressProc](index.md)

# DeleteEquipmentComponentAddressProc

[jvm]\
class [DeleteEquipmentComponentAddressProc](index.md) : [BaseProc](../../com.hydra_billing.camunda.procs/-base-proc/index.md)

This delegate is designed to delete the equipment component address via Hydra REST API.

This delegate is using the following execution variables:

<ul><li><code>hydraEquipmentId</code> - Equipment ID (*required*) /Long/</li><li><code>hydraEquipmentComponentId</code> - Equipment component ID (*required*) /Long/</li><li><code>hydraEquipmentComponentAddressId</code> - Equipment component address ID (*required*) /Long/</li></ul>

The result of this delegate execution is the deleted Equipment component address and the following variables stored in the Camunda execution:

<ul><li><code>hydraEquipmentComponentAddressDeleted</code> - Is Equipment component address deleted /Boolean/</li></ul>

## Constructors

| | |
|---|---|
| [DeleteEquipmentComponentAddressProc](-delete-equipment-component-address-proc.md) | [jvm]<br>fun [DeleteEquipmentComponentAddressProc](-delete-equipment-component-address-proc.md)() |

## Functions

| Name | Summary |
|---|---|
| [doAction](do-action.md) | [jvm]<br>fun [doAction](do-action.md)(restApi: HttpClient, equipmentId: Long, equipmentComponentId: Long, equipmentComponentAddressId: Long): Boolean |
| [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md) | [jvm]<br>open override fun [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md)(execution: DelegateExecution) |
| [perform](perform.md) | [jvm]<br>open override fun [perform](perform.md)(execution: DelegateExecution) |
| [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md) | [jvm]<br>fun [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md)(execution: DelegateExecution, e: Exception) |
