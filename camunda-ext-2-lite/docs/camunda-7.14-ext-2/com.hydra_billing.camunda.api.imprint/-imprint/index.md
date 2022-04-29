//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.api.imprint](../index.md)/[Imprint](index.md)

# Imprint

[jvm]\
class [Imprint](index.md)(**client**: HttpClient)

## Types

| Name | Summary |
|---|---|
| [File](-file/index.md) | [jvm]<br>data class [File](-file/index.md)(**base64string**: String, **filename**: String) |
| [Options](-options/index.md) | [jvm]<br>data class [Options](-options/index.md)(**convert_to_pdf**: Boolean) |

## Functions

| Name | Summary |
|---|---|
| [print](print.md) | [jvm]<br>fun <[T](print.md)> [print](print.md)(templateName: String, data: [T](print.md), convertToPdf: Boolean): [Imprint.File](-file/index.md) |

## Properties

| Name | Summary |
|---|---|
| [client](client.md) | [jvm]<br>val [client](client.md): HttpClient |
