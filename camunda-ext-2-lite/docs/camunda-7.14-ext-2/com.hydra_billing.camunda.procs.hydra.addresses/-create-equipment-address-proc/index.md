//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.procs.hydra.addresses](../index.md)/[CreateEquipmentAddressProc](index.md)

# CreateEquipmentAddressProc

[jvm]\
class [CreateEquipmentAddressProc](index.md) : [BaseProc](../../com.hydra_billing.camunda.procs/-base-proc/index.md)

This delegate is designed to create a Equipment address via Hydra REST API.

This delegate is using the following execution variables:

<ul><li><code>hydraEquipmentId</code> - Equipment ID (*required*) /Long/</li><li><code>hydraEquipmentAddressTypeId</code> - Equipment address type ID (*required*) / [com.hydra_billing.camunda.api.hydra.common_types.AddressType](../../com.hydra_billing.camunda.api.hydra.common_types/-address-type/index.md)/</li><li><code>hydraEquipmentParAddressId</code> - Equipment par address ID /Long?/</li><li><code>hydraEquipmentBindAddrId</code> - Equipment bind address ID /Long?/</li><li><code>hydraEquipmentAddressFirmId</code> - Equipment address firm ID (default is 100) /Long?/</li><li><code>hydraEquipmentAddressBindTypeId</code> - Equipment address bind type ID (*required*) /[com.hydra_billing.camunda.api.hydra.common_types.BindAddressType](../../com.hydra_billing.camunda.api.hydra.common_types/-bind-address-type/index.md)/</li><li><code>hydraEquipmentAddressRaw</code> - Equipment raw address (non-standard address) /String?/</li><li><code>hydraEquipmentAddressCode</code> - Equipment address (e.g. phone number, email) /String?/</li><li><code>hydraEquipmentAddressFloorNo</code> - Equipment address floor /Long?/</li><li><code>hydraEquipmentAddressRegionId</code> - Equipment address region ID /Long?/</li><li><code>hydraEquipmentAddressBeginDate</code> - Equipment address begin date /String?/</li><li><code>hydraEquipmentAddressEndDate</code> - Equipment address end date /String?/</li><li><code>hydraEquipmentAddressRem</code> - Equipment address comment /String?/</li><li><code>hydraEquipmentAddressIntercom</code> - Equipment address intercom code /String?/</li><li><code>hydraEquipmentAddressEntrance</code> - Equipment address entrance /String?/</li><li><code>hydraEquipmentAddressFlat</code> - Equipment address flat /String?/</li><li><code>hydraEquipmentAddressMask</code> - Equipment address mask /Long?/</li><li><code>hydraEquipmentAddressIsRealSubnet</code> - Equipment address real subnet flag /String?/</li></ul>

The result of this delegate execution is the created Equipment address and the following variables stored in the Camunda execution:

<ul><li><code>hydraEquipmentAddress</code> - Created Equipment address /net_devices.Address.AddressParams/</li></ul>

## Constructors

| | |
|---|---|
| [CreateEquipmentAddressProc](-create-equipment-address-proc.md) | [jvm]<br>fun [CreateEquipmentAddressProc](-create-equipment-address-proc.md)() |

## Functions

| Name | Summary |
|---|---|
| [doAction](do-action.md) | [jvm]<br>fun [doAction](do-action.md)(restApi: HttpClient, equipmentId: Long, createEquipmentAddressParams: [CreateAddressParams](../../com.hydra_billing.camunda.api.hydra.rest.v2.net_devices.types/-create-address-params/index.md)): [AddressParams](../../com.hydra_billing.camunda.api.hydra.rest.v2.net_devices.types/-address-params/index.md) |
| [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md) | [jvm]<br>open override fun [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md)(execution: DelegateExecution) |
| [perform](perform.md) | [jvm]<br>open override fun [perform](perform.md)(execution: DelegateExecution) |
| [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md) | [jvm]<br>fun [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md)(execution: DelegateExecution, e: Exception) |
