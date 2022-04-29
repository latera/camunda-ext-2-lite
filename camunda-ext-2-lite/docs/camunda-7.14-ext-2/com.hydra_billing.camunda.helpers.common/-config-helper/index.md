//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.helpers.common](../index.md)/[ConfigHelper](index.md)

# ConfigHelper

[jvm]\
object [ConfigHelper](index.md)

## Types

| Name | Summary |
|---|---|
| [OdooConfig](-odoo-config/index.md) | [jvm]<br>data class [OdooConfig](-odoo-config/index.md)(**url**: String, **useSSL**: Boolean, **login**: String, **token**: String, **oa_name**: String, **timeout**: Long) |
| [PlanadoConfig](-planado-config/index.md) | [jvm]<br>data class [PlanadoConfig](-planado-config/index.md)(**url**: String, **token**: String, **timeout**: Long) |
| [RestConfig](-rest-config/index.md) | [jvm]<br>data class [RestConfig](-rest-config/index.md)(**url**: String, **useSSL**: Boolean, **login**: String, **password**: String, **timeout**: Long) |

## Functions

| Name | Summary |
|---|---|
| [getDefaultGoogleMapConfig](get-default-google-map-config.md) | [jvm]<br>fun [getDefaultGoogleMapConfig](get-default-google-map-config.md)(): [GoogleMapClient.Config](../../com.hydra_billing.camunda.http_clients/-google-map-client/-config/index.md) |
| [getDefaultHIDConfig](get-default-h-i-d-config.md) | [jvm]<br>fun [getDefaultHIDConfig](get-default-h-i-d-config.md)(): [HidClient.Config](../../com.hydra_billing.camunda.xml_rpc_clients/-hid-client/-config/index.md) |
| [getDefaultHOMSConfig](get-default-h-o-m-s-config.md) | [jvm]<br>fun [getDefaultHOMSConfig](get-default-h-o-m-s-config.md)(): [HomsClient.Config](../../com.hydra_billing.camunda.http_clients/-homs-client/-config/index.md) |
| [getDefaultImprintConfig](get-default-imprint-config.md) | [jvm]<br>fun [getDefaultImprintConfig](get-default-imprint-config.md)(): [ImprintClient.Config](../../com.hydra_billing.camunda.http_clients/-imprint-client/-config/index.md) |
| [getDefaultOdooConfig](get-default-odoo-config.md) | [jvm]<br>fun [getDefaultOdooConfig](get-default-odoo-config.md)(): [ConfigHelper.OdooConfig](-odoo-config/index.md) |
| [getDefaultPlanadoConfig](get-default-planado-config.md) | [jvm]<br>fun [getDefaultPlanadoConfig](get-default-planado-config.md)(): [ConfigHelper.PlanadoConfig](-planado-config/index.md) |
| [getDefaultRestConfig](get-default-rest-config.md) | [jvm]<br>fun [getDefaultRestConfig](get-default-rest-config.md)(): [ConfigHelper.RestConfig](-rest-config/index.md) |
| [getDefaultSMTPConfig](get-default-s-m-t-p-config.md) | [jvm]<br>fun [getDefaultSMTPConfig](get-default-s-m-t-p-config.md)(): [SMTPApi.Config](../../com.hydra_billing.camunda.api/-s-m-t-p-api/-config/index.md) |

## Properties

| Name | Summary |
|---|---|
| [defaultTimeout](default-timeout.md) | [jvm]<br>const val [defaultTimeout](default-timeout.md): Long = 180000 |
