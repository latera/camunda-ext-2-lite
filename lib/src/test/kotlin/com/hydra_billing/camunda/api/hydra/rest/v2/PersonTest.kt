import com.hydra_billing.camunda.api.hydra.common_types.SubjectState
import com.hydra_billing.camunda.api.hydra.rest.v2.subjects.persons.Person
import com.hydra_billing.camunda.http_clients.mock_clients.hydra.rest.v2.PersonMockClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    @DisplayName("Hydra rest api create person")
    fun create() {
        val httpClient = PersonMockClient.getClient()
        val api = Person(httpClient)
        val createParams = Person.CreateParams(vc_first_name = "Клаус", vc_surname = "Майне")

        val result = api.create(createParams)

        assertThat(result.n_person_id).isEqualTo(99948001)
        assertThat(result.vc_first_name).isEqualTo("Клаус")
        assertThat(result.vc_surname).isEqualTo("Майне")
        assertThat(result.n_subj_state_id).isEqualTo(SubjectState.On)
        assertThat(result.additional_values[0].code).isEqualTo("SUBJ_VAL_VC_SUBJ_NAME_GENITIVE")
        assertThat(result.additional_values[0].name).isEqualTo("ФИО в родительном падеже")
        assertThat(result.additional_values[0].value).isEqualTo(null)
    }
}
