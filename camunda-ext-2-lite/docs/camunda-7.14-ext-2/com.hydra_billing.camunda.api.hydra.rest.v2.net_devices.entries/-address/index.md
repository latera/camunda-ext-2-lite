//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.api.hydra.rest.v2.net_devices.entries](../index.md)/[Address](index.md)

# Address

[jvm]\
class [Address](index.md)(**client**: HttpClient)

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) : [Logged](../../com.hydra_billing.camunda.Logger/-logged/index.md) |

## Functions

| Name | Summary |
|---|---|
| [create](create.md) | [jvm]<br>fun [create](create.md)(params: [CreateAddressParams](../../com.hydra_billing.camunda.api.hydra.rest.v2.net_devices.types/-create-address-params/index.md), deviceId: Long, entryId: Long): [AddressParams](../../com.hydra_billing.camunda.api.hydra.rest.v2.net_devices.types/-address-params/index.md) |
| [delete](delete.md) | [jvm]<br>fun [delete](delete.md)(deviceId: Long, entryId: Long, addressId: Long): Boolean |
| [get](get.md) | [jvm]<br>fun [get](get.md)(deviceId: Long, entryId: Long, addressId: Long): [AddressParams](../../com.hydra_billing.camunda.api.hydra.rest.v2.net_devices.types/-address-params/index.md) |
| [list](list.md) | [jvm]<br>fun [list](list.md)(deviceId: Long, entryId: Long): Array<[AddressParams](../../com.hydra_billing.camunda.api.hydra.rest.v2.net_devices.types/-address-params/index.md)> |
| [update](update.md) | [jvm]<br>fun [update](update.md)(params: [UpdateAddressParams](../../com.hydra_billing.camunda.api.hydra.rest.v2.net_devices.types/-update-address-params/index.md), deviceId: Long, entryId: Long, addressId: Long): [AddressParams](../../com.hydra_billing.camunda.api.hydra.rest.v2.net_devices.types/-address-params/index.md) |

## Properties

| Name | Summary |
|---|---|
| [client](client.md) | [jvm]<br>val [client](client.md): HttpClient |
