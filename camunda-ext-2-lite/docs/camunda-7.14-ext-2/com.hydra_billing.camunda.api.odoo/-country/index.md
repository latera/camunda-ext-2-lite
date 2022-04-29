//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.api.odoo](../index.md)/[Country](index.md)

# Country

[jvm]\
class [Country](index.md)(**client**: HttpClient)

## Types

| Name | Summary |
|---|---|
| [CountryData](-country-data/index.md) | [jvm]<br>data class [CountryData](-country-data/index.md)(**id**: Long?, **code**: String?, **name**: String?, **currency_id**: Long?, **phone_code**: Long?, **address_format**: String?, **vat_label**: String?) |

## Functions

| Name | Summary |
|---|---|
| [getByNativeId](get-by-native-id.md) | [jvm]<br>fun [getByNativeId](get-by-native-id.md)(id: Long): [Country.CountryData](-country-data/index.md) |

## Properties

| Name | Summary |
|---|---|
| [client](client.md) | [jvm]<br>val [client](client.md): HttpClient |
