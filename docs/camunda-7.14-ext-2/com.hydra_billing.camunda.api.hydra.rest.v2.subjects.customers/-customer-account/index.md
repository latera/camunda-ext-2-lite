//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers](../index.md)/[CustomerAccount](index.md)

# CustomerAccount

[jvm]\
class [CustomerAccount](index.md)(**client**: HttpClient)

## Types

| Name | Summary |
|---|---|
| [Charge](-charge/index.md) | [jvm]<br>data class [Charge](-charge/index.md)(**n_doc_id**: Long, **n_service_id**: Long, **n_sum**: [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html), **d_begin**: String, **d_end**: String, **vc_rem**: String, **n_currency_id**: [Currency](../../com.hydra_billing.camunda.api.hydra.common_types/-currency/index.md), **vc_currency**: String) |
| [ChargesResponse](-charges-response/index.md) | [jvm]<br>data class [ChargesResponse](-charges-response/index.md)(**charges**: Array<[CustomerAccount.Charge](-charge/index.md)>) |
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) : [Logged](../../com.hydra_billing.camunda.Logger/-logged/index.md) |
| [CreateParams](-create-params/index.md) | [jvm]<br>data class [CreateParams](-create-params/index.md)(**n_currency_id**: [Currency](../../com.hydra_billing.camunda.api.hydra.common_types/-currency/index.md), **vc_code**: String?, **vc_name**: String?, **vc_account**: String?, **vc_rem**: String?, **n_max_credit_limit**: [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)?) |
| [Credit](-credit/index.md) | [jvm]<br>data class [Credit](-credit/index.md)(**n_sum**: [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)?, **d_end**: String?) |
| [CustomerAccount](-customer-account/index.md) | [jvm]<br>data class [CustomerAccount](-customer-account/index.md)(**n_account_id**: Long, **n_currency_id**: [Currency](../../com.hydra_billing.camunda.api.hydra.common_types/-currency/index.md), **vc_currency_code**: String, **vc_name**: String, **vc_code**: String, **vc_account**: String, **vc_rem**: String?, **n_sum_bal**: [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html), **n_sum_free**: [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html), **n_max_credit_limit**: [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)?, **n_sum_reserved_total**: [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html), **n_sum_reserved**: [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html), **has_actual_atu**: Boolean, **permanent_credit_limit**: Map<String, [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)?>, **temporary_credit_limit**: [CustomerAccount.Credit](-credit/index.md), **scheduled_services_credit_limit**: [CustomerAccount.Credit](-credit/index.md), **unscheduled_services_credit_limit**: [CustomerAccount.Credit](-credit/index.md), **actual_charge_logs_amount**: [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)) |
| [PersonalAccount](-personal-account/index.md) | [jvm]<br>data class [PersonalAccount](-personal-account/index.md)(**n_subject_id**: Long, **vc_subj_code**: String, **vc_subj_name**: String, **n_subj_state_id**: [SubjectState](../../com.hydra_billing.camunda.api.hydra.common_types/-subject-state/index.md), **n_firm_id**: Long, **n_account_id**: Long, **n_account_type_id**: [AccountType](../../com.hydra_billing.camunda.api.hydra.common_types/-account-type/index.md), **vc_account_type_name**: String, **n_bank_id**: Long, **vc_bank_name**: String, **n_currency_id**: [Currency](../../com.hydra_billing.camunda.api.hydra.common_types/-currency/index.md), **vc_currency_code**: String, **vc_name**: String, **vc_code**: String, **vc_account**: String, **d_open**: String?, **d_close**: String?, **n_max_overdraft**: [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)?, **vc_bank**: String?, **vc_rem**: String?, **vc_code_ex**: String?) |
| [PersonalAccountResponse](-personal-account-response/index.md) | [jvm]<br>data class [PersonalAccountResponse](-personal-account-response/index.md)(**personal_account**: [CustomerAccount.PersonalAccount](-personal-account/index.md)) |
| [Response](-response/index.md) | [jvm]<br>data class [Response](-response/index.md)(**account**: [CustomerAccount.CustomerAccount](-customer-account/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [create](create.md) | [jvm]<br>fun [create](create.md)(params: [CustomerAccount.CreateParams](-create-params/index.md), customerId: Long): [CustomerAccount.CustomerAccount](-customer-account/index.md) |
| [getAccountById](get-account-by-id.md) | [jvm]<br>fun [getAccountById](get-account-by-id.md)(id: Long): [CustomerAccount.PersonalAccount](-personal-account/index.md) |
| [listCustomerAccountCharges](list-customer-account-charges.md) | [jvm]<br>fun [listCustomerAccountCharges](list-customer-account-charges.md)(accountId: Long, beginDate: String, endDate: String): Array<[CustomerAccount.Charge](-charge/index.md)> |

## Properties

| Name | Summary |
|---|---|
| [client](client.md) | [jvm]<br>val [client](client.md): HttpClient |
