package com.hydra_billing.camunda.api.odoo.common_types

import com.google.gson.annotations.SerializedName

enum class EntityTypes(val value: String) {
    @SerializedName("res.partner") Customer("res.partner"),
    @SerializedName("crm.lead") Lead("crm.lead"),
    @SerializedName("res.country") Country("res.country")
}
