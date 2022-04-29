package com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers

import com.hydra_billing.camunda.Logger.*
import com.hydra_billing.camunda.api.hydra.common_types.AccountType
import com.hydra_billing.camunda.api.hydra.common_types.Currency
import com.hydra_billing.camunda.api.hydra.common_types.SubjectState
import io.ktor.client.HttpClient
import io.ktor.client.request.*
import kotlinx.coroutines.*
import java.math.BigDecimal

class CustomerAccount(val client: HttpClient) {
    companion object : Logged {
        val logger = getLogger()
    }
    data class CreateParams(
        val n_currency_id: Currency,
        val vc_code: String? = null,
        val vc_name: String? = null,
        val vc_account: String? = null,
        val vc_rem: String? = null,
        val n_max_credit_limit: BigDecimal? = null
    )

    data class Credit(val n_sum: BigDecimal?, val d_end: String?)

    data class CustomerAccount(
        val n_account_id: Long,
        val n_currency_id: Currency,
        val vc_currency_code: String,
        val vc_name: String,
        val vc_code: String,
        val vc_account: String,
        val vc_rem: String?,
        val n_sum_bal: BigDecimal,
        val n_sum_free: BigDecimal,
        val n_max_credit_limit: BigDecimal?,
        val n_sum_reserved_total: BigDecimal,
        val n_sum_reserved: BigDecimal,
        val has_actual_atu: Boolean,
        val permanent_credit_limit: Map<String, BigDecimal?>,
        val temporary_credit_limit: Credit,
        val scheduled_services_credit_limit: Credit,
        val unscheduled_services_credit_limit: Credit,
        val actual_charge_logs_amount: BigDecimal
    )

    data class PersonalAccount(
        val n_subject_id: Long,
        val vc_subj_code: String,
        val vc_subj_name: String,
        val n_subj_state_id: SubjectState,
        val n_firm_id: Long,
        val n_account_id: Long,
        val n_account_type_id: AccountType,
        val vc_account_type_name: String,
        val n_bank_id: Long,
        val vc_bank_name: String,
        val n_currency_id: Currency,
        val vc_currency_code: String,
        val vc_name: String,
        val vc_code: String,
        val vc_account: String,
        val d_open: String?,
        val d_close: String?,
        val n_max_overdraft: BigDecimal?,
        val vc_bank: String?,
        val vc_rem: String?,
        val vc_code_ex: String?
    )
    data class PersonalAccountResponse(val personal_account: PersonalAccount)

    data class Response(val account: CustomerAccount)

    data class Charge(
        val n_doc_id: Long,
        val n_service_id: Long,
        val n_sum: BigDecimal,
        val d_begin: String,
        val d_end: String,
        val vc_rem: String,
        val n_currency_id: Currency,
        val vc_currency: String
    )

    data class ChargesResponse(val charges: Array<Charge>)

    fun create(params: CreateParams, customerId: Long): CustomerAccount {
        val client = this.client

        logger.info("Create account for customer $customerId with $params")

        val response = runBlocking {
            client.post<Response> {
                url { encodedPath = "/rest/v2/subjects/customers/$customerId/accounts" }

                body = mapOf("account" to params)
            }
        }

        return response.account
    }

    fun getAccountById(id: Long): PersonalAccount {
        val client = this.client

        logger.info("Get account by id=$id")

        val response = runBlocking {
            client.get<PersonalAccountResponse> {
                url { encodedPath = "/rest/v2/personal_accounts/$id" }
            }
        }

        return response.personal_account
    }

    fun listCustomerAccountCharges(accountId: Long, beginDate: String, endDate: String): Array<Charge> {
        val client = this.client

        logger.info("Get account (id=$accountId) charges for period $beginDate - $endDate")

        val response = runBlocking {
            client.get<ChargesResponse> {
                url { encodedPath = "/rest/v2/subjects/accounts/$accountId/charges" }
                parameter("d_begin", beginDate)
                parameter("d_end", endDate)
            }
        }

        return response.charges
    }
}
