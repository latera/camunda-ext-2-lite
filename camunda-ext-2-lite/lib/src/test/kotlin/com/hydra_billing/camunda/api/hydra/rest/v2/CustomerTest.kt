import com.hydra_billing.camunda.api.hydra.common_types.SubjectState
import com.hydra_billing.camunda.api.hydra.common_types.SubjectType
import com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers.Customer
import com.hydra_billing.camunda.http_clients.mock_clients.hydra.rest.v2.CustomerMockClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CustomerTest {
    @Test
    @DisplayName("Hydra rest api create customer")
    fun create() {
        val httpClient = CustomerMockClient.getClient()
        val api = Customer(httpClient)
        val createParams =
            Customer.CreateParams(
                vc_code = "Meine created",
                n_base_subject_id = 78194101,
                t_tags = arrayOf("тестовый_абонент"),
                n_subj_group_id = 55027301,
                group_ids = arrayOf(40250801),
                vc_rem = "Commentary for created Meine",
                n_reseller_id = 94911101
            )

        val result = api.create(createParams)

        assertThat(result.n_subject_id).isEqualTo(99940601)
        assertThat(result.vc_base_subject_name).isEqualTo("Майне Клаус")
        assertThat(result.additional_values[0].code).isEqualTo("SUBJ_VAL_SERVICE_SAMPLE")
        assertThat(result.additional_values[0].name).isEqualTo("Служебная выборка")
        assertThat(result.additional_values[0].value).isEqualTo(listOf<Any?>(null, "123"))
    }

    @Test
    @DisplayName("Hydra rest api show customer")
    fun get() {
        val httpClient = CustomerMockClient.getClient()
        val api = Customer(httpClient)
        val result = api.get(50162901)

        assertThat(result.vc_base_subject_code).isEqualTo("Оруэлл Д.")
        assertThat(result.n_customer_id).isEqualTo(50162901)
        assertThat(result.n_base_subject_id).isEqualTo(50155201)
        assertThat(result.vc_base_subject_name).isEqualTo("Оруэлл Джордж")
        assertThat(result.n_base_subj_type_id).isEqualTo(SubjectType.Person)
        assertThat(result.n_subj_state_id).isEqualTo(SubjectState.On)
        assertThat(result.vc_name).isEqualTo("Оруэлл Д.")
        assertThat(result.vc_code).isEqualTo("gordon")
        assertThat(result.d_created).isEqualTo("2012-10-05T22:37:08+04:00")
        assertThat(result.t_tags).isEqualTo(arrayOf("поэт", "сотрудник"))
        assertThat(result.vc_rem).isEqualTo("Абонент используется в тестах смены тарифа из ЛК")
        assertThat(result.n_firm_id).isEqualTo(100)
        assertThat(result.n_subj_group_id).isEqualTo(40231101)
        assertThat(result.n_reseller_id).isEqualTo(null)
        assertThat(result.group_ids).isEqualTo(arrayOf<Long>(40231101, 55027301))
        assertThat(result.n_subject_id).isEqualTo(50162901)
        assertThat(result.additional_values.size).isEqualTo(5)
    }

    @Test
    @DisplayName("Hydra rest api update customer")
    fun update() {
        val httpClient = CustomerMockClient.getClient()
        val api = Customer(httpClient)
        val params = Customer.UpdateParams(
            n_subj_state_id = SubjectState.ManuallySuspended,
            vc_code = "Meine updated",
            vc_rem = "Commentary updated"
        )
        val result = api.update(78194501, params)

        assertThat(result.n_subject_id).isEqualTo(78194501)
        assertThat(result.n_customer_id).isEqualTo(78194501)
        assertThat(result.n_base_subject_id).isEqualTo(78194101)
        assertThat(result.vc_base_subject_name).isEqualTo("Майне Клаус")
        assertThat(result.n_base_subj_type_id).isEqualTo(SubjectType.Person)
        assertThat(result.n_subj_state_id).isEqualTo(SubjectState.ManuallySuspended)
        assertThat(result.vc_name).isEqualTo("Майне К.")
        assertThat(result.vc_code).isEqualTo("Meine updated")
        assertThat(result.d_created).isEqualTo("2015-08-11T23:20:57+03:00")
        assertThat(result.t_tags).isEqualTo(arrayOf("тестовый_абонент"))
        assertThat(result.vc_rem).isEqualTo("Commentary updated")
        assertThat(result.n_firm_id).isEqualTo(100)
        assertThat(result.n_subj_group_id).isEqualTo(55054601)
        assertThat(result.n_reseller_id).isEqualTo(94911101)
        assertThat(result.group_ids).isEqualTo(arrayOf<Long>(55054601, 55027301))
        assertThat(result.vc_base_subject_code).isEqualTo("Майне К.")
        assertThat(result.additional_values.size).isEqualTo(5)
    }
}
