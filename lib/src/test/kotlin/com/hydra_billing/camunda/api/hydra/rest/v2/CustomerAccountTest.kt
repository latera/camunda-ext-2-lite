import com.hydra_billing.camunda.api.hydra.common_types.AccountType
import com.hydra_billing.camunda.api.hydra.common_types.Currency
import com.hydra_billing.camunda.api.hydra.common_types.SubjectState
import com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers.CustomerAccount
import com.hydra_billing.camunda.http_clients.mock_clients.hydra.rest.v2.PersonalAccountMockClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class CustomerAccountTest {
    @Test
    @DisplayName("Hydra rest api get personal account by id")
    fun get() {
        val httpClient = PersonalAccountMockClient.getClient()
        val api = CustomerAccount(httpClient)
        val result = api.getAccountById(78299501)

        assertThat(result.n_subject_id).isEqualTo(78299201)
        assertThat(result.vc_subj_code).isEqualTo("api_account_user")
        assertThat(result.vc_subj_name).isEqualTo("Маркони Г.")
        assertThat(result.n_subj_state_id).isEqualTo(SubjectState.On)
        assertThat(result.n_firm_id).isEqualTo(100)
        assertThat(result.n_account_id).isEqualTo(78299501)
        assertThat(result.n_account_type_id).isEqualTo(AccountType.Personal)
        assertThat(result.vc_account_type_name).isEqualTo("Лицевой счет")
        assertThat(result.n_bank_id).isEqualTo(100)
        assertThat(result.vc_bank_name).isEqualTo("Offline Telecom")
        assertThat(result.n_currency_id).isEqualTo(Currency.RUB)
        assertThat(result.vc_currency_code).isEqualTo("RUB")
        assertThat(result.vc_name).isEqualTo("Лицевой счет №1099")
        assertThat(result.vc_code).isEqualTo("1099")
        assertThat(result.vc_account).isEqualTo("1099")
        assertThat(result.d_open).isEqualTo(null)
        assertThat(result.d_close).isEqualTo(null)
        assertThat(result.n_max_overdraft == null).isEqualTo(true)
        assertThat(result.vc_bank).isEqualTo(null)
        assertThat(result.vc_rem).isEqualTo(null)
        assertThat(result.vc_code_ex).isEqualTo("1099 (Лицевой счет №1099)")
    }

    @Test
    @DisplayName("Hydra rest api create customer account")
    fun create() {
        val httpClient = PersonalAccountMockClient.getClient()
        val api = CustomerAccount(httpClient)
        val customerId: Long = 88961901
        val customerAccountParams = CustomerAccount.CreateParams(
            n_currency_id = Currency.RUB,
            vc_code = "New test account",
            vc_name = "New test account №test_account",
            vc_account = "test_account"
        )
        val result = api.create(params = customerAccountParams, customerId = customerId)

        assertThat(result.n_account_id).isEqualTo(325390501)
        assertThat(result.n_currency_id).isEqualTo(Currency.RUB)
        assertThat(result.vc_currency_code).isEqualTo("RUB")
        assertThat(result.vc_name).isEqualTo("New test account №test_account")
        assertThat(result.vc_code).isEqualTo("New test account")
        assertThat(result.vc_account).isEqualTo("test_account")
        assertThat(result.vc_rem).isEqualTo(null)
        assertThat(result.n_sum_bal).isEqualTo(BigDecimal(0))
        assertThat(result.n_sum_free).isEqualTo(BigDecimal(0))
        assertThat(result.n_max_credit_limit).isEqualTo(null)
        assertThat(result.n_sum_reserved_total).isEqualTo(BigDecimal(0))
        assertThat(result.n_sum_reserved).isEqualTo(BigDecimal(0))
        assertThat(result.has_actual_atu).isEqualTo(false)
        assertThat(result.permanent_credit_limit).isEqualTo(mapOf("n_sum" to null))
        assertThat(result.temporary_credit_limit).isEqualTo(CustomerAccount.Credit(n_sum = null, d_end = null))
        assertThat(result.scheduled_services_credit_limit).isEqualTo(CustomerAccount.Credit(n_sum = null, d_end = null))
        assertThat(result.unscheduled_services_credit_limit).isEqualTo(CustomerAccount.Credit(n_sum = null, d_end = null))
        assertThat(result.actual_charge_logs_amount).isEqualTo(BigDecimal(0))
    }

    @Test
    @DisplayName("Hydra resti api list customer account charges for certain period")
    fun listCustomerAccountCharges() {
        val httpClient = PersonalAccountMockClient.getClient()
        val api = CustomerAccount(httpClient)
        val accountId: Long = 90471001
        val beginDate: String = "2021-12-10T00:40:37+03:00"
        val endDate: String = "2022-10-08T00:40:37+03:00"
        val result: Array<CustomerAccount.Charge> = api.listCustomerAccountCharges(accountId = accountId, beginDate = beginDate, endDate = endDate)

        assertThat(result[0].n_doc_id).isEqualTo(163345201)
        assertThat(result[0].n_service_id).isEqualTo(90474401)
        assertThat(result[0].n_sum).isEqualTo(50)
        assertThat(result[0].d_begin).isEqualTo("2022-01-01T11:02:40+03:00")
        assertThat(result[0].d_end).isEqualTo("2022-02-01T10:59:59+03:00")
        assertThat(result[0].vc_rem).isEqualTo(null)
        assertThat(result[0].n_currency_id).isEqualTo(Currency.RUB)
        assertThat(result[0].vc_currency).isEqualTo("CURR_Ruble")
    }
}
