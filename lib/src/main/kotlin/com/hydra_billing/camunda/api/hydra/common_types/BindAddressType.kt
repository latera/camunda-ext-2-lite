package com.hydra_billing.camunda.api.hydra.common_types

import com.google.gson.annotations.SerializedName

enum class BindAddressType(val value: Long) {
    @SerializedName("1016") Actual(1016),
    @SerializedName("3016") HostPort(3016),
    @SerializedName("4016") Jur(4016),
    @SerializedName("5016") Fixed(5016),
    @SerializedName("6016") Serv(6016),
    @SerializedName("7016") FixLocation(7016),
    @SerializedName("8016") Work(8016),
    @SerializedName("9016") Mobile(9016),
    @SerializedName("10016") Home(10016),
    @SerializedName("11016") Post(11016),
    @SerializedName("12016") Notice(12016),
    @SerializedName("13016") Resource(13016),
    @SerializedName("14016") Redirect(14016)
}
