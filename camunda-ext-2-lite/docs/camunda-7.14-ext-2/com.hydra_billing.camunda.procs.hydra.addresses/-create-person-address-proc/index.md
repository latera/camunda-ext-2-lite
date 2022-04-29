//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.procs.hydra.addresses](../index.md)/[CreatePersonAddressProc](index.md)

# CreatePersonAddressProc

[jvm]\
class [CreatePersonAddressProc](index.md) : [BaseProc](../../com.hydra_billing.camunda.procs/-base-proc/index.md)

This delegate is designed to create a Person address via Hydra REST API.

This delegate is using the following execution variables:

<ul><li><code>hydraPersonId</code> - Person ID (*required*) /Long/</li><li><code>hydraPersonAddressTypeId</code> - Person address type ID (*required*) / [com.hydra_billing.camunda.api.hydra.common_types.AddressType](../../com.hydra_billing.camunda.api.hydra.common_types/-address-type/index.md)/</li><li><code>hydraPersonAddressBindTypeId</code> - Person address bind type ID (*required*) / [com.hydra_billing.camunda.api.hydra.common_types.BindAddressType](../../com.hydra_billing.camunda.api.hydra.common_types/-bind-address-type/index.md)/</li><li><code>hydraPersonAddressStateId</code> - Person address state ID (*required*) / [com.hydra_billing.camunda.api.hydra.common_types.AddressState](../../com.hydra_billing.camunda.api.hydra.common_types/-address-state/index.md)/</li><li><code>hydraPersonAddressRaw</code> - Person raw address (non-standard address) /String?/</li><li><code>hydraPersonAddressCode</code> - Person address (e.g. phone number, email) /String?/</li><li><code>hydraPersonAddressFloorNo</code> - Person address floor /Long?/</li><li><code>hydraPersonAddressRegionId</code> - Person address region ID /Long?/</li><li><code>hydraPersonAddressBeginDate</code> - Person address begin date /String?/</li><li><code>hydraPersonAddressEndDate</code> - Person address end date /String?/</li><li><code>hydraPersonAddressRem</code> - Person address comment /String?/</li><li><code>hydraPersonAddressIsMain</code> - Person address main flag /String?/</li><li><code>hydraPersonAddressIntercom</code> - Person address intercom code /String?/</li><li><code>hydraPersonAddressEntrance</code> - Person address entrance /String?/</li><li><code>hydraPersonAddressFlat</code> - Person address flat /String?/</li></ul>

The result of this delegate execution is the created Person address and the following variables stored in the Camunda execution:

<ul><li><code>hydraPersonAddress</code> - Created Person address /PersonAddress.Address/</li></ul>

## Constructors

| | |
|---|---|
| [CreatePersonAddressProc](-create-person-address-proc.md) | [jvm]<br>fun [CreatePersonAddressProc](-create-person-address-proc.md)() |

## Functions

| Name | Summary |
|---|---|
| [doAction](do-action.md) | [jvm]<br>fun [doAction](do-action.md)(restApi: HttpClient, personId: Long, createPersonAddressParams: [PersonAddress.CreateParams](../../com.hydra_billing.camunda.api.hydra.rest.v2.subjects.persons/-person-address/-create-params/index.md)): [PersonAddress.Address](../../com.hydra_billing.camunda.api.hydra.rest.v2.subjects.persons/-person-address/-address/index.md) |
| [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md) | [jvm]<br>open override fun [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md)(execution: DelegateExecution) |
| [perform](perform.md) | [jvm]<br>open override fun [perform](perform.md)(execution: DelegateExecution) |
| [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md) | [jvm]<br>fun [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md)(execution: DelegateExecution, e: Exception) |
