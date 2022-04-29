//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.procs.hydra.addresses](../index.md)/[UpdateEquipmentComponentAddressProc](index.md)

# UpdateEquipmentComponentAddressProc

[jvm]\
class [UpdateEquipmentComponentAddressProc](index.md) : [BaseProc](../../com.hydra_billing.camunda.procs/-base-proc/index.md)

This delegate is designed to update a EquipmentComponent componentaddress via Hydra REST API.

This delegate is using the following execution variables:

<ul><li><code>hydraEquipmentComponentId</code> - Equipment component ID (*required*) /Long/</li><li><code>hydraEquipmentComponentAddressTypeId</code> - Equipment component address type ID / [com.hydra_billing.camunda.api.hydra.common_types.AddressType](../../com.hydra_billing.camunda.api.hydra.common_types/-address-type/index.md)?/</li><li><code>hydraEquipmentComponentParAddressId</code> - Equipment component par address ID /Long?/</li><li><code>hydraEquipmentComponentBindAddrId</code> - Equipment component bind address ID /Long?/</li><li><code>hydraEquipmentComponentAddressFirmId</code> - Equipment component address firm ID /Long?/</li><li><code>hydraEquipmentComponentAddressBindTypeId</code> - Equipment component address bind type ID /[com.hydra_billing.camunda.api.hydra.common_types.BindAddressType](../../com.hydra_billing.camunda.api.hydra.common_types/-bind-address-type/index.md)?/</li><li><code>hydraEquipmentComponentAddressRaw</code> - Equipment component raw address (non-standard address) /String?/</li><li><code>hydraEquipmentComponentAddressCode</code> - Equipment component address (e.g. phone number, email) /String?/</li><li><code>hydraEquipmentComponentAddressFloorNo</code> - Equipment component address floor /Long?/</li><li><code>hydraEquipmentComponentAddressRegionId</code> - Equipment component address region ID /Long?/</li><li><code>hydraEquipmentComponentAddressBeginDate</code> - Equipment component address begin date /String?/</li><li><code>hydraEquipmentComponentAddressEndDate</code> - Equipment component address end date /String?/</li><li><code>hydraEquipmentComponentAddressRem</code> - Equipment component address comment /String?/</li><li><code>hydraEquipmentComponentAddressIntercom</code> - Equipment component address intercom code /String?/</li><li><code>hydraEquipmentComponentAddressEntrance</code> - Equipment component address entrance /String?/</li><li><code>hydraEquipmentComponentAddressFlat</code> - Equipment component address flat /String?/</li><li><code>hydraEquipmentComponentAddressMask</code> - Equipment component address mask /Long?/</li><li><code>hydraEquipmentComponentAddressIsRealSubnet</code> - Equipment component address real subnet flag /String?/</li></ul>

The result of this delegate execution is the updated Equipment component address and the following variables stored in the Camunda execution:

<ul><li><code>hydraEquipmentComponentAddress</code> - Updated Equipment component address /net_devices.Types.AddressParams/</li></ul>

## Constructors

| | |
|---|---|
| [UpdateEquipmentComponentAddressProc](-update-equipment-component-address-proc.md) | [jvm]<br>fun [UpdateEquipmentComponentAddressProc](-update-equipment-component-address-proc.md)() |

## Functions

| Name | Summary |
|---|---|
| [doAction](do-action.md) | [jvm]<br>fun [doAction](do-action.md)(restApi: HttpClient, equipmentComponentId: Long, addressId: Long, updateEquipmentComponentAddressParams: [UpdateAddressParams](../../com.hydra_billing.camunda.api.hydra.rest.v2.net_devices.types/-update-address-params/index.md)): [AddressParams](../../com.hydra_billing.camunda.api.hydra.rest.v2.net_devices.types/-address-params/index.md) |
| [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md) | [jvm]<br>open override fun [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md)(execution: DelegateExecution) |
| [perform](perform.md) | [jvm]<br>open override fun [perform](perform.md)(execution: DelegateExecution) |
| [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md) | [jvm]<br>fun [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md)(execution: DelegateExecution, e: Exception) |
