package com.hydra_billing.camunda.api.hydra.common_types

import com.google.gson.annotations.SerializedName

enum class Language(val value: Long) {
    @SerializedName("1131") Russian(1131),
    @SerializedName("2131") English(2131),
    @SerializedName("3131") Ukrainian(3131),
    @SerializedName("4131") Kazakh(4131),
    @SerializedName("5131") Kirghiz(5131),
    @SerializedName("6131") Azerbaijani(6131),
    @SerializedName("7131") Spanish(7131),
    @SerializedName("8131") French(8131)
}
