package com.hydra_billing.camunda.api.hydra.common_types

import com.google.gson.annotations.SerializedName

enum class AddressType(val value: Long) {
    @SerializedName("1006") FactPlace(1006),
    @SerializedName("2006") IPv4Subnet(2006),
    @SerializedName("3006") IPv4(3006),
    @SerializedName("4006") MAC(4006),
    @SerializedName("5006") VLAN(5006),
    @SerializedName("6006") EMail(6006),
    @SerializedName("7006") URL(7006),
    @SerializedName("8006") GlobalICQ(8006),
    @SerializedName("9006") Fax(9006),
    @SerializedName("10006") Jabber(10006),
    @SerializedName("11006") TelCode(11006),
    @SerializedName("12006") TelZone(12006),
    @SerializedName("13006") PhoneNumber(13006),
    @SerializedName("14006") SubnetGroup(14006),
    @SerializedName("15006") DNS_A_Rec(15006),
    @SerializedName("16006") DNS_CNAME_Rec(16006),
    @SerializedName("17006") Skype(17006),
    @SerializedName("18006") IPv6Subnet(18006),
    @SerializedName("19006") IPv6(19006)
}
