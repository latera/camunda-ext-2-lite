import com.hydra_billing.camunda.api.hydra.common_types.AddressType
import com.hydra_billing.camunda.api.hydra.common_types.BindAddressType
import com.hydra_billing.camunda.api.hydra.rest.v2.net_devices.Address
import com.hydra_billing.camunda.api.hydra.rest.v2.net_devices.types.*
import com.hydra_billing.camunda.http_clients.mock_clients.hydra.rest.v2.NetDeviceAddressesMockClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class NetDeviceAddressesTest {
    @Test
    @DisplayName("Hydra rest api create net device address")
    fun create() {
        val httpClient = NetDeviceAddressesMockClient.getClient()
        val api = Address(httpClient)
        val params = CreateAddressParams(
            n_addr_type_id = AddressType.FactPlace,
            n_obj_addr_type_id = BindAddressType.Actual,
            n_region_id = 51160001,
            d_begin = "2021-12-29T08:42:07+03:00"
        )

        val result = api.create(params = params, deviceId = 51091001)

        assertThat(result.n_address_id).isEqualTo(51160101)
        assertThat(result.n_addr_type_id).isEqualTo(AddressType.FactPlace)
        assertThat(result.vc_addr_type_name).isEqualTo("Обычный адрес")
        assertThat(result.n_par_addr_id).isEqualTo(null)
        assertThat(result.vc_code).isEqualTo(null)
        assertThat(result.vc_address).isEqualTo(null)
        assertThat(result.vc_flat).isEqualTo(null)
        assertThat(result.n_region_id).isEqualTo(51160001)
        assertThat(result.vc_entrance_no).isEqualTo(null)
        assertThat(result.n_floor_no).isEqualTo(null)
        assertThat(result.n_firm_id).isEqualTo(null)
        assertThat(result.n_bind_addr_id).isEqualTo(null)
        assertThat(result.n_obj_address_id).isEqualTo(227752901)
        assertThat(result.n_obj_addr_type_id).isEqualTo(BindAddressType.Actual)
        assertThat(result.d_begin).isEqualTo("2021-12-29T08:42:07+03:00")
        assertThat(result.d_end).isEqualTo(null)
        assertThat(result.vc_rem).isEqualTo(null)
        assertThat(result.vc_intercom_code).isEqualTo(null)
    }
    @Test
    @DisplayName("Hydra rest api update net device address")
    fun update() {
        val httpClient = NetDeviceAddressesMockClient.getClient()
        val api = Address(httpClient)
        val params = UpdateAddressParams(
            vc_rem = "123"
        )

        val result = api.update(params = params, deviceId = 50182709, addressId = 50184301)

        assertThat(result.n_address_id).isEqualTo(50184301)
        assertThat(result.n_addr_type_id).isEqualTo(AddressType.FactPlace)
        assertThat(result.vc_addr_type_name).isEqualTo("Обычный адрес")
        assertThat(result.n_par_addr_id).isEqualTo(null)
        assertThat(result.vc_code).isEqualTo("кв. 12")
        assertThat(result.vc_address).isEqualTo(null)
        assertThat(result.vc_flat).isEqualTo("12")
        assertThat(result.n_region_id).isEqualTo(51160001)
        assertThat(result.vc_entrance_no).isEqualTo(null)
        assertThat(result.n_floor_no).isEqualTo(null)
        assertThat(result.n_firm_id).isEqualTo(null)
        assertThat(result.n_bind_addr_id).isEqualTo(null)
        assertThat(result.n_obj_address_id).isEqualTo(51165001)
        assertThat(result.n_obj_addr_type_id).isEqualTo(BindAddressType.Serv)
        assertThat(result.d_begin).isEqualTo("2018-08-31T17:19:39+03:00")
        assertThat(result.d_end).isEqualTo(null)
        assertThat(result.vc_rem).isEqualTo("123")
        assertThat(result.vc_intercom_code).isEqualTo(null)
    }
    @Test
    @DisplayName("Hydra rest api get net device addresses list")
    fun list() {
        val httpClient = NetDeviceAddressesMockClient.getClient()
        val api = Address(httpClient)

        val result = api.list(deviceId = 50182701)

        assertThat(result.size).isEqualTo(1)
        assertThat(result[0].n_address_id).isEqualTo(50158501)
        assertThat(result[0].n_addr_type_id).isEqualTo(AddressType.FactPlace)
        assertThat(result[0].vc_addr_type_name).isEqualTo("Обычный адрес")
        assertThat(result[0].n_par_addr_id).isEqualTo(null)
        assertThat(result[0].vc_code).isEqualTo(null)
        assertThat(result[0].vc_address).isEqualTo(null)
        assertThat(result[0].vc_flat).isEqualTo(null)
        assertThat(result[0].n_region_id).isEqualTo(50158401)
        assertThat(result[0].vc_entrance_no).isEqualTo(null)
        assertThat(result[0].n_floor_no).isEqualTo(null)
        assertThat(result[0].n_firm_id).isEqualTo(null)
        assertThat(result[0].n_bind_addr_id).isEqualTo(null)
        assertThat(result[0].n_obj_address_id).isEqualTo(50184301)
        assertThat(result[0].n_obj_addr_type_id).isEqualTo(BindAddressType.Serv)
        assertThat(result[0].d_begin).isEqualTo("2012-10-06T01:27:37+04:00")
        assertThat(result[0].d_end).isEqualTo(null)
        assertThat(result[0].vc_rem).isEqualTo(null)
        assertThat(result[0].vc_intercom_code).isEqualTo(null)
    }

    @Test
    @DisplayName("Hydra rest api get net device addresses by id")
    fun get() {
        val httpClient = NetDeviceAddressesMockClient.getClient()
        val api = Address(httpClient)

        val result = api.get(deviceId = 50182701, addressId = 50184301)

        assertThat(result.n_address_id).isEqualTo(50158501)
        assertThat(result.n_addr_type_id).isEqualTo(AddressType.FactPlace)
        assertThat(result.vc_addr_type_name).isEqualTo("Обычный адрес")
        assertThat(result.n_par_addr_id).isEqualTo(null)
        assertThat(result.vc_code).isEqualTo(null)
        assertThat(result.vc_address).isEqualTo(null)
        assertThat(result.vc_flat).isEqualTo(null)
        assertThat(result.n_region_id).isEqualTo(50158401)
        assertThat(result.vc_entrance_no).isEqualTo(null)
        assertThat(result.n_floor_no).isEqualTo(null)
        assertThat(result.n_firm_id).isEqualTo(null)
        assertThat(result.n_bind_addr_id).isEqualTo(null)
        assertThat(result.n_obj_address_id).isEqualTo(50184301)
        assertThat(result.n_obj_addr_type_id).isEqualTo(BindAddressType.Serv)
        assertThat(result.d_begin).isEqualTo("2012-10-06T01:27:37+04:00")
        assertThat(result.d_end).isEqualTo(null)
        assertThat(result.vc_rem).isEqualTo(null)
        assertThat(result.vc_intercom_code).isEqualTo(null)
    }
}
