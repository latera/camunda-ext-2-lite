//[camunda-7.14-ext-2](../../../../index.md)/[com.hydra_billing.camunda.api.planado_v2](../../index.md)/[Template](../index.md)/[TemplateData](index.md)

# TemplateData

[jvm]\
data class [TemplateData](index.md)(**uuid**: String, **name**: String, **description**: String?, **type**: [JobType](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-type/index.md)?, **assignee**: [JobAssignee](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-assignee/index.md)?, **territory**: [JobTerritory](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-territory/index.md)?, **skills**: Array<[Skill](../../../com.hydra_billing.camunda.api.planado_v2.common_types/-skill/index.md)>, **custom_fields**: Array<[JobCustomField](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-custom-field/index.md)>, **report_fields**: Array<[JobCustomField](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-custom-field/index.md)>, **possible_resolutions**: Array<[JobResolution](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-resolution/index.md)>, **created_at**: String, **updated_at**: String)

## Properties

| Name | Summary |
|---|---|
| [assignee](assignee.md) | [jvm]<br>val [assignee](assignee.md): [JobAssignee](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-assignee/index.md)? = null |
| [created_at](created_at.md) | [jvm]<br>val [created_at](created_at.md): String |
| [custom_fields](custom_fields.md) | [jvm]<br>val [custom_fields](custom_fields.md): Array<[JobCustomField](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-custom-field/index.md)> |
| [description](description.md) | [jvm]<br>val [description](description.md): String? = null |
| [name](name.md) | [jvm]<br>val [name](name.md): String |
| [possible_resolutions](possible_resolutions.md) | [jvm]<br>val [possible_resolutions](possible_resolutions.md): Array<[JobResolution](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-resolution/index.md)> |
| [report_fields](report_fields.md) | [jvm]<br>val [report_fields](report_fields.md): Array<[JobCustomField](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-custom-field/index.md)> |
| [skills](skills.md) | [jvm]<br>val [skills](skills.md): Array<[Skill](../../../com.hydra_billing.camunda.api.planado_v2.common_types/-skill/index.md)> |
| [territory](territory.md) | [jvm]<br>val [territory](territory.md): [JobTerritory](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-territory/index.md)? = null |
| [type](type.md) | [jvm]<br>val [type](type.md): [JobType](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-type/index.md)? = null |
| [updated_at](updated_at.md) | [jvm]<br>val [updated_at](updated_at.md): String |
| [uuid](uuid.md) | [jvm]<br>val [uuid](uuid.md): String |
