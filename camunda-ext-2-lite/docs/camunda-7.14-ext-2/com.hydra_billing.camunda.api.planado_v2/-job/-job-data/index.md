//[camunda-7.14-ext-2](../../../../index.md)/[com.hydra_billing.camunda.api.planado_v2](../../index.md)/[Job](../index.md)/[JobData](index.md)

# JobData

[jvm]\
data class [JobData](index.md)(**uuid**: String?, **external_id**: String?, **external_order_id**: String?, **serial_no**: Long, **status**: String, **scheduled_at**: String?, **scheduled_duration**: [JobDuration](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-duration/index.md)?, **description**: String?, **assignee**: [JobAssignee](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-assignee/index.md)?, **type**: [JobType](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-type/index.md)?, **template**: [JobTemplate](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-template/index.md)?, **client**: [JobClient](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-client/index.md)?, **site**: [JobSite](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-site/index.md)?, **territory**: [JobTerritory](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-territory/index.md)?, **skills**: Array<[Skill](../../../com.hydra_billing.camunda.api.planado_v2.common_types/-skill/index.md)>, **contacts**: Array<[Contact](../../../com.hydra_billing.camunda.api.planado_v2.common_types/-contact/index.md)>, **custom_fields**: Array<[JobCustomField](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-custom-field/index.md)>, **report_fields**: Array<[JobCustomField](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-custom-field/index.md)>, **possible_resolutions**: Array<[JobResolution](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-resolution/index.md)>, **resolution**: [JobResolution](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-resolution/index.md)?, **created_at**: String, **updated_at**: String)

## Properties

| Name | Summary |
|---|---|
| [assignee](assignee.md) | [jvm]<br>val [assignee](assignee.md): [JobAssignee](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-assignee/index.md)? = null |
| [client](client.md) | [jvm]<br>val [client](client.md): [JobClient](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-client/index.md)? = null |
| [contacts](contacts.md) | [jvm]<br>val [contacts](contacts.md): Array<[Contact](../../../com.hydra_billing.camunda.api.planado_v2.common_types/-contact/index.md)> |
| [created_at](created_at.md) | [jvm]<br>val [created_at](created_at.md): String |
| [custom_fields](custom_fields.md) | [jvm]<br>val [custom_fields](custom_fields.md): Array<[JobCustomField](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-custom-field/index.md)> |
| [description](description.md) | [jvm]<br>val [description](description.md): String? = null |
| [external_id](external_id.md) | [jvm]<br>val [external_id](external_id.md): String? = null |
| [external_order_id](external_order_id.md) | [jvm]<br>val [external_order_id](external_order_id.md): String? = null |
| [possible_resolutions](possible_resolutions.md) | [jvm]<br>val [possible_resolutions](possible_resolutions.md): Array<[JobResolution](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-resolution/index.md)> |
| [report_fields](report_fields.md) | [jvm]<br>val [report_fields](report_fields.md): Array<[JobCustomField](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-custom-field/index.md)> |
| [resolution](resolution.md) | [jvm]<br>val [resolution](resolution.md): [JobResolution](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-resolution/index.md)? = null |
| [scheduled_at](scheduled_at.md) | [jvm]<br>val [scheduled_at](scheduled_at.md): String? = null |
| [scheduled_duration](scheduled_duration.md) | [jvm]<br>val [scheduled_duration](scheduled_duration.md): [JobDuration](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-duration/index.md)? = null |
| [serial_no](serial_no.md) | [jvm]<br>val [serial_no](serial_no.md): Long |
| [site](site.md) | [jvm]<br>val [site](site.md): [JobSite](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-site/index.md)? = null |
| [skills](skills.md) | [jvm]<br>val [skills](skills.md): Array<[Skill](../../../com.hydra_billing.camunda.api.planado_v2.common_types/-skill/index.md)> |
| [status](status.md) | [jvm]<br>val [status](status.md): String |
| [template](template.md) | [jvm]<br>val [template](template.md): [JobTemplate](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-template/index.md)? = null |
| [territory](territory.md) | [jvm]<br>val [territory](territory.md): [JobTerritory](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-territory/index.md)? = null |
| [type](type.md) | [jvm]<br>val [type](type.md): [JobType](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-type/index.md)? = null |
| [updated_at](updated_at.md) | [jvm]<br>val [updated_at](updated_at.md): String |
| [uuid](uuid.md) | [jvm]<br>val [uuid](uuid.md): String? = null |
