package com.hydra_billing.camunda.api.hydra.common_types

import com.google.gson.annotations.SerializedName

enum class ChargeLogCreatingState(val value: Long) {
    @SerializedName("1212") Allowed(1212),
    @SerializedName("2212") Forbidden(2212)
}
