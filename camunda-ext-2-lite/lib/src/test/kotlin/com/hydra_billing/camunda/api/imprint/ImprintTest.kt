package com.hydra_billing.camunda.api.imprint

import com.hydra_billing.camunda.http_clients.mock_clients.imprint.ImprintMockClient
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ImprintTest {
    data class Data(val foo: String)

    @Test
    @DisplayName("Imprint test")
    fun print() {
        val httpClient = ImprintMockClient.getClient()
        val imprintApi = Imprint(httpClient)
        val result = imprintApi.print("template_name", Data(foo = "Template data."), false)
        Assertions.assertThat(result.base64string).isEqualTo("dGVzdCBUZW1wbGF0ZSBkYXRhLg==")
        Assertions.assertThat(result.filename).isEqualTo("simple_plain_text.txt")
    }
}
