package com.hydra_billing.camunda.api.hydra.common_types

import com.google.gson.annotations.SerializedName

enum class DocumentState(val value: Long) {
    @SerializedName("1003") Approval(1003),
    @SerializedName("2003") Request(2003),
    @SerializedName("3003") Draft(3003),
    @SerializedName("4003") Actual(4003),
    @SerializedName("5003") Canceled(5003),
    @SerializedName("6003") Executed(6003),
    @SerializedName("7003") Rejected(7003),
    @SerializedName("8003") Enforcement(8003),
    @SerializedName("9003") Closed(9003),
    @SerializedName("10003") Prepared(10003),
    @SerializedName("11003") Processing(11003),
    @SerializedName("12003") Dissolved(12003),
    @SerializedName("13003") Authorized(13003),
    @SerializedName("14003") Suspended(14003)
}
