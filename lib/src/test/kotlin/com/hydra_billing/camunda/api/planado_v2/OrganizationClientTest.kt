import com.hydra_billing.camunda.api.planado_v2.OrganizationClient
import com.hydra_billing.camunda.api.planado_v2.common_types.Contact
import com.hydra_billing.camunda.api.planado_v2.common_types.Geolocation
import com.hydra_billing.camunda.api.planado_v2.common_types.SiteAddress
import com.hydra_billing.camunda.http_clients.mock_clients.planado_v2.OrganizationClientMockClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class OrganizationClientTest {
    @Test
    @DisplayName("Planado v2 organization client create test")
    fun create() {
        val httpClient = OrganizationClientMockClient.getClient()
        val api = OrganizationClient(httpClient)
        val createParams = OrganizationClient.CreateParams(organization_name = "Latera")

        val result = api.create(createParams)

        assertThat(result.client_uuid).isEqualTo("137ecf60-06cd-6930-bd93-46513db41965")
    }

    @Test
    @DisplayName("Planado v2 organization client get test")
    fun get() {
        val httpClient = OrganizationClientMockClient.getClient()
        val api = OrganizationClient(httpClient)
        val clientUuid = "50c773b3-a4f8-5619-be47-cb6a0edb22cc"
        val result = api.get(clientUuid)

        assertThat(result.uuid).isEqualTo("50c773b3-a4f8-5619-be47-cb6a0edb22cc")
        assertThat(result.external_id).isEqualTo("423430387320568-acme")
        assertThat(result.name).isEqualTo("ACME Corporation")
        assertThat(result.organization).isEqualTo(true)
        assertThat(result.organization_name).isEqualTo("ACME Corporation")
        assertThat(result.site_address).isEqualTo(
            SiteAddress(
                formatted = "Passeig de Gràcia, 92, 08008 Barcelona, Spain",
                entrance_no = "1",
                apartment = null,
                floor = "1",
                description = "Entrance via Carrer de Procença",
                geolocation = Geolocation(longitude = 37.6785237278356, latitude = 55.7862807707096)
            )
        )
        assertThat(result.contacts).isEqualTo(
            arrayOf<Contact>(Contact(name = "Pedro", value = "(834) 362-5246", type = "phone"))
        )
    }

    @Test
    @DisplayName("Planado v2 organization client update test")
    fun update() {
        val httpClient = OrganizationClientMockClient.getClient()
        val api = OrganizationClient(httpClient)
        val clientUuid = "50c773b3-a4f8-5619-be47-cb6a0edb22cc"
        val updateParams =
            OrganizationClient.UpdateParams(
                organization_name = "Latera11",
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

        assertThat(result.client_uuid).isEqualTo("50c773b3-a4f8-5619-be47-cb6a0edb22cc")
    }
}
