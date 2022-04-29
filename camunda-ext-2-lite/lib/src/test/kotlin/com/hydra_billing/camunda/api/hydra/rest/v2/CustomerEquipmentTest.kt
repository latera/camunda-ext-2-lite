import com.hydra_billing.camunda.api.hydra.common_types.ObjectState
import com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers.CustomerEquipment
import com.hydra_billing.camunda.http_clients.mock_clients.hydra.rest.v2.CustomerEquipmentMockClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CustomerEquipmentTest {
    @Test
    @DisplayName("Hydra rest api create customer equipment")
    fun create() {
        val httpClient = CustomerEquipmentMockClient.getClient()
        val api = CustomerEquipment(httpClient)
        val createParams =
            CustomerEquipment.CreateParams(n_good_id = 21501, vc_code = "testing_equipment")

        val result = api.create(createParams, 302)

        assertThat(result.n_object_id).isEqualTo(99943701)
        assertThat(result.n_good_id).isEqualTo(21501)
        assertThat(result.additional_values[0].code).isEqualTo("GOOD_N_Param_Units")
        assertThat(result.additional_values[0].name).isEqualTo("Юниты")
        assertThat(result.additional_values[0].value).isEqualTo(null)
    }

    @Test
    @DisplayName("Hydra rest api show customer equipments")
    fun list() {
        val httpClient = CustomerEquipmentMockClient.getClient()
        val api = CustomerEquipment(httpClient)

        val result = api.list(302)

        assertThat(result.size).isEqualTo(2)
        assertThat(result[0].n_object_id).isEqualTo(40236101)
        assertThat(result[0].n_good_id).isEqualTo(40224501)
        assertThat(result[0].n_firm_id).isEqualTo(100)
        assertThat(result[0].n_obj_state_id).isEqualTo(ObjectState.Active)
        assertThat(result[0].vc_name).isEqualTo("Порт №migrator")
        assertThat(result[0].vc_code).isEqualTo("migrator")
        assertThat(result[0].vc_code_add).isEqualTo(null)
        assertThat(result[0].vc_rem).isEqualTo(null)
        assertThat(result[0].n_main_object_id).isEqualTo(40223001)
        assertThat(result[0].n_owner_id).isEqualTo(302)
        assertThat(result[0].vc_serial_number).isEqualTo(null)
        assertThat(result[0].vc_inventory_number).isEqualTo(null)
        assertThat(result[0].d_warranty_end).isEqualTo(null)
        assertThat(result[0].additional_values.size).isEqualTo(3)
        assertThat(result[0].additional_values[0].code).isEqualTo("NETSERV_CDRForceFinishTimeout")
        assertThat(result[0].additional_values[0].name).isEqualTo("Таймаут принудительного закрытия CDR (в часах)")
        assertThat(result[0].additional_values[0].value).isEqualTo(null)
        assertThat(result[0].additional_values[1].code).isEqualTo("NETSERV_OldCDRDeleteTimeout")
        assertThat(result[0].additional_values[1].name).isEqualTo("Таймаут удаления старых CDR (в днях)")
        assertThat(result[0].additional_values[1].value).isEqualTo(null)
        assertThat(result[0].additional_values[2].code).isEqualTo("ObjPar_CreateExDataCollJob")
        assertThat(result[0].additional_values[2].name).isEqualTo("Создавать задание по тарификации внешней статистики по услугам")
        assertThat(result[0].additional_values[2].value).isEqualTo(null)
    }

    @Test
    @DisplayName("Hydra rest api get customer equipment by id")
    fun getEquipmentById() {
        val httpClient = CustomerEquipmentMockClient.getClient()
        val api = CustomerEquipment(httpClient)

        val result = api.getEquipmentById(302, 40236101)

        assertThat(result.n_object_id).isEqualTo(40236101)
        assertThat(result.n_good_id).isEqualTo(40224501)
        assertThat(result.n_firm_id).isEqualTo(100)
        assertThat(result.n_obj_state_id).isEqualTo(ObjectState.Active)
        assertThat(result.vc_name).isEqualTo("Порт №migrator")
        assertThat(result.vc_code).isEqualTo("migrator")
        assertThat(result.vc_code_add).isEqualTo(null)
        assertThat(result.vc_rem).isEqualTo(null)
        assertThat(result.n_main_object_id).isEqualTo(40223001)
        assertThat(result.n_owner_id).isEqualTo(302)
        assertThat(result.vc_serial_number).isEqualTo(null)
        assertThat(result.vc_inventory_number).isEqualTo(null)
        assertThat(result.d_warranty_end).isEqualTo(null)
        assertThat(result.additional_values.size).isEqualTo(3)
        assertThat(result.additional_values[0].code).isEqualTo("NETSERV_CDRForceFinishTimeout")
        assertThat(result.additional_values[0].name).isEqualTo("Таймаут принудительного закрытия CDR (в часах)")
        assertThat(result.additional_values[0].value).isEqualTo(null)
        assertThat(result.additional_values[1].code).isEqualTo("NETSERV_OldCDRDeleteTimeout")
        assertThat(result.additional_values[1].name).isEqualTo("Таймаут удаления старых CDR (в днях)")
        assertThat(result.additional_values[1].value).isEqualTo(null)
        assertThat(result.additional_values[2].code).isEqualTo("ObjPar_CreateExDataCollJob")
        assertThat(result.additional_values[2].name).isEqualTo("Создавать задание по тарификации внешней статистики по услугам")
        assertThat(result.additional_values[2].value).isEqualTo(null)
    }
}
