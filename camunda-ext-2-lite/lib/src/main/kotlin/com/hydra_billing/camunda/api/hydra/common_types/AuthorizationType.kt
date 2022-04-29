package com.hydra_billing.camunda.api.hydra.common_types

import com.google.gson.annotations.SerializedName

enum class AuthorizationType(val value: Long) {
    @SerializedName("1019") LoginPass(1019),
    @SerializedName("2019") SNMP1(2019),
    @SerializedName("3019") SNMP2(3019),
    @SerializedName("4019") HTTP(4019),
    @SerializedName("5019") RSH(5019),
    @SerializedName("6019") SSH(6019),
    @SerializedName("7019") Telnet(7019),
    @SerializedName("8019") Local(8019),
    @SerializedName("9019") RadiusSecret(9019),
    @SerializedName("10019") DrWeb(10019),
    @SerializedName("11019") ESET(11019)
}
