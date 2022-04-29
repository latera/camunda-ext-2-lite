//[camunda-7.14-ext-2](../../../../index.md)/[com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers](../../index.md)/[CustomerAccount](../index.md)/[CustomerAccount](index.md)

# CustomerAccount

[jvm]\
data class [CustomerAccount](index.md)(**n_account_id**: Long, **n_currency_id**: [Currency](../../../com.hydra_billing.camunda.api.hydra.common_types/-currency/index.md), **vc_currency_code**: String, **vc_name**: String, **vc_code**: String, **vc_account**: String, **vc_rem**: String?, **n_sum_bal**: [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html), **n_sum_free**: [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html), **n_max_credit_limit**: [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)?, **n_sum_reserved_total**: [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html), **n_sum_reserved**: [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html), **has_actual_atu**: Boolean, **permanent_credit_limit**: Map<String, [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)?>, **temporary_credit_limit**: [CustomerAccount.Credit](../-credit/index.md), **scheduled_services_credit_limit**: [CustomerAccount.Credit](../-credit/index.md), **unscheduled_services_credit_limit**: [CustomerAccount.Credit](../-credit/index.md), **actual_charge_logs_amount**: [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html))

## Properties

| Name | Summary |
|---|---|
| [actual_charge_logs_amount](actual_charge_logs_amount.md) | [jvm]<br>val [actual_charge_logs_amount](actual_charge_logs_amount.md): [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html) |
| [has_actual_atu](has_actual_atu.md) | [jvm]<br>val [has_actual_atu](has_actual_atu.md): Boolean |
| [n_account_id](n_account_id.md) | [jvm]<br>val [n_account_id](n_account_id.md): Long |
| [n_currency_id](n_currency_id.md) | [jvm]<br>val [n_currency_id](n_currency_id.md): [Currency](../../../com.hydra_billing.camunda.api.hydra.common_types/-currency/index.md) |
| [n_max_credit_limit](n_max_credit_limit.md) | [jvm]<br>val [n_max_credit_limit](n_max_credit_limit.md): [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)? |
| [n_sum_bal](n_sum_bal.md) | [jvm]<br>val [n_sum_bal](n_sum_bal.md): [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html) |
| [n_sum_free](n_sum_free.md) | [jvm]<br>val [n_sum_free](n_sum_free.md): [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html) |
| [n_sum_reserved](n_sum_reserved.md) | [jvm]<br>val [n_sum_reserved](n_sum_reserved.md): [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html) |
| [n_sum_reserved_total](n_sum_reserved_total.md) | [jvm]<br>val [n_sum_reserved_total](n_sum_reserved_total.md): [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html) |
| [permanent_credit_limit](permanent_credit_limit.md) | [jvm]<br>val [permanent_credit_limit](permanent_credit_limit.md): Map<String, [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)?> |
| [scheduled_services_credit_limit](scheduled_services_credit_limit.md) | [jvm]<br>val [scheduled_services_credit_limit](scheduled_services_credit_limit.md): [CustomerAccount.Credit](../-credit/index.md) |
| [temporary_credit_limit](temporary_credit_limit.md) | [jvm]<br>val [temporary_credit_limit](temporary_credit_limit.md): [CustomerAccount.Credit](../-credit/index.md) |
| [unscheduled_services_credit_limit](unscheduled_services_credit_limit.md) | [jvm]<br>val [unscheduled_services_credit_limit](unscheduled_services_credit_limit.md): [CustomerAccount.Credit](../-credit/index.md) |
| [vc_account](vc_account.md) | [jvm]<br>val [vc_account](vc_account.md): String |
| [vc_code](vc_code.md) | [jvm]<br>val [vc_code](vc_code.md): String |
| [vc_currency_code](vc_currency_code.md) | [jvm]<br>val [vc_currency_code](vc_currency_code.md): String |
| [vc_name](vc_name.md) | [jvm]<br>val [vc_name](vc_name.md): String |
| [vc_rem](vc_rem.md) | [jvm]<br>val [vc_rem](vc_rem.md): String? |
