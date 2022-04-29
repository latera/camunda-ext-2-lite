import com.hydra_billing.camunda.api.hydra.common_types.AddressState
import com.hydra_billing.camunda.api.hydra.common_types.AddressType
import com.hydra_billing.camunda.api.hydra.common_types.BindAddressType
import com.hydra_billing.camunda.api.hydra.rest.v2.subjects.persons.PersonAddress
import com.hydra_billing.camunda.http_clients.mock_clients.hydra.rest.v2.PersonAddressMockClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PersonAddressTest {
    @Test
    @DisplayName("Hydra rest api create person address")
    fun create() {
        val httpClient = PersonAddressMockClient.getClient()
        val api = PersonAddress(httpClient)
        val createParams =
            PersonAddress.CreateParams(
                n_addr_type_id = AddressType.FactPlace,
                n_subj_addr_type_id = BindAddressType.Actual,
                vc_address = "Россия, г. Москва, г. Зеленоград",
                n_addr_state_id = AddressState.On
            )

        val result = api.create(createParams, 78419101)

        assertThat(result.n_address_id).isEqualTo(99947401)
        assertThat(result.n_addr_state_id).isEqualTo(AddressState.On)
    }
}
