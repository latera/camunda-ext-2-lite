import com.hydra_billing.camunda.api.planado_v2.IndividualClient
import com.hydra_billing.camunda.api.planado_v2.common_types.Contact
import com.hydra_billing.camunda.api.planado_v2.common_types.Geolocation
import com.hydra_billing.camunda.api.planado_v2.common_types.SiteAddress
import com.hydra_billing.camunda.http_clients.mock_clients.planado_v2.IndividualClientMockClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class IndividualClientTest {
    @Test
    @DisplayName("Planado v2 individual client create test")
    fun create() {
        val httpClient = IndividualClientMockClient.getClient()
        val api = IndividualClient(httpClient)
        val createParams =
            IndividualClient.CreateParams(
                first_name = "Test",
                last_name = "Testerov",
                middle_name = "Testerovich",
            )
        val result = api.create(createParams)

        assertThat(result.client_uuid).isEqualTo("137ecf60-06cd-6930-bd93-46513db41965")
    }

    @Test
    @DisplayName("Planado v2 individual client get test")
    fun get() {
        val httpClient = IndividualClientMockClient.getClient()
        val api = IndividualClient(httpClient)
        val clientUuid = "b2584e3c-25dd-4773-ab8b-0a018fd58d2b"
        val result = api.get(clientUuid)

        assertThat(result.uuid).isEqualTo("b2584e3c-25dd-4773-ab8b-0a018fd58d2b")
        assertThat(result.external_id).isEqualTo("22451458596510-john-doe-the-second")
        assertThat(result.name).isEqualTo("John Doe the Second")
        assertThat(result.organization).isEqualTo(false)
        assertThat(result.first_name).isEqualTo("John")
        assertThat(result.last_name).isEqualTo("Doe")
        assertThat(result.middle_name).isEqualTo("the second")
        assertThat(result.site_address).isEqualTo(
            SiteAddress(
                formatted = "VFWH+25 Rome, Metropolitan City of Rome, Italy",
                entrance_no = "3",
                apartment = "11",
                floor = "2",
                description = "Knock hard",
                geolocation = Geolocation(longitude = 12.4772501, latitude = 41.8950619)
            )
        )
        assertThat(result.contacts).isEqualTo(
            arrayOf<Contact>(Contact(name = "John", value = "(923) 820-5063", type = "phone"))
        )
        assertThat(result.created_at).isEqualTo("2016-05-29T17:31:01.419601Z")
        assertThat(result.updated_at).isEqualTo("2016-06-07T10:57:19.529209Z")
    }

    @Test
    @DisplayName("Planado v2 individual client update test")
    fun update() {
        val httpClient = IndividualClientMockClient.getClient()
        val api = IndividualClient(httpClient)
        val clientUuid = "137ed01f-39ef-6960-bd93-46513db41965"
        val updateParams =
            IndividualClient.UpdateParams(
                first_name = "Oleg",
                site_address =
                SiteAddress(
                    formatted = "Passeig de Gràcia, 92, 08008 Barcelona, Spain",
                    entrance_no = "1",
                    apartment = "123",
                    floor = "1",
                    description = "Entrance via Carrer de Procença",
                    geolocation =
                    Geolocation(longitude = 37.6785237278356, latitude = 55.7862807707096)
                ),
                contacts =
                arrayOf<Contact>(
                    Contact(name = "Pedro", value = "(834) 362-5246", type = "phone")
                )
            )

        val result = api.update(id = clientUuid, params = updateParams)

        assertThat(result.client_uuid).isEqualTo("137ed01f-39ef-6960-bd93-46513db41965")
    }
}
