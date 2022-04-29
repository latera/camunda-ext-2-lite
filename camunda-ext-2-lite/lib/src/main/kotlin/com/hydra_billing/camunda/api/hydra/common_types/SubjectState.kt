package com.hydra_billing.camunda.api.hydra.common_types

import com.google.gson.annotations.SerializedName

enum class SubjectState(val value: Long) {
    @SerializedName("1011") Off(1011),
    @SerializedName("2011") On(2011),
    @SerializedName("3011") Locked(3011),
    @SerializedName("4011") Disabled(4011),
    @SerializedName("5011") ManuallySuspended(5011),
    @SerializedName("6011") PaymentsLocked(6011),
    @SerializedName("7011") CLIssuingSuspended(7011)
}
