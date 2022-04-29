package com.hydra_billing.camunda.api.hydra.common_types

import com.google.gson.annotations.SerializedName

enum class CatalogItemGroup(val value: Long) {
    @SerializedName("1039") Group(1039),
    @SerializedName("2039") Product(2039),
    @SerializedName("3039") SpecItem(3039),
    @SerializedName("4039") Specification(4039)
}
