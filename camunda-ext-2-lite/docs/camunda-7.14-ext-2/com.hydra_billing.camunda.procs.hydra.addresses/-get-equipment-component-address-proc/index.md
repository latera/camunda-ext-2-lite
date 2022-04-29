//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.procs.hydra.addresses](../index.md)/[GetEquipmentComponentAddressProc](index.md)

# GetEquipmentComponentAddressProc

[jvm]\
class [GetEquipmentComponentAddressProc](index.md) : [BaseProc](../../com.hydra_billing.camunda.procs/-base-proc/index.md)

This delegate is designed to get the equipment component address via Hydra REST API.

This delegate is using the following execution variables:

<ul><li><code>hydraEquipmentId</code> - Equipment ID (*required) /Long/</li><li><code>hydraEquipmentComponentId</code> - Equipment component ID (*required*) /Long/</li><li><code>hydraEquipmentComponentAddressId</code> - Equipment address ID (*required) /Long/</li></ul>

The result of this delegate execution is the following variables stored in the Camunda execution:

<ul><li><code>hydraEquipmentComponentAddress</code> -  Equipment component address /net_devices.Types.AddressParams/</li></ul>

## Constructors

| | |
|---|---|
| [GetEquipmentComponentAddressProc](-get-equipment-component-address-proc.md) | [jvm]<br>fun [GetEquipmentComponentAddressProc](-get-equipment-component-address-proc.md)() |

## Functions

| Name | Summary |
|---|---|
| [doAction](do-action.md) | [jvm]<br>fun [doAction](do-action.md)(restApi: HttpClient, equipmentId: Long, equipmentComponentId: Long, addressId: Long): [AddressParams](../../com.hydra_billing.camunda.api.hydra.rest.v2.net_devices.types/-address-params/index.md) |
| [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md) | [jvm]<br>open override fun [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md)(execution: DelegateExecution) |
| [perform](perform.md) | [jvm]<br>open override fun [perform](perform.md)(execution: DelegateExecution) |
| [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md) | [jvm]<br>fun [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md)(execution: DelegateExecution, e: Exception) |
