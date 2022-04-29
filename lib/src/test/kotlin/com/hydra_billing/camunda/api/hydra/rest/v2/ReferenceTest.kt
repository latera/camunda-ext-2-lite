import com.hydra_billing.camunda.api.hydra.common_types.*
import com.hydra_billing.camunda.api.hydra.rest.v2.Reference
import com.hydra_billing.camunda.http_clients.mock_clients.hydra.rest.v2.ReferenceMockClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ReferenceTest {
    @Test
    @DisplayName("Hydra rest api get references by type code")
    fun list() {
        val httpClient = ReferenceMockClient.getClient()
        val api = Reference(httpClient)

        val result = api.listByTypeCode("REF_TYPE_Document_Type")

        assertThat(result[0].n_ref_id).isEqualTo(1002)
        assertThat(result[0].n_par_ref_id).isEqualTo(null)
        assertThat(result[0].n_ref_type_id).isEqualTo(2)
        assertThat(result[0].n_ref_base_id).isEqualTo(null)
        assertThat(result[0].n_firm_id).isEqualTo(null)
        assertThat(result[0].vc_name).isEqualTo("Договор на оказание услуг")
        assertThat(result[0].vc_code).isEqualTo("DOC_TYPE_SubscriberContract")
        assertThat(result[0].vc_value).isEqualTo(null)
        assertThat(result[0].vc_value_2).isEqualTo(null)
        assertThat(result[0].vc_value_3).isEqualTo(null)
        assertThat(result[0].c_value).isEqualTo(null)
        assertThat(result[0].c_value_2).isEqualTo(null)
        assertThat(result[0].c_value_3).isEqualTo(null)
        assertThat(result[0].d_value).isEqualTo(null)
        assertThat(result[0].d_value_2).isEqualTo(null)
        assertThat(result[0].d_value_3).isEqualTo(null)
        assertThat(result[0].n_value).isEqualTo(null)
        assertThat(result[0].n_value_2).isEqualTo(null)
        assertThat(result[0].n_value_3).isEqualTo(null)
        assertThat(result[0].c_fl_editable).isEqualTo("N")
        assertThat(result[0].c_fl_manual).isEqualTo("N")
        assertThat(result[0].n_lang_id).isEqualTo(Language.Russian)
    }

    @Test
    @DisplayName("Hydra rest api get references code")
    fun getByCode() {
        val httpClient = ReferenceMockClient.getClient()
        val api = Reference(httpClient)

        val result = api.getByCode("DOC_TYPE_SubscriberContract")

        assertThat(result.n_ref_id).isEqualTo(1002)
        assertThat(result.n_par_ref_id).isEqualTo(null)
        assertThat(result.n_ref_type_id).isEqualTo(2)
        assertThat(result.n_ref_base_id).isEqualTo(null)
        assertThat(result.n_firm_id).isEqualTo(null)
        assertThat(result.vc_name).isEqualTo("Договор на оказание услуг")
        assertThat(result.vc_code).isEqualTo("DOC_TYPE_SubscriberContract")
        assertThat(result.vc_value).isEqualTo(null)
        assertThat(result.vc_value_2).isEqualTo(null)
        assertThat(result.vc_value_3).isEqualTo(null)
        assertThat(result.c_value).isEqualTo(null)
        assertThat(result.c_value_2).isEqualTo(null)
        assertThat(result.c_value_3).isEqualTo(null)
        assertThat(result.d_value).isEqualTo(null)
        assertThat(result.d_value_2).isEqualTo(null)
        assertThat(result.d_value_3).isEqualTo(null)
        assertThat(result.n_value).isEqualTo(null)
        assertThat(result.n_value_2).isEqualTo(null)
        assertThat(result.n_value_3).isEqualTo(null)
        assertThat(result.c_fl_editable).isEqualTo("N")
        assertThat(result.c_fl_manual).isEqualTo("N")
        assertThat(result.n_lang_id).isEqualTo(Language.Russian)
    }
}
