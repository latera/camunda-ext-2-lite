//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.procs.hydra.objects](../index.md)/[GetCustomerEquipmentListProc](index.md)

# GetCustomerEquipmentListProc

[jvm]\
class [GetCustomerEquipmentListProc](index.md) : [BaseProc](../../com.hydra_billing.camunda.procs/-base-proc/index.md)

This delegate is designed to show a subjects equipments via Hydra REST API.

This delegate is using the following execution variables:

<ul><li><code>hydraCustomerId</code> - Customer ID (*required) /Long/</li></ul>

The result of this delegate execution is the following variables stored in the Camunda execution:

<ul><li><code>hydraCustomerEquipmentList</code> - Array of CustomerEquipment /Array<CustomerEquipment.CustomerEquipment>/</li></ul>

## Constructors

| | |
|---|---|
| [GetCustomerEquipmentListProc](-get-customer-equipment-list-proc.md) | [jvm]<br>fun [GetCustomerEquipmentListProc](-get-customer-equipment-list-proc.md)() |

## Functions

| Name | Summary |
|---|---|
| [doAction](do-action.md) | [jvm]<br>fun [doAction](do-action.md)(restApi: HttpClient, customerId: Long): Array<[CustomerEquipment.CustomerEquipment](../../com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers/-customer-equipment/-customer-equipment/index.md)> |
| [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md) | [jvm]<br>open override fun [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md)(execution: DelegateExecution) |
| [perform](perform.md) | [jvm]<br>open override fun [perform](perform.md)(execution: DelegateExecution) |
| [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md) | [jvm]<br>fun [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md)(execution: DelegateExecution, e: Exception) |
