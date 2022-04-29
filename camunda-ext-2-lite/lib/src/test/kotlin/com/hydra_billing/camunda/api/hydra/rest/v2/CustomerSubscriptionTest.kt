import com.hydra_billing.camunda.api.hydra.common_types.ChargeLogCreatingState
import com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers.CustomerSubscription
import com.hydra_billing.camunda.http_clients.mock_clients.hydra.rest.v2.CustomerSubscriptionMockClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CustomerSubscriptionTest {
    @Test
    @DisplayName("Hydra rest api create customer subscription")
    fun create() {
        val httpClient = CustomerSubscriptionMockClient.getClient()
        val api = CustomerSubscription(httpClient)
        val createParams =
            CustomerSubscription.CreateParams(
                n_service_id = 50188901,
                n_par_subscription_id = null,
                n_account_id = 78052501,
                n_object_id = 78058401,
                n_contract_id = 78053001,
                d_begin = "2021-10-15T09:13:52+03:00",
                n_quant = null,
                d_end = null
            )

        val result = api.create(params = createParams, customerId = 78052201)

        assertThat(result.n_subscription_id).isEqualTo(100001101)
        assertThat(result.n_service_id).isEqualTo(50188901)
        assertThat(result.n_customer_id).isEqualTo(78052201)
        assertThat(result.n_account_id).isEqualTo(78052501)
        assertThat(result.n_object_id).isEqualTo(78058401)
        assertThat(result.n_quant).isEqualTo(null)
        assertThat(result.n_unit_id).isEqualTo(2009)
        assertThat(result.d_begin).isEqualTo("2021-10-15T09:13:52+03:00")
        assertThat(result.d_end).isEqualTo(null)
        assertThat(result.c_fl_closed).isEqualTo("N")
        assertThat(result.n_line_no).isEqualTo(2000000)
        assertThat(result.n_par_subscription_id).isEqualTo(null)
        assertThat(result.n_prev_subscription_id).isEqualTo(null)
        assertThat(result.n_cl_creating_state_id).isEqualTo(ChargeLogCreatingState.Allowed)
        assertThat(result.n_contract_id).isEqualTo(78053001)
    }

    @Test
    @DisplayName("Hydra rest api get customer subscription")
    fun get() {
        val httpClient = CustomerSubscriptionMockClient.getClient()
        val api = CustomerSubscription(httpClient)
        val result = api.get(customerId = 302, subscriptionId = 40240701)

        assertThat(result.n_subscription_id).isEqualTo(40240701)
        assertThat(result.n_service_id).isEqualTo(40219001)
        assertThat(result.n_customer_id).isEqualTo(302)
        assertThat(result.n_account_id).isEqualTo(40233401)
        assertThat(result.n_object_id).isEqualTo(40236101)
        assertThat(result.n_quant).isEqualTo(null)
        assertThat(result.n_unit_id).isEqualTo(2009)
        assertThat(result.d_begin).isEqualTo("2011-01-19T23:12:48+03:00")
        assertThat(result.d_end).isEqualTo(null)
        assertThat(result.c_fl_closed).isEqualTo("N")
        assertThat(result.n_line_no).isEqualTo(1000000)
        assertThat(result.n_par_subscription_id).isEqualTo(null)
        assertThat(result.n_prev_subscription_id).isEqualTo(null)
        assertThat(result.n_cl_creating_state_id).isEqualTo(ChargeLogCreatingState.Allowed)
        assertThat(result.n_contract_id).isEqualTo(40233901)
    }

    @Test
    @DisplayName("Hydra rest api show customer subscription list")
    fun list() {
        val httpClient = CustomerSubscriptionMockClient.getClient()
        val api = CustomerSubscription(httpClient)

        val result = api.list(customerId = 302)

        assertThat(result.size).isEqualTo(2)

        assertThat(result[0].n_subscription_id).isEqualTo(40240701)
        assertThat(result[0].n_service_id).isEqualTo(40219001)
        assertThat(result[0].n_customer_id).isEqualTo(302)
        assertThat(result[0].n_account_id).isEqualTo(40233401)
        assertThat(result[0].n_object_id).isEqualTo(40236101)
        assertThat(result[0].n_quant).isEqualTo(null)
        assertThat(result[0].n_unit_id).isEqualTo(2009)
        assertThat(result[0].d_begin).isEqualTo("2011-01-19T23:12:48+03:00")
        assertThat(result[0].d_end).isEqualTo(null)
        assertThat(result[0].c_fl_closed).isEqualTo("N")
        assertThat(result[0].n_line_no).isEqualTo(1000000)
        assertThat(result[0].n_par_subscription_id).isEqualTo(null)
        assertThat(result[0].n_prev_subscription_id).isEqualTo(null)
        assertThat(result[0].n_cl_creating_state_id).isEqualTo(ChargeLogCreatingState.Allowed)
        assertThat(result[0].n_contract_id).isEqualTo(40233901)

        assertThat(result[1].n_subscription_id).isEqualTo(40240801)
        assertThat(result[1].n_service_id).isEqualTo(40217401)
        assertThat(result[1].n_customer_id).isEqualTo(302)
        assertThat(result[1].n_account_id).isEqualTo(40233401)
        assertThat(result[1].n_object_id).isEqualTo(40236101)
        assertThat(result[1].n_quant).isEqualTo(null)
        assertThat(result[1].n_unit_id).isEqualTo(2009)
        assertThat(result[1].d_begin).isEqualTo("2011-01-19T23:12:48+03:00")
        assertThat(result[1].d_end).isEqualTo(null)
        assertThat(result[1].c_fl_closed).isEqualTo("N")
        assertThat(result[1].n_line_no).isEqualTo(1000001)
        assertThat(result[1].n_par_subscription_id).isEqualTo(40240701)
        assertThat(result[1].n_prev_subscription_id).isEqualTo(null)
        assertThat(result[1].n_cl_creating_state_id).isEqualTo(ChargeLogCreatingState.Allowed)
        assertThat(result[1].n_contract_id).isEqualTo(40233901)
    }
}
