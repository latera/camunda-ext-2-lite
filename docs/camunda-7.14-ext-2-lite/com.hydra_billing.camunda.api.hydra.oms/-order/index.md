//[camunda-7.14-ext-2-lite](../../../index.md)/[com.hydra_billing.camunda.api.hydra.oms](../index.md)/[Order](index.md)

# Order

[jvm]\
class [Order](index.md)(**client**: HttpClient)

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) : [Logged](../../com.hydra_billing.camunda.Logger/-logged/index.md) |
| [ListResponse](-list-response/index.md) | [jvm]<br>data class [ListResponse](-list-response/index.md)<[T](-list-response/index.md)>(**orders**: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[Order.Order](-order/index.md)<[T](-list-response/index.md)>>) |
| [Order](-order/index.md) | [jvm]<br>data class [Order](-order/index.md)<[T](-order/index.md)>(**id**: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), **code**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **ext_code**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, **bp_id**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, **bp_state**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, **state**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **archived**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), **data**: [T](-order/index.md), **done_at**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, **order_type_code**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **user_email**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) |
| [OrderParams](-order-params/index.md) | [jvm]<br>data class [OrderParams](-order-params/index.md)<[T](-order-params/index.md)>(**code**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, **ext_code**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, **bp_id**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, **bp_state**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, **state**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **archived**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), **data**: [T](-order-params/index.md), **done_at**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, **order_type_code**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **user_email**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) |
| [Response](-response/index.md) | [jvm]<br>data class [Response](-response/index.md)<[T](-response/index.md)>(**order**: [Order.Order](-order/index.md)<[T](-response/index.md)>) |

## Functions

| Name | Summary |
|---|---|
| [create](create.md) | [jvm]<br>inline fun <[T](create.md)> [create](create.md)(params: [Order.OrderParams](-order-params/index.md)<[T](create.md)>): [Order.Order](-order/index.md)<[T](create.md)> |
| [list](list.md) | [jvm]<br>inline fun <[T](list.md)> [list](list.md)(page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), page_size: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[Order.Order](-order/index.md)<[T](list.md)>> |
| [show](show.md) | [jvm]<br>inline fun <[T](show.md)> [show](show.md)(code: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Order.Order](-order/index.md)<[T](show.md)> |
| [update](update.md) | [jvm]<br>inline fun <[T](update.md)> [update](update.md)(params: [Order.OrderParams](-order-params/index.md)<[T](update.md)>): [Order.Order](-order/index.md)<[T](update.md)> |

## Properties

| Name | Summary |
|---|---|
| [client](client.md) | [jvm]<br>val [client](client.md): HttpClient |
