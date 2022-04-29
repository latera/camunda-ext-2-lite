//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.api.hydra.oms](../index.md)/[File](index.md)

# File

[jvm]\
class [File](index.md)(**client**: HttpClient)

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) : [Logged](../../com.hydra_billing.camunda.Logger/-logged/index.md) |
| [File](-file/index.md) | [jvm]<br>data class [File](-file/index.md)(**url**: String, **name**: String, **origin_name**: String, **real_name**: String, **field_name**: String?, **upload_time**: String, **end_point**: String, **bucket**: String) |
| [FileParams](-file-params/index.md) | [jvm]<br>data class [FileParams](-file-params/index.md)(**name**: String, **content**: String, **fieldName**: String?) |
| [Response](-response/index.md) | [jvm]<br>data class [Response](-response/index.md)(**files**: Array<[File.File](-file/index.md)>) |

## Functions

| Name | Summary |
|---|---|
| [upload](upload.md) | [jvm]<br>fun [upload](upload.md)(files: Array<[File.FileParams](-file-params/index.md)>): Array<[File.File](-file/index.md)> |

## Properties

| Name | Summary |
|---|---|
| [client](client.md) | [jvm]<br>val [client](client.md): HttpClient |
