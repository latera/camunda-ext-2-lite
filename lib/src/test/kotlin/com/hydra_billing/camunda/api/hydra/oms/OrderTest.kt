import com.hydra_billing.camunda.api.hydra.oms.Order
import com.hydra_billing.camunda.http_clients.mock_clients.hydra.oms.OrderMockClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class OrderTest {
    data class OrderData(val employeeFirstName: String?)

    @Test
    @DisplayName("Hydra OMS order show")
    fun show() {
        val httpClient = OrderMockClient.getClient()
        val orderApi = Order(httpClient)
        val result = orderApi.show<OrderData>("ORD-1")
        assertThat(result.id).isEqualTo(4)
        assertThat(result.data.employeeFirstName).isEqualTo("James")
    }

    @Test
    @DisplayName("Hydra OMS order list")
    fun list() {
        val httpClient = OrderMockClient.getClient()
        val orderApi = Order(httpClient)
        val result = orderApi.list<OrderData>(page_size = 2, page = 2)
        assertThat(result[0].id).isEqualTo(1)
    }

    @Test
    @DisplayName("Hydra OMS order create")
    fun create() {
        val httpClient = OrderMockClient.getClient()
        val orderApi = Order(httpClient)
        val params =
            Order.OrderParams(
                code = null,
                order_type_code = "vacation_request",
                ext_code = "ext_code",
                bp_id = "bp_id",
                bp_state = "bp_state",
                state = "in_progress",
                done_at = "2016-05-16T13:52:48+03:00",
                archived = false,
                data = OrderData("James"),
                user_email = null
            )
        val result = orderApi.create<OrderData>(params)
        assertThat(result.id).isEqualTo(10)
    }

    @Test
    @DisplayName("Hydra OMS order update")
    fun update() {
        val httpClient = OrderMockClient.getClient()
        val orderApi = Order(httpClient)
        val params =
            Order.OrderParams(
                code = "ORD-2",
                order_type_code = "vacation_request",
                ext_code = "ext_code",
                bp_id = "bp_id",
                bp_state = "bp_state",
                state = "in_progress",
                done_at = "2016-05-16T13:52:48+03:00",
                archived = false,
                data = OrderData("James"),
                user_email = null
            )
        val result = orderApi.update<OrderData>(params)
        assertThat(result.id).isEqualTo(11)
    }
}
