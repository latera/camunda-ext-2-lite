//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.procs.hydra.addresses](../index.md)/[GetEquipmentAddressesProc](index.md)

# GetEquipmentAddressesProc

[jvm]\
class [GetEquipmentAddressesProc](index.md) : [BaseProc](../../com.hydra_billing.camunda.procs/-base-proc/index.md)

This delegate is designed to show equipment addresses via Hydra REST API.

This delegate is using the following execution variables:

<ul><li><code>hydraEquipmentId</code> - Equipment ID (*required) /Long/</li></ul>

The result of this delegate execution is the following variables stored in the Camunda execution:

<ul><li><code>hydraEquipmentAddresses</code> - array of Address /net_devices.types.AddressParams/</li></ul>

## Constructors

| | |
|---|---|
| [GetEquipmentAddressesProc](-get-equipment-addresses-proc.md) | [jvm]<br>fun [GetEquipmentAddressesProc](-get-equipment-addresses-proc.md)() |

## Functions

| Name | Summary |
|---|---|
| [doAction](do-action.md) | [jvm]<br>fun [doAction](do-action.md)(restApi: HttpClient, equipmentId: Long): Array<[AddressParams](../../com.hydra_billing.camunda.api.hydra.rest.v2.net_devices.types/-address-params/index.md)> |
| [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md) | [jvm]<br>open override fun [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md)(execution: DelegateExecution) |
| [perform](perform.md) | [jvm]<br>open override fun [perform](perform.md)(execution: DelegateExecution) |
| [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md) | [jvm]<br>fun [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md)(execution: DelegateExecution, e: Exception) |
