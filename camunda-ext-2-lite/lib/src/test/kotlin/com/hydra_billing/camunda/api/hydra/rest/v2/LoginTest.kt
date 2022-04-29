import com.hydra_billing.camunda.api.hydra.rest.v2.Login
import com.hydra_billing.camunda.http_clients.mock_clients.hydra.rest.v2.LoginMockClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LoginTest {
    @Test
    @DisplayName("Hydra rest api login")
    fun login() {
        val httpClient = LoginMockClient.getClient()
        val loginApi = Login(httpClient)
        val loginParams = Login.LoginParams(login = "gordon", password = "q123")
        val result = loginApi.login(loginParams)
        assertThat(result.token).isEqualTo("3F75F1704486AF6F023AA0358E5690303D99D92E")
    }
}
