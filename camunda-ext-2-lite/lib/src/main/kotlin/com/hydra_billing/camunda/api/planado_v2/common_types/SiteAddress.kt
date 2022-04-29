package com.hydra_billing.camunda.api.planado_v2.common_types

data class SiteAddress(
    val formatted: String? = null,
    val apartment: String? = null,
    val floor: String? = null,
    val entrance_no: String? = null,
    val description: String? = null,
    val geolocation: Geolocation? = null
)
