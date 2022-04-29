package com.hydra_billing.camunda.api.planado_v2.common_types.job

import com.hydra_billing.camunda.api.planado_v2.common_types.DictionaryType

data class JobCustomField(
    val uuid: String,
    val name: String? = null,
    val field_type: String? = null,
    val data_type: String? = null,
    val required: Boolean? = null,
    val value: Any? = null,
    val dictionary: DictionaryType? = null,
    val filled_at: String? = null
)
