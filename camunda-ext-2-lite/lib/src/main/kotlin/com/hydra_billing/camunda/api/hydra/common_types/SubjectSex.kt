package com.hydra_billing.camunda.api.hydra.common_types

import com.google.gson.annotations.SerializedName

enum class SubjectSex(val value: Long) {
    @SerializedName("1138") Male(1138),
    @SerializedName("2138") Female(2138)
}
