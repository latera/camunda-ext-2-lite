//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.procs.hydra.objects](../index.md)/[CreateCustomerEquipmentProc](index.md)

# CreateCustomerEquipmentProc

[jvm]\
class [CreateCustomerEquipmentProc](index.md) : [BaseProc](../../com.hydra_billing.camunda.procs/-base-proc/index.md)

This delegate is designed to create a Customer equipment via Hydra REST API.

This delegate is using the following execution variables:

<ul><li><code>hydraCustomerId</code> - Customer ID (*required) /Long/</li><li><code>hydraCustomerEquipmentGoodId</code> - Equipment good ID (*required*) /Long/</li><li><code>hydraCustomerEquipmentMainObjectId</code> - Equipment main object ID /Long?/</li><li><code>hydraCustomerEquipmentCode</code> - Equipment code /String?/</li></ul>

The result of this delegate execution is the created Customer equipment and the following variables stored in the Camunda execution:

<ul><li><code>hydraCustomerEquipment</code> - created Customer equipment /CustomerEquipment.CustomerEquipment/</li></ul>

## Constructors

| | |
|---|---|
| [CreateCustomerEquipmentProc](-create-customer-equipment-proc.md) | [jvm]<br>fun [CreateCustomerEquipmentProc](-create-customer-equipment-proc.md)() |

## Functions

| Name | Summary |
|---|---|
| [doAction](do-action.md) | [jvm]<br>fun [doAction](do-action.md)(restApi: HttpClient, customerId: Long, createCustomerEquipmentParams: [CustomerEquipment.CreateParams](../../com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers/-customer-equipment/-create-params/index.md)): [CustomerEquipment.CustomerEquipment](../../com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers/-customer-equipment/-customer-equipment/index.md) |
| [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md) | [jvm]<br>open override fun [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md)(execution: DelegateExecution) |
| [perform](perform.md) | [jvm]<br>open override fun [perform](perform.md)(execution: DelegateExecution) |
| [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md) | [jvm]<br>fun [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md)(execution: DelegateExecution, e: Exception) |
