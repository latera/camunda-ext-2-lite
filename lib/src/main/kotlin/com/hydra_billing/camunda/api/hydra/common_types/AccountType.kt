package com.hydra_billing.camunda.api.hydra.common_types

import com.google.gson.annotations.SerializedName

enum class AccountType(val value: Long) {
    @SerializedName("1042") Settlement(1042),
    @SerializedName("2042") Personal(2042),
    @SerializedName("3042") Cash(3042),
    @SerializedName("4042") EPurse(4042),
    @SerializedName("5042") PaySys(5042),
    @SerializedName("6042") Reseller(6042)
}
