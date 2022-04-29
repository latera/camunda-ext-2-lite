package com.hydra_billing.camunda.api.hydra.common_types

import com.google.gson.annotations.SerializedName

enum class DocumentWorkflow(val value: Long) {
    @SerializedName("10021") SubscriberContract(10021),
    @SerializedName("20021") ContractApp(20021),
    @SerializedName("30021") ChargeLog(30021),
    @SerializedName("40021") CashWarrant(40021),
    @SerializedName("50021") PaymentOrder(50021),
    @SerializedName("60021") Invoice(60021),
    @SerializedName("60022") ProformaInvoice(60022),
    @SerializedName("60023") PrepaymentInvoice(60023),
    @SerializedName("70021") PriceOrder(70021),
    @SerializedName("90021") BaseContract(90021),
    @SerializedName("110021") RecordOfBank(110021),
    @SerializedName("120021") TimeIntervals(120021),
    @SerializedName("130021") AddAgreement(130021),
    @SerializedName("140021") CardIssue(140021),
    @SerializedName("150021") Overdraft(150021),
    @SerializedName("160021") TrafficClassesIP(160021),
    @SerializedName("160022") TrafficClassesVoice(160022),
    @SerializedName("200021") Request(200021),
    @SerializedName("210021") PeriodClose(210021),
    @SerializedName("220021") PeriodOpen(220021),
    @SerializedName("230021") CurrExchRate(230021),
    @SerializedName("240021") DataProcRequest(240021),
    @SerializedName("250021") ReconciliationReport(250021),
    @SerializedName("260021") SubscrChangePlan(260021),
    @SerializedName("270021") DiscountSpecification(270021),
    @SerializedName("280021") DiscountCertificate(280021),
    @SerializedName("290021") PaymentRequest(290021)
}
