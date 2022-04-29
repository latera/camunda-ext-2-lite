import com.hydra_billing.camunda.api.hydra.common_types.DocumentType
import com.hydra_billing.camunda.api.hydra.common_types.DocumentWorkflow
import com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers.CustomerContract
import com.hydra_billing.camunda.http_clients.mock_clients.hydra.rest.v2.CustomerContractMockClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CustomerContractTest {
    @Test
    @DisplayName("Hydra rest api create customer contract")
    fun create() {
        val httpClient = CustomerContractMockClient.getClient()
        val api = CustomerContract(httpClient)
        val createParams =
            CustomerContract.CreateParams(
                n_doc_type_id = DocumentType.CustomerContract,
                n_provider_id = 100,
                n_firm_id = 100,
                n_workflow_id = DocumentWorkflow.SubscriberContract,
                n_parent_doc_id = 40232501,
                vc_doc_no = "Test subscriber contract v2"
            )

        val result = api.create(createParams, 94893001)

        assertThat(result.n_doc_id).isEqualTo(99940001)
        assertThat(result.vc_doc_no).isEqualTo("Test subscriber contract v2")
        assertThat(result.additional_values[0].code).isEqualTo("CONTR_TestCustomField")
        assertThat(result.additional_values[0].name).isEqualTo("Test custom field")
        assertThat(result.additional_values[0].value).isEqualTo(null)
    }
}
