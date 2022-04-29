import com.hydra_billing.camunda.api.hydra.rest.v2.documents.DocumentAttachment
import com.hydra_billing.camunda.http_clients.mock_clients.hydra.rest.v2.DocumentAttachmentMockClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class DocumentAttachmentTest {
    @Test
    @DisplayName("Hydra rest api create file")
    fun create() {
        val httpClient = DocumentAttachmentMockClient.getClient()
        val api = DocumentAttachment(httpClient)
        val createParams =
            DocumentAttachment.CreateParams("IWRscm93ICxvbGxlSA==", "hello_world.txt", "hello_world.txt")

        val result = api.create(94077301, createParams)

        assertThat(result.n_doc_file_id).isEqualTo(99951101)
        assertThat(result.extension).isEqualTo("txt")
        assertThat(result.base64_content).isEqualTo("IWRscm93ICxvbGxlSA==")
        assertThat(result.name).isEqualTo("hello_world.txt")
        assertThat(result.file_name).isEqualTo("hello_world.txt")
    }

    @Test
    @DisplayName("Hydra rest api document file list ")
    fun list() {
        val httpClient = DocumentAttachmentMockClient.getClient()
        val api = DocumentAttachment(httpClient)

        val result = api.list(94077301)

        assertThat(result[0].n_doc_file_id).isEqualTo(99952101)
        assertThat(result[0].extension).isEqualTo("txt")
        assertThat(result[0].base64_content).isEqualTo("SGVsbG8sIHdvcmxkIQ==")
        assertThat(result[0].name).isEqualTo("hello_world.txt")
        assertThat(result[0].file_name).isEqualTo("hello_world.txt")
    }

    @Test
    @DisplayName("Hydra rest api document file delete")
    fun delete() {
        val httpClient = DocumentAttachmentMockClient.getClient()
        val api = DocumentAttachment(httpClient)

        val result = api.delete(94077301, 99952301)

        assertThat(result).isEqualTo(true)
    }
}
