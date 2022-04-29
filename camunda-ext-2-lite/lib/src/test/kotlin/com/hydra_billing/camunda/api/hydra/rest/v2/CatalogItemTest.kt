import com.hydra_billing.camunda.api.hydra.common_types.*
import com.hydra_billing.camunda.api.hydra.rest.v2.catalog.CatalogItem
import com.hydra_billing.camunda.http_clients.mock_clients.hydra.rest.v2.CatalogItemMockClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CatalogItemTest {
    @Test
    @DisplayName("Hydra rest api get good")
    fun get() {
        val httpClient = CatalogItemMockClient.getClient()
        val api = CatalogItem(httpClient)

        val result = api.get(40213401)

        assertThat(result.n_good_group_id).isEqualTo(CatalogItemGroup.Product)
        assertThat(result.n_unit_id).isEqualTo(4049)
        assertThat(result.vc_code).isEqualTo("Интернет-трафик")
        assertThat(result.vc_name).isEqualTo("Интернет-трафик")
        assertThat(result.n_quant).isEqualTo(null)
        assertThat(result.t_tags).isEqualTo(arrayOf<String>())
        assertThat(result.vc_tags).isEqualTo(null)
        assertThat(result.n_service_id).isEqualTo(40213401)
        assertThat(result.n_service_type_id).isEqualTo(CatalogItemType.Serv)
        assertThat(result.n_base_service_id).isEqualTo(null)
        assertThat(result.n_parent_service_id).isEqualTo(1802)
        assertThat(result.vc_service_code).isEqualTo("Интернет-трафик")
        assertThat(result.vc_service_name).isEqualTo("Интернет-трафик")
        assertThat(result.additional_values[0].code).isEqualTo("GOOD_C_FL_Serv_GroupByPrice")
        assertThat(result.additional_values[0].name).isEqualTo("Группировать начисления по цене")
        assertThat(result.additional_values[0].value).isEqualTo("Y")
    }
}
