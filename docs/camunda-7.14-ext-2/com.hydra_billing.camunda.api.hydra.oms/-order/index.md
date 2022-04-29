//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.api.hydra.oms](../index.md)/[Order](index.md)

# Order

[jvm]\
class [Order](index.md)(**client**: HttpClient)

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) : [Logged](../../com.hydra_billing.camunda.Logger/-logged/index.md) |
| [ListResponse](-list-response/index.md) | [jvm]<br>data class [ListResponse](-list-response/index.md)<[T](-list-response/index.md)>(**orders**: Array<[Order.Order](-order/index.md)<[T](-list-response/index.md)>>) |
| [Order](-order/index.md) | [jvm]<br>data class [Order](-order/index.md)<[T](-order/index.md)>(**id**: Long, **code**: String, **ext_code**: String?, **bp_id**: String?, **bp_state**: String?, **state**: String, **archived**: Boolean, **data**: [T](-order/index.md), **done_at**: String?, **order_type_code**: String, **user_email**: String?) |
| [OrderParams](-order-params/index.md) | [jvm]<br>data class [OrderParams](-order-params/index.md)<[T](-order-params/index.md)>(**code**: String?, **ext_code**: String?, **bp_id**: String?, **bp_state**: String?, **state**: String, **archived**: Boolean, **data**: [T](-order-params/index.md), **done_at**: String?, **order_type_code**: String, **user_email**: String?) |
| [Response](-response/index.md) | [jvm]<br>data class [Response](-response/index.md)<[T](-response/index.md)>(**order**: [Order.Order](-order/index.md)<[T](-response/index.md)>) |

## Functions

| Name | Summary |
|---|---|
| [create](create.md) | [jvm]<br>inline fun <[T](create.md)> [create](create.md)(params: [Order.OrderParams](-order-params/index.md)<[T](create.md)>): [Order.Order](-order/index.md)<[T](create.md)> |
| [list](list.md) | [jvm]<br>inline fun <[T](list.md)> [list](list.md)(page: Int, page_size: Int): Array<[Order.Order](-order/index.md)<[T](list.md)>> |
| [show](show.md) | [jvm]<br>inline fun <[T](show.md)> [show](show.md)(code: String): [Order.Order](-order/index.md)<[T](show.md)> |
| [update](update.md) | [jvm]<br>inline fun <[T](update.md)> [update](update.md)(params: [Order.OrderParams](-order-params/index.md)<[T](update.md)>): [Order.Order](-order/index.md)<[T](update.md)> |

## Properties

| Name | Summary |
|---|---|
| [client](client.md) | [jvm]<br>val [client](client.md): HttpClient |
