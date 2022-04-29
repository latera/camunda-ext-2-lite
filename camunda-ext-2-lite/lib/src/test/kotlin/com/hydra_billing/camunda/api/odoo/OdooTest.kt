import com.hydra_billing.camunda.api.odoo.Country
import com.hydra_billing.camunda.api.odoo.Customer
import com.hydra_billing.camunda.http_clients.mock_clients.odoo.OdooMockClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class OdooTest {
    @Test
    @DisplayName("Odoo Customer.getByNativeId")
    fun getCustomerByNativeId() {
        var config = OdooMockClient.Config(url = "http://localhost/", oa_name = "odoo", timeout = 6000, login = "test", token = "test")
        val restClient = OdooMockClient.getClient(config)
        val customer = Customer(restClient).getByNativeId(20)
        assertThat(customer.id).isEqualTo(20)
        assertThat(customer.name).isEqualTo("Edwin Hansen")
        assertThat(customer.email).isEqualTo("edwin.hansen58@example.com")
        assertThat(customer.is_company).isEqualTo(false)
        assertThat(customer.company_name).isEqualTo("")
        assertThat(customer.user_id).isEqualTo(null)
        assertThat(customer.phone).isEqualTo("(943)-352-2555")
        assertThat(customer.country_id).isEqualTo(233)
        assertThat(customer.state_id).isEqualTo(13)
        assertThat(customer.city).isEqualTo("Fairfield")
        assertThat(customer.street).isEqualTo("317 Fairchild Dr")
        assertThat(customer.street2).isEqualTo("")
        assertThat(customer.zip).isEqualTo("94535")
        assertThat(customer.hydra_customer_id).isEqualTo("123")
        assertThat(customer.comment).isEqualTo("test")
    }

    @Test
    @DisplayName("Odoo Customer.create")
    fun createCustomer() {
        var config = OdooMockClient.Config(url = "http://localhost/", oa_name = "odoo", timeout = 6000, login = "test", token = "test")
        val customerData = Customer.CustomerData(name = "Test")
        val restClient = OdooMockClient.getClient(config)
        val customer = Customer(restClient).create(customerData)
        assertThat(customer.id).isEqualTo(77)
        assertThat(customer.name).isEqualTo("Test")
        assertThat(customer.email).isEqualTo("")
        assertThat(customer.is_company).isEqualTo(false)
        assertThat(customer.company_name).isEqualTo("")
        assertThat(customer.user_id).isEqualTo(null)
        assertThat(customer.phone).isEqualTo("")
        assertThat(customer.country_id).isEqualTo(null)
        assertThat(customer.state_id).isEqualTo(null)
        assertThat(customer.city).isEqualTo("")
        assertThat(customer.street).isEqualTo("")
        assertThat(customer.street2).isEqualTo("")
        assertThat(customer.zip).isEqualTo("")
        assertThat(customer.hydra_customer_id).isEqualTo("")
        assertThat(customer.comment).isEqualTo("")
    }

    @Test
    @DisplayName("Odoo Country.getByNativeId")
    fun getCoutryByNativeId() {
        var config = OdooMockClient.Config(url = "http://localhost/", oa_name = "odoo", timeout = 6000, login = "test", token = "test")
        val restClient = OdooMockClient.getClient(config)
        val country = Country(restClient).getByNativeId(3)
        assertThat(country.id).isEqualTo(3)
        assertThat(country.name).isEqualTo("Afghanistan")
        assertThat(country.code).isEqualTo("AF")
        assertThat(country.currency_id).isEqualTo(47)
        assertThat(country.phone_code).isEqualTo(93)
        assertThat(country.address_format).isEqualTo("%(street)s\n%(street2)s\n%(city)s %(state_code)s %(zip)s\n%(country_name)s")
        assertThat(country.vat_label).isEqualTo("")
    }
}
