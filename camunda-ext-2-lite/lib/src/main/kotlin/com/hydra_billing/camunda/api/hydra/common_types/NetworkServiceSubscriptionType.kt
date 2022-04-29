package com.hydra_billing.camunda.api.hydra.common_types

import com.google.gson.annotations.SerializedName

enum class NetworkServiceSubscriptionType(val value: Long) {
    @SerializedName("1066") AppAccess(1066),
    @SerializedName("2066") Manage(2066),
    @SerializedName("3066") ServiceUse(3066)
}
