//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.api.planado_v2](../index.md)/[OrganizationClient](index.md)

# OrganizationClient

[jvm]\
class [OrganizationClient](index.md)(**client**: HttpClient)

## Types

| Name | Summary |
|---|---|
| [ClientData](-client-data/index.md) | [jvm]<br>data class [ClientData](-client-data/index.md)(**uuid**: String?, **external_id**: String?, **name**: String?, **organization_name**: String?, **organization**: Boolean?, **first_name**: String?, **last_name**: String?, **middle_name**: String?, **site_address**: [SiteAddress](../../com.hydra_billing.camunda.api.planado_v2.common_types/-site-address/index.md)?, **contacts**: Array<[Contact](../../com.hydra_billing.camunda.api.planado_v2.common_types/-contact/index.md)>, **version**: Long?, **created_at**: String?, **updated_at**: String?) |
| [CreateOrUpdateResponse](-create-or-update-response/index.md) | [jvm]<br>data class [CreateOrUpdateResponse](-create-or-update-response/index.md)(**client_uuid**: String) |
| [CreateParams](-create-params/index.md) | [jvm]<br>data class [CreateParams](-create-params/index.md)(**organization**: Boolean, **organization_name**: String, **external_id**: String?, **site_address**: [SiteAddress](../../com.hydra_billing.camunda.api.planado_v2.common_types/-site-address/index.md)?, **contacts**: Array<[Contact](../../com.hydra_billing.camunda.api.planado_v2.common_types/-contact/index.md)>?) |
| [GetResponse](-get-response/index.md) | [jvm]<br>data class [GetResponse](-get-response/index.md)(**client**: [OrganizationClient.ClientData](-client-data/index.md)) |
| [UpdateParams](-update-params/index.md) | [jvm]<br>data class [UpdateParams](-update-params/index.md)(**organization**: Boolean, **organization_name**: String, **site_address**: [SiteAddress](../../com.hydra_billing.camunda.api.planado_v2.common_types/-site-address/index.md)?, **contacts**: Array<[Contact](../../com.hydra_billing.camunda.api.planado_v2.common_types/-contact/index.md)>?) |

## Functions

| Name | Summary |
|---|---|
| [create](create.md) | [jvm]<br>fun [create](create.md)(params: [OrganizationClient.CreateParams](-create-params/index.md)): [OrganizationClient.CreateOrUpdateResponse](-create-or-update-response/index.md) |
| [get](get.md) | [jvm]<br>fun [get](get.md)(id: String): [OrganizationClient.ClientData](-client-data/index.md)<br><ul><li><code>id</code> - Client uuid or external_id /String/</li></ul> |
| [update](update.md) | [jvm]<br>fun [update](update.md)(id: String, params: [OrganizationClient.UpdateParams](-update-params/index.md)): [OrganizationClient.CreateOrUpdateResponse](-create-or-update-response/index.md)<br><ul><li><code>id</code> - Client uuid or external_id /String/</li></ul> |

## Properties

| Name | Summary |
|---|---|
| [client](client.md) | [jvm]<br>val [client](client.md): HttpClient |
