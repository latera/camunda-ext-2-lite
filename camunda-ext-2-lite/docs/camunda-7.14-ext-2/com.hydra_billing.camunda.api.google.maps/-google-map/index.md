//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.api.google.maps](../index.md)/[GoogleMap](index.md)

# GoogleMap

[jvm]\
class [GoogleMap](index.md)(**client**: HttpClient)

## Types

| Name | Summary |
|---|---|
| [AddressComponent](-address-component/index.md) | [jvm]<br>data class [AddressComponent](-address-component/index.md)(**long_name**: String, **short_name**: String, **types**: Array<String>) |
| [Bounds](-bounds/index.md) | [jvm]<br>data class [Bounds](-bounds/index.md)(**northeast**: [GoogleMap.Coordinates](-coordinates/index.md), **southwest**: [GoogleMap.Coordinates](-coordinates/index.md)) |
| [Coordinates](-coordinates/index.md) | [jvm]<br>data class [Coordinates](-coordinates/index.md)(**lat**: [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html), **lng**: [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)) |
| [Geometry](-geometry/index.md) | [jvm]<br>data class [Geometry](-geometry/index.md)(**bounds**: [GoogleMap.Bounds](-bounds/index.md), **location**: [GoogleMap.Coordinates](-coordinates/index.md), **location_type**: String, **viewport**: [GoogleMap.Bounds](-bounds/index.md)) |
| [Response](-response/index.md) | [jvm]<br>data class [Response](-response/index.md)(**results**: Array<[GoogleMap.Result](-result/index.md)>, **status**: String, **error_message**: String?) |
| [Result](-result/index.md) | [jvm]<br>data class [Result](-result/index.md)(**address_components**: Array<[GoogleMap.AddressComponent](-address-component/index.md)>, **formatted_address**: String, **geometry**: [GoogleMap.Geometry](-geometry/index.md), **place_id**: String, **types**: Array<String>) |

## Functions

| Name | Summary |
|---|---|
| [geocode](geocode.md) | [jvm]<br>fun [geocode](geocode.md)(address: String): [GoogleMap.Response](-response/index.md) |

## Properties

| Name | Summary |
|---|---|
| [client](client.md) | [jvm]<br>val [client](client.md): HttpClient |
