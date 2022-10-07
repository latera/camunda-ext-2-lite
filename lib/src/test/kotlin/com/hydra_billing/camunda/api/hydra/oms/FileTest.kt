import com.hydra_billing.camunda.api.hydra.oms.File
import com.hydra_billing.camunda.http_clients.mock_clients.hydra.oms.FileMockClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class FileTest {

    @Test
    @DisplayName("Upload file to minio")
    fun upload() {
        val httpClient = FileMockClient.getClient()
        val fileApi = File(httpClient)

        val result = fileApi.upload(arrayOf(File.FileParams(name = "test.txt", content = "YXNk")))

        assertThat(result.size).isEqualTo(1)
        assertThat(result[0].url).isEqualTo("http://127.0.0.1:9000/bucket-name/1644743191779_test.txt")
        assertThat(result[0].name).isEqualTo("test.txt (13.02.2022 09:04:01)")
        assertThat(result[0].origin_name).isEqualTo("test.txt")
        assertThat(result[0].real_name).isEqualTo("1644743191779_test.txt")
        assertThat(result[0].field_name).isEqualTo(null)
        assertThat(result[0].upload_time).isEqualTo("2022-02-13T09:04:01+00:00")
        assertThat(result[0].end_point).isEqualTo("http://127.0.0.1:9000")
        assertThat(result[0].bucket).isEqualTo("bucket-name")
    }
}
