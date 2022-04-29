//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.api.odoo](../index.md)/[Customer](index.md)

# Customer

[jvm]\
class [Customer](index.md)(**client**: HttpClient)

## Types

| Name | Summary |
|---|---|
| [CustomerData](-customer-data/index.md) | [jvm]<br>data class [CustomerData](-customer-data/index.md)(**id**: Long?, **name**: String?, **email**: String?, **is_company**: Boolean?, **company_name**: String?, **company_id**: Long?, **user_id**: Long?, **phone**: String?, **country_id**: Long?, **state_id**: Long?, **city**: String?, **street**: String?, **street2**: String?, **zip**: String?, **hydra_customer_id**: String?, **comment**: String?) |
| [SearchBody](-search-body/index.md) | [jvm]<br>data class [SearchBody](-search-body/index.md)(**args**: Array<Array<Array<Any>>>) |

## Functions

| Name | Summary |
|---|---|
| [create](create.md) | [jvm]<br>fun [create](create.md)(params: [Customer.CustomerData](-customer-data/index.md)): [Customer.CustomerData](-customer-data/index.md) |
| [getByHydraId](get-by-hydra-id.md) | [jvm]<br>fun [getByHydraId](get-by-hydra-id.md)(hydraCustomerId: Long): [Customer.CustomerData](-customer-data/index.md) |
| [getByNativeId](get-by-native-id.md) | [jvm]<br>fun [getByNativeId](get-by-native-id.md)(id: Long): [Customer.CustomerData](-customer-data/index.md) |

## Properties

| Name | Summary |
|---|---|
| [client](client.md) | [jvm]<br>val [client](client.md): HttpClient |
