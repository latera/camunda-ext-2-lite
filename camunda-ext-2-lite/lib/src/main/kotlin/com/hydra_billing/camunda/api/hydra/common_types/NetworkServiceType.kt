package com.hydra_billing.camunda.api.hydra.common_types

import com.google.gson.annotations.SerializedName

enum class NetworkServiceType(val value: Long) {
    @SerializedName("105") Agent(105),
    @SerializedName("205") LdapGroup(205),
    @SerializedName("305") App(305),
    @SerializedName("405") System(405),
    @SerializedName("505") RadiusGroup(505),
    @SerializedName("1005") ArmIsp(1005),
    @SerializedName("1105") ArmPrivateOffice(1105),
    @SerializedName("1205") ArmMigration(1205),
    @SerializedName("1305") Hpd(1305),
    @SerializedName("1405") Hid(1405),
    @SerializedName("2205") Collector(2205),
    @SerializedName("2305") NetDevManager(2305),
    @SerializedName("2405") DataCollector(2405),
    @SerializedName("3305") Firewall(3305),
    @SerializedName("3605") Notify(3605),
    @SerializedName("4305") Vpn(4305),
    @SerializedName("4405") Dns(4405),
    @SerializedName("4505") Dhcp(4505),
    @SerializedName("4605") Email(4605),
    @SerializedName("4705") Jabber(4705),
    @SerializedName("4805") Web(4805),
}
