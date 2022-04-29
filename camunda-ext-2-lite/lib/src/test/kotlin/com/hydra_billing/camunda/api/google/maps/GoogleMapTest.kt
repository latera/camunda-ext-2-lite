import com.hydra_billing.camunda.api.google.maps.GoogleMap
import com.hydra_billing.camunda.http_clients.mock_clients.google.maps.GoogleMapMockClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class GoogleMapTest {
    data class OrderData(val employeeFirstName: String?)

    @Test
    @DisplayName("Google map geocode success")
    fun show() {
        val httpClient = GoogleMapMockClient.getClient()
        val orderApi = GoogleMap(httpClient)
        val result = orderApi.geocode("Winnetka")
        assertThat(result.status).isEqualTo("OK")
        assertThat(result.results[0].formatted_address).isEqualTo("Winnetka, Los Angeles, CA, USA")
    }
}
