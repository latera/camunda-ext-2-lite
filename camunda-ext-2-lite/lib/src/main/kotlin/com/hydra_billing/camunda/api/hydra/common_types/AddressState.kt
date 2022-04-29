package com.hydra_billing.camunda.api.hydra.common_types

import com.google.gson.annotations.SerializedName

enum class AddressState(val value: Long) {
    @SerializedName("1029") On(1029),
    @SerializedName("2029") Off(2029),
}
