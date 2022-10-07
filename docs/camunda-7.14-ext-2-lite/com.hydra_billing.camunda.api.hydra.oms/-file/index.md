//[camunda-7.14-ext-2-lite](../../../index.md)/[com.hydra_billing.camunda.api.hydra.oms](../index.md)/[File](index.md)

# File

[jvm]\
class [File](index.md)(**client**: HttpClient)

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) : [Logged](../../com.hydra_billing.camunda.Logger/-logged/index.md) |
| [File](-file/index.md) | [jvm]<br>data class [File](-file/index.md)(**url**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **origin_name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **real_name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **field_name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, **upload_time**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **end_point**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **bucket**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [FileParams](-file-params/index.md) | [jvm]<br>data class [FileParams](-file-params/index.md)(**name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **content**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **fieldName**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) |
| [Response](-response/index.md) | [jvm]<br>data class [Response](-response/index.md)(**files**: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[File.File](-file/index.md)>) |

## Functions

| Name | Summary |
|---|---|
| [upload](upload.md) | [jvm]<br>fun [upload](upload.md)(files: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[File.FileParams](-file-params/index.md)>): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[File.File](-file/index.md)> |

## Properties

| Name | Summary |
|---|---|
| [client](client.md) | [jvm]<br>val [client](client.md): HttpClient |
