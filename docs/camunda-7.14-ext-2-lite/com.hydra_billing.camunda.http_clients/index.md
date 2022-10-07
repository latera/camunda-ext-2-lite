//[camunda-7.14-ext-2-lite](../../index.md)/[com.hydra_billing.camunda.http_clients](index.md)

# Package com.hydra_billing.camunda.http_clients

## Types

| Name | Summary |
|---|---|
| [HomsClient](-homs-client/index.md) | [jvm]<br>object [HomsClient](-homs-client/index.md) |
| [HTTPTimeoutsConfig](-h-t-t-p-timeouts-config/index.md) | [jvm]<br>data class [HTTPTimeoutsConfig](-h-t-t-p-timeouts-config/index.md)(**requestTimeout**: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), **connectTimeout**: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), **socketTimeout**: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [NullableTypeAdapterFactory](-nullable-type-adapter-factory/index.md) | [jvm]<br>class [NullableTypeAdapterFactory](-nullable-type-adapter-factory/index.md) : TypeAdapterFactory |

## Functions

| Name | Summary |
|---|---|
| [errorValidation](error-validation.md) | [jvm]<br>fun HttpCallValidator.Config.[errorValidation](error-validation.md)() |
| [installGsonSerializer](install-gson-serializer.md) | [jvm]<br>fun HttpClientConfig<*>.[installGsonSerializer](install-gson-serializer.md)() |
| [installTimeOutConfig](install-time-out-config.md) | [jvm]<br>fun HttpClientConfig<*>.[installTimeOutConfig](install-time-out-config.md)(config: [HTTPTimeoutsConfig](-h-t-t-p-timeouts-config/index.md)) |
