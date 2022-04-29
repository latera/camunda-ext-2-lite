package com.hydra_billing.camunda.api.hydra.common_types

import com.google.gson.annotations.SerializedName

enum class ObjectState(val value: Long) {
    @SerializedName("1040") Active(1040),
    @SerializedName("2040") NotActive(2040),
    @SerializedName("3040") RegisterOff(3040)
}
