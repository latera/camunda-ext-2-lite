package com.hydra_billing.camunda.api.hydra.common_types

import com.google.gson.annotations.SerializedName

enum class CatalogItemType(val value: Long) {
    @SerializedName("-10") Unknown(-10),
    @SerializedName("0") All(0),
    @SerializedName("1") Value(1),
    @SerializedName("101") NetDevice(101),
    @SerializedName("201") NetDeviceSwitch(201),
    @SerializedName("11101") Servers(11101),
    @SerializedName("21401") ClientEquip(21401),
    @SerializedName("31601") PassiveEquip(31601),
    @SerializedName("31701") Cable(31701),
    @SerializedName("31801") Cable_Copper(31801),
    @SerializedName("32001") Cable_Optic(32001),
    @SerializedName("42201") Box(42201),
    @SerializedName("52501") Cross(52501),
    @SerializedName("2") Serv(2),
    @SerializedName("1702") TrafficServ(1702),
    @SerializedName("3") Spec(3),
    @SerializedName("103") Spec_DevicePort(103),
    @SerializedName("10103") Spec_OpticalFiber(10103),
    @SerializedName("12103") Spec_Units(12103),
    @SerializedName("14203") Spec_CrossPort(14203),
    @SerializedName("63203") Spec_Aggregator(63203),
    @SerializedName("65403") Spec_VirtualPort(65403),
    @SerializedName("4") Packs(4),
    @SerializedName("5") NetServ(5),
    @SerializedName("6") Realty(6),
    @SerializedName("7") Penalties(7),
    @SerializedName("8") Adjustments(8)
}
