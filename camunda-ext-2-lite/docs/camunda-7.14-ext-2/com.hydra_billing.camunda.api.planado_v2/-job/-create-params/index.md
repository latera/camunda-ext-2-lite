//[camunda-7.14-ext-2](../../../../index.md)/[com.hydra_billing.camunda.api.planado_v2](../../index.md)/[Job](../index.md)/[CreateParams](index.md)

# CreateParams

[jvm]\
data class [CreateParams](index.md)(**external_id**: String?, **external_order_id**: String?, **scheduled_at**: String?, **scheduled_duration**: [JobDuration](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-duration/index.md)?, **description**: String?, **assignee**: [JobAssignee](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-assignee/index.md)?, **job_type**: [JobType](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-type/index.md)?, **template**: [JobTemplate](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-template/index.md)?, **client**: [JobClient](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-client/index.md)?, **address**: [SiteAddress](../../../com.hydra_billing.camunda.api.planado_v2.common_types/-site-address/index.md)?, **site**: [JobSite](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-site/index.md)?, **territory**: [JobTerritory](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-territory/index.md)?, **skills**: Array<[Skill](../../../com.hydra_billing.camunda.api.planado_v2.common_types/-skill/index.md)>, **contacts**: Array<[Contact](../../../com.hydra_billing.camunda.api.planado_v2.common_types/-contact/index.md)>, **custom_fields**: Array<[JobCustomField](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-custom-field/index.md)>, **possible_resolutions**: Array<[JobResolution](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-resolution/index.md)>?)

## Properties

| Name | Summary |
|---|---|
| [address](address.md) | [jvm]<br>val [address](address.md): [SiteAddress](../../../com.hydra_billing.camunda.api.planado_v2.common_types/-site-address/index.md)? = null |
| [assignee](assignee.md) | [jvm]<br>val [assignee](assignee.md): [JobAssignee](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-assignee/index.md)? = null |
| [client](client.md) | [jvm]<br>val [client](client.md): [JobClient](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-client/index.md)? = null |
| [contacts](contacts.md) | [jvm]<br>val [contacts](contacts.md): Array<[Contact](../../../com.hydra_billing.camunda.api.planado_v2.common_types/-contact/index.md)> |
| [custom_fields](custom_fields.md) | [jvm]<br>val [custom_fields](custom_fields.md): Array<[JobCustomField](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-custom-field/index.md)> |
| [description](description.md) | [jvm]<br>val [description](description.md): String? = null |
| [external_id](external_id.md) | [jvm]<br>val [external_id](external_id.md): String? = null |
| [external_order_id](external_order_id.md) | [jvm]<br>val [external_order_id](external_order_id.md): String? = null |
| [job_type](job_type.md) | [jvm]<br>val [job_type](job_type.md): [JobType](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-type/index.md)? = null |
| [possible_resolutions](possible_resolutions.md) | [jvm]<br>val [possible_resolutions](possible_resolutions.md): Array<[JobResolution](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-resolution/index.md)>? = null |
| [scheduled_at](scheduled_at.md) | [jvm]<br>val [scheduled_at](scheduled_at.md): String? = null |
| [scheduled_duration](scheduled_duration.md) | [jvm]<br>val [scheduled_duration](scheduled_duration.md): [JobDuration](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-duration/index.md)? = null |
| [site](site.md) | [jvm]<br>val [site](site.md): [JobSite](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-site/index.md)? = null |
| [skills](skills.md) | [jvm]<br>val [skills](skills.md): Array<[Skill](../../../com.hydra_billing.camunda.api.planado_v2.common_types/-skill/index.md)> |
| [template](template.md) | [jvm]<br>val [template](template.md): [JobTemplate](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-template/index.md)? = null |
| [territory](territory.md) | [jvm]<br>val [territory](territory.md): [JobTerritory](../../../com.hydra_billing.camunda.api.planado_v2.common_types.job/-job-territory/index.md)? = null |
