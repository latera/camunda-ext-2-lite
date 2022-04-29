//[camunda-7.14-ext-2](../../index.md)/[com.hydra_billing.camunda.api.planado_v2.common_types.job](index.md)

# Package com.hydra_billing.camunda.api.planado_v2.common_types.job

## Types

| Name | Summary |
|---|---|
| [JobAssignee](-job-assignee/index.md) | [jvm]<br>data class [JobAssignee](-job-assignee/index.md)(**team**: [JobTeam](-job-team/index.md)?, **worker**: [JobWorker](-job-worker/index.md)?) |
| [JobClient](-job-client/index.md) | [jvm]<br>data class [JobClient](-job-client/index.md)(**uuid**: String, **external_id**: String?) |
| [JobCustomField](-job-custom-field/index.md) | [jvm]<br>data class [JobCustomField](-job-custom-field/index.md)(**uuid**: String, **name**: String?, **field_type**: String?, **data_type**: String?, **required**: Boolean?, **value**: Any?, **dictionary**: [DictionaryType](../com.hydra_billing.camunda.api.planado_v2.common_types/-dictionary-type/index.md)?, **filled_at**: String?) |
| [JobDuration](-job-duration/index.md) | [jvm]<br>data class [JobDuration](-job-duration/index.md)(**minutes**: Long) |
| [JobResolution](-job-resolution/index.md) | [jvm]<br>data class [JobResolution](-job-resolution/index.md)(**uuid**: String, **name**: String, **successful**: Boolean, **comment**: String?) |
| [JobSite](-job-site/index.md) | [jvm]<br>data class [JobSite](-job-site/index.md)(**uuid**: String, **external_id**: String?) |
| [JobTeam](-job-team/index.md) | [jvm]<br>data class [JobTeam](-job-team/index.md)(**uuid**: String, **team**: String?) |
| [JobTemplate](-job-template/index.md) | [jvm]<br>data class [JobTemplate](-job-template/index.md)(**uuid**: String, **name**: String?) |
| [JobTerritory](-job-territory/index.md) | [jvm]<br>data class [JobTerritory](-job-territory/index.md)(**uuid**: String, **name**: String) |
| [JobType](-job-type/index.md) | [jvm]<br>data class [JobType](-job-type/index.md)(**uuid**: String, **code**: String?) |
| [JobWorker](-job-worker/index.md) | [jvm]<br>data class [JobWorker](-job-worker/index.md)(**uuid**: String, **email**: String?) |
