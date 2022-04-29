import com.hydra_billing.camunda.api.hydra.common_types.AddressType
import com.hydra_billing.camunda.api.hydra.common_types.BindAddressType
import com.hydra_billing.camunda.api.hydra.rest.v2.net_devices.entries.Address
import com.hydra_billing.camunda.api.hydra.rest.v2.net_devices.types.CreateAddressParams
import com.hydra_billing.camunda.api.hydra.rest.v2.net_devices.types.UpdateAddressParams
import com.hydra_billing.camunda.http_clients.mock_clients.hydra.rest.v2.NetDeviceEntryAddressesMockClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class NetDeviceEntryAddressesTest {
    @Test
    @DisplayName("Hydra rest api create net device entry address")
    fun create() {
        val httpClient = NetDeviceEntryAddressesMockClient.getClient()
        val api = Address(httpClient)
        val params = CreateAddressParams(
            n_addr_type_id = AddressType.IPv4,
            n_obj_addr_type_id = BindAddressType.Actual,
            vc_code = "192.168.45.1",
            d_begin = "2021-12-29T08:42:08+03:00"
        )

        val result = api.create(params = params, entryId = 51091901, deviceId = 51091001)

        assertThat(result.n_address_id).isEqualTo(234036601)
        assertThat(result.n_addr_type_id).isEqualTo(AddressType.IPv4)
        assertThat(result.vc_addr_type_name).isEqualTo("IPv4-адрес")
        assertThat(result.n_par_addr_id).isEqualTo(null)
        assertThat(result.vc_code).isEqualTo("192.168.45.1")
        assertThat(result.vc_address).isEqualTo(null)
        assertThat(result.vc_flat).isEqualTo(null)
        assertThat(result.n_region_id).isEqualTo(null)
        assertThat(result.vc_entrance_no).isEqualTo(null)
        assertThat(result.n_floor_no).isEqualTo(null)
        assertThat(result.n_firm_id).isEqualTo(null)
        assertThat(result.n_bind_addr_id).isEqualTo(null)
        assertThat(result.n_obj_address_id).isEqualTo(234036701)
        assertThat(result.n_obj_addr_type_id).isEqualTo(BindAddressType.Actual)
        assertThat(result.d_begin).isEqualTo("2021-12-29T08:42:08+03:00")
        assertThat(result.d_end).isEqualTo(null)
        assertThat(result.vc_rem).isEqualTo(null)
        assertThat(result.vc_intercom_code).isEqualTo(null)
    }

    @Test
    @DisplayName("Hydra rest api update net device entry address")
    fun update() {
        val httpClient = NetDeviceEntryAddressesMockClient.getClient()
        val api = Address(httpClient)
        val params = UpdateAddressParams(
            vc_rem = "123"
        )

        val result = api.update(params = params, deviceId = 51091001, entryId = 51091901, addressId = 234036701)

        assertThat(result.n_address_id).isEqualTo(234036601)
        assertThat(result.n_addr_type_id).isEqualTo(AddressType.IPv4)
        assertThat(result.vc_addr_type_name).isEqualTo("IPv4-адрес")
        assertThat(result.n_par_addr_id).isEqualTo(null)
        assertThat(result.vc_code).isEqualTo("192.168.45.1")
        assertThat(result.vc_address).isEqualTo(null)
        assertThat(result.vc_flat).isEqualTo(null)
        assertThat(result.n_region_id).isEqualTo(null)
        assertThat(result.vc_entrance_no).isEqualTo(null)
        assertThat(result.n_floor_no).isEqualTo(null)
        assertThat(result.n_firm_id).isEqualTo(null)
        assertThat(result.n_bind_addr_id).isEqualTo(null)
        assertThat(result.n_obj_address_id).isEqualTo(234036701)
        assertThat(result.n_obj_addr_type_id).isEqualTo(BindAddressType.Actual)
        assertThat(result.d_begin).isEqualTo("2021-12-29T08:42:08+03:00")
        assertThat(result.d_end).isEqualTo(null)
        assertThat(result.vc_rem).isEqualTo("123")
        assertThat(result.vc_intercom_code).isEqualTo(null)
    }

    @Test
    @DisplayName("Hydra rest api get net device entry addresses list")
    fun list() {
        val httpClient = NetDeviceEntryAddressesMockClient.getClient()
        val api = Address(httpClient)

        val result = api.list(deviceId = 50182701, entryId = 51091901)

        assertThat(result.size).isEqualTo(3)
        assertThat(result[0].n_address_id).isEqualTo(51122501)
        assertThat(result[0].n_addr_type_id).isEqualTo(AddressType.IPv4)
        assertThat(result[0].vc_addr_type_name).isEqualTo("IPv4-адрес")
        assertThat(result[0].n_par_addr_id).isEqualTo(51121901)
        assertThat(result[0].vc_code).isEqualTo("192.168.16.2")
        assertThat(result[0].vc_address).isEqualTo(null)
        assertThat(result[0].vc_flat).isEqualTo(null)
        assertThat(result[0].n_region_id).isEqualTo(null)
        assertThat(result[0].vc_entrance_no).isEqualTo(null)
        assertThat(result[0].n_floor_no).isEqualTo(null)
        assertThat(result[0].n_firm_id).isEqualTo(100)
        assertThat(result[0].n_bind_addr_id).isEqualTo(null)
        assertThat(result[0].n_obj_address_id).isEqualTo(51122701)
        assertThat(result[0].n_obj_addr_type_id).isEqualTo(BindAddressType.Actual)
        assertThat(result[0].d_begin).isEqualTo("2021-01-31T17:19:39+03:00")
        assertThat(result[0].d_end).isEqualTo(null)
        assertThat(result[0].vc_rem).isEqualTo(null)
        assertThat(result[0].vc_intercom_code).isEqualTo(null)
    }

    @Test
    @DisplayName("Hydra rest api get net device entry address by id")
    fun get() {
        val httpClient = NetDeviceEntryAddressesMockClient.getClient()
        val api = Address(httpClient)

        val result = api.get(deviceId = 50182709, entryId = 51091901, addressId = 51122701)

        assertThat(result.n_address_id).isEqualTo(51122501)
        assertThat(result.n_addr_type_id).isEqualTo(AddressType.IPv4)
        assertThat(result.vc_addr_type_name).isEqualTo("IPv4-адрес")
        assertThat(result.n_par_addr_id).isEqualTo(51121901)
        assertThat(result.vc_code).isEqualTo("192.168.16.2")
        assertThat(result.vc_address).isEqualTo(null)
        assertThat(result.vc_flat).isEqualTo(null)
        assertThat(result.n_region_id).isEqualTo(null)
        assertThat(result.vc_entrance_no).isEqualTo(null)
        assertThat(result.n_floor_no).isEqualTo(null)
        assertThat(result.n_firm_id).isEqualTo(100)
        assertThat(result.n_bind_addr_id).isEqualTo(null)
        assertThat(result.n_obj_address_id).isEqualTo(51122701)
        assertThat(result.n_obj_addr_type_id).isEqualTo(BindAddressType.Actual)
        assertThat(result.d_begin).isEqualTo("2021-01-31T17:19:39+03:00")
        assertThat(result.d_end).isEqualTo(null)
        assertThat(result.vc_rem).isEqualTo(null)
        assertThat(result.vc_intercom_code).isEqualTo(null)
    }

    @Test
    @DisplayName("Hydra rest api delete net device entry addresses by id")
    fun delete() {
        val httpClient = NetDeviceEntryAddressesMockClient.getClient()
        val api = Address(httpClient)

        val result = api.delete(deviceId = 50182709, entryId = 51091901, addressId = 51122702)

        assertThat(result).isEqualTo(true)
    }
}
