package com.hydra_billing.camunda.api.hydra.common_types

import com.google.gson.annotations.SerializedName

enum class SubjectType(val value: Long) {
    @SerializedName("18001") Person(18001),
    @SerializedName("1001") Company(1001),
    @SerializedName("2001") Customer(2001),
    @SerializedName("3001") DatabaseUser(3001),
    @SerializedName("4001") Employee(4001),
    @SerializedName("5001") Department(5001),
    @SerializedName("11001") PayCard(11001),
    @SerializedName("14001") Provider(14001),
    @SerializedName("16001") Bank(16001),
    @SerializedName("17001") Group(17001),
    @SerializedName("19001") Role(19001),
    @SerializedName("20001") Reseller(20001)
}
