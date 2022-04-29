//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.procs.hydra.subjects](../index.md)/[CreateCustomerAccountProc](index.md)

# CreateCustomerAccountProc

[jvm]\
class [CreateCustomerAccountProc](index.md) : [BaseProc](../../com.hydra_billing.camunda.procs/-base-proc/index.md)

This delegate is designed to create a Customer account via Hydra REST API.

This delegate is using the following execution variables:

<ul><li><code>hydraCustomerId</code> - Customer ID (*required) /Long/</li><li><code>hydraCustomerAccountCurrencyId</code> - Account currency ID (*required*) / [com.hydra_billing.camunda.api.hydra.common_types.Currency](../../com.hydra_billing.camunda.api.hydra.common_types/-currency/index.md)/</li><li><code>hydraCustomerAccountCode</code> - Account code /String?/</li><li><code>hydraCustomerAccountName</code> - Account name /String?/</li><li><code>hydraCustomerAccountNumber</code> - Account number /String?/</li><li><code>hydraCustomerAccountRem</code> - Account comment /String?/</li><li><code>hydraCustomerAccountMaxCreditLimit</code> - Account credit limit maximum value /BigDecimal?/</li></ul>

The result of this delegate execution is the created Customer account and the following variables stored in the Camunda execution:

<ul><li><code>hydraCustomerAccount</code> - created Customer Account ID /CustomerAccount.CustomerAccount/</li></ul>

## Constructors

| | |
|---|---|
| [CreateCustomerAccountProc](-create-customer-account-proc.md) | [jvm]<br>fun [CreateCustomerAccountProc](-create-customer-account-proc.md)() |

## Functions

| Name | Summary |
|---|---|
| [doAction](do-action.md) | [jvm]<br>fun [doAction](do-action.md)(restApi: HttpClient, customerId: Long, createCustomerAccountParams: [CustomerAccount.CreateParams](../../com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers/-customer-account/-create-params/index.md)): [CustomerAccount.CustomerAccount](../../com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers/-customer-account/-customer-account/index.md) |
| [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md) | [jvm]<br>open override fun [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md)(execution: DelegateExecution) |
| [perform](perform.md) | [jvm]<br>open override fun [perform](perform.md)(execution: DelegateExecution) |
| [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md) | [jvm]<br>fun [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md)(execution: DelegateExecution, e: Exception) |
