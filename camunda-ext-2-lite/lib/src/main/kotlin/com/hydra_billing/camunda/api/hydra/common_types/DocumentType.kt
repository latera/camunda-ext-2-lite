package com.hydra_billing.camunda.api.hydra.common_types

import com.google.gson.annotations.SerializedName

enum class DocumentType(val value: Long) {
    @SerializedName("1002") CustomerContract(1002),
    @SerializedName("2002") Addendum(2002),
    @SerializedName("3002") ChargeLog(3002),
    @SerializedName("4002") CashWarrant(4002),
    @SerializedName("5002") PaymentOrder(5002),
    @SerializedName("6002") LegacyInvoice(6002),
    @SerializedName("7002") PriceOrder(7002),
    @SerializedName("9002") BaseContract(9002),
    @SerializedName("11002") RecordOfBank(11002),
    @SerializedName("12002") TimeIntervals(12002),
    @SerializedName("13002") AddAgreement(13002),
    @SerializedName("14002") CardsIssue(14002),
    @SerializedName("15002") Overdraft(15002),
    @SerializedName("16002") TrafficClasses(16002),
    @SerializedName("20002") Request(20002),
    @SerializedName("21002") PeriodClose(21002),
    @SerializedName("22002") PeriodOpen(22002),
    @SerializedName("23002") CurrExchRates(23002),
    @SerializedName("24002") DataProcRequest(24002),
    @SerializedName("25002") ReconciliationReport(25002),
    @SerializedName("26002") SubscrChangePlan(26002),
    @SerializedName("27002") DiscountSpec(27002),
    @SerializedName("28002") DiscountCertificate(28002),
    @SerializedName("29002") PaymentRequest(29002),
    @SerializedName("30002") ProformaInvoice(30002),
    @SerializedName("31002") Invoice(31002)
}
