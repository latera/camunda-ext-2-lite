//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.procs.odoo](../index.md)/[GetCustomerByHydraCustomerIdProc](index.md)

# GetCustomerByHydraCustomerIdProc

[jvm]\
class [GetCustomerByHydraCustomerIdProc](index.md) : [BaseProc](../../com.hydra_billing.camunda.procs/-base-proc/index.md)

This delegate is designed to get Odoo customer by Hydra customer ID.

This delegate is using the following execution variables:

<ul><li><code>hydraCustomerId</code> - Customer ID (*required) /Long/</li></ul>

The result of this delegate execution is the Odoo customer and the following variables stored in the Camunda execution:

<ul><li><code>odooCustomer</code> - Odoo contact /Customer.CustomerData/</li></ul>

## Constructors

| | |
|---|---|
| [GetCustomerByHydraCustomerIdProc](-get-customer-by-hydra-customer-id-proc.md) | [jvm]<br>fun [GetCustomerByHydraCustomerIdProc](-get-customer-by-hydra-customer-id-proc.md)() |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) : [Logged](../../com.hydra_billing.camunda.Logger/-logged/index.md) |

## Functions

| Name | Summary |
|---|---|
| [doAction](do-action.md) | [jvm]<br>fun [doAction](do-action.md)(client: HttpClient, customerId: Long): [Customer.CustomerData](../../com.hydra_billing.camunda.api.odoo/-customer/-customer-data/index.md) |
| [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md) | [jvm]<br>open override fun [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md)(execution: DelegateExecution) |
| [perform](perform.md) | [jvm]<br>open override fun [perform](perform.md)(execution: DelegateExecution) |
| [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md) | [jvm]<br>fun [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md)(execution: DelegateExecution, e: Exception) |
