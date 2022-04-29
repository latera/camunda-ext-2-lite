//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.api.planado_v2](../index.md)/[Template](index.md)

# Template

[jvm]\
class [Template](index.md)(**client**: HttpClient)

## Types

| Name | Summary |
|---|---|
| [GetResponse](-get-response/index.md) | [jvm]<br>data class [GetResponse](-get-response/index.md)(**template**: [Template.TemplateData](-template-data/index.md)) |
| [TemplateData](-template-data/index.md) | [jvm]<br>data class [TemplateData](-template-data/index.md)(**uuid**: String, **name**: String, **description**: String?, **type**: [JobType](../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-type/index.md)?, **assignee**: [JobAssignee](../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-assignee/index.md)?, **territory**: [JobTerritory](../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-territory/index.md)?, **skills**: Array<[Skill](../../com.hydra_billing.camunda.api.planado_v2.common_types/-skill/index.md)>, **custom_fields**: Array<[JobCustomField](../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-custom-field/index.md)>, **report_fields**: Array<[JobCustomField](../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-custom-field/index.md)>, **possible_resolutions**: Array<[JobResolution](../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-resolution/index.md)>, **created_at**: String, **updated_at**: String) |

## Functions

| Name | Summary |
|---|---|
| [get](get.md) | [jvm]<br>fun [get](get.md)(id: String): [Template.TemplateData](-template-data/index.md)<br><ul><li><code>id</code> - Template uuid or external_id /String/</li></ul> |

## Properties

| Name | Summary |
|---|---|
| [client](client.md) | [jvm]<br>val [client](client.md): HttpClient |
