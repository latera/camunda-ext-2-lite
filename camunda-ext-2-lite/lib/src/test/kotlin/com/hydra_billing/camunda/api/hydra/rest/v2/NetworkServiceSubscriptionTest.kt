
import com.hydra_billing.camunda.api.hydra.common_types.AuthorizationType
import com.hydra_billing.camunda.api.hydra.common_types.NetworkServiceSubscriptionType
import com.hydra_billing.camunda.api.hydra.rest.v2.NetworkServiceSubscription
import com.hydra_billing.camunda.http_clients.mock_clients.hydra.rest.v2.NetworkServiceSubscriptionMockClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class NetworkServiceSubscriptionTest {
    @Test
    @DisplayName("Hydra rest api get customer network service subscriptions")
    fun list() {
        val httpClient = NetworkServiceSubscriptionMockClient.getClient()
        val api = NetworkServiceSubscription(httpClient)

        val result = api.list(50293401)

        assertThat(result.size).isEqualTo(1)
        assertThat(result[0].n_subj_serv_id).isEqualTo(54913901)
        assertThat(result[0].n_subj_serv_type_id).isEqualTo(NetworkServiceSubscriptionType.ServiceUse)
        assertThat(result[0].n_subject_id).isEqualTo(50293401)
        assertThat(result[0].n_service_id).isEqualTo(54300101)
        assertThat(result[0].vc_user_service_name).isEqualTo("sms-server(служба уведомлений)-1 (sms-server(служба уведомлений))")
        assertThat(result[0].n_object_id).isEqualTo(null)
        assertThat(result[0].n_auth_type_id).isEqualTo(AuthorizationType.LoginPass)
        assertThat(result[0].vc_auth_type).isEqualTo("Логин/пароль")
        assertThat(result[0].vc_login).isEqualTo(null)
    }
}
