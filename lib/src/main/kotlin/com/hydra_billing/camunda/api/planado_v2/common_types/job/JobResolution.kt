package com.hydra_billing.camunda.api.planado_v2.common_types.job

data class JobResolution(
    val uuid: String,
    val name: String,
    val successful: Boolean,
    val comment: String? = null
)
