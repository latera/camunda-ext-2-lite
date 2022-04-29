import com.hydra_billing.camunda.api.hydra.common_types.AddressState
import com.hydra_billing.camunda.api.hydra.common_types.AddressType
import com.hydra_billing.camunda.api.hydra.common_types.BindAddressType
import com.hydra_billing.camunda.api.hydra.rest.v2.subjects.SubjectAddresses
import com.hydra_billing.camunda.http_clients.mock_clients.hydra.rest.v2.SubjectAddressesMockClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class SubjectAddressesTest {
    @Test
    @DisplayName("Hydra rest api get subjects addresses list")
    fun list() {
        val httpClient = SubjectAddressesMockClient.getClient()
        val api = SubjectAddresses(httpClient)

        val result = api.list(arrayOf(99))

        assertThat(result.size).isEqualTo(1)
        assertThat(result[0].c_fl_main).isEqualTo("Y")
        assertThat(result[0].n_addr_type_id).isEqualTo(AddressType.FactPlace)
        assertThat(result[0].n_par_addr_id).isEqualTo(null)
        assertThat(result[0].vc_code).isEqualTo("Fabulous Texan Way, Arizona, USA")
        assertThat(result[0].vc_visual_code).isEqualTo("Fabulous Texan Way, Arizona, USA")
        assertThat(result[0].vc_address).isEqualTo("Fabulous Texan Way, Arizona, USA")
        assertThat(result[0].vc_flat).isEqualTo(null)
        assertThat(result[0].n_region_id).isEqualTo(null)
        assertThat(result[0].vc_entrance_no).isEqualTo(null)
        assertThat(result[0].n_floor_no).isEqualTo(null)
        assertThat(result[0].n_firm_id).isEqualTo(null)
        assertThat(result[0].n_subj_address_id).isEqualTo(102006601)
        assertThat(result[0].n_subject_id).isEqualTo(99)
        assertThat(result[0].n_subj_addr_type_id).isEqualTo(BindAddressType.Jur)
        assertThat(result[0].n_addr_state_id).isEqualTo(AddressState.On)
        assertThat(result[0].vc_rem).isEqualTo(null)
        assertThat(result[0].n_bind_addr_id).isEqualTo(null)
        assertThat(result[0].vc_subj_addr_type_name).isEqualTo("Юридический адрес")
        assertThat(result[0].d_begin).isEqualTo(null)
        assertThat(result[0].d_end).isEqualTo(null)
        assertThat(result[0].n_address_id).isEqualTo(102004301)
    }
}
