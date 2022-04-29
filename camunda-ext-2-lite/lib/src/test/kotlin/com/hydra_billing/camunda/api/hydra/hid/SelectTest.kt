import com.hydra_billing.camunda.api.hydra.hid.Hid
import com.hydra_billing.camunda.xml_rpc_clients.mock_clients.SelectMockClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class SelectTest {
    data class SelectData(
        val longVal: Long,
        val nullableLong: Long?,
        val anotherNullableLong: Long?,
        val str: String,
        val nullableStr: String?,
        val anotherNullableStr: String?,
        val flag: Boolean,
        val nullableFlag: Boolean?,
        val anotherNullableFlag: Boolean,
        val money: BigDecimal,
        val nullableMoney: BigDecimal?,
        val anotherNullableMoney: BigDecimal?
    )

    @Test
    @DisplayName("Hydra HID select")
    fun show() {
        val hidClient = SelectMockClient()
        val hid = Hid(hidClient)
        val result =
            hid.select<SelectData>(
                "select 1, null, 2, 'not null string', null, 'another not null string', 'Y', null, 'N', '123,1', null, '123.2' from dual",
                SelectData::class
            )
        assertThat(result[0].longVal).isEqualTo(1)
        assertThat(result[0].nullableLong).isEqualTo(null)
        assertThat(result[0].anotherNullableLong).isEqualTo(2)
        assertThat(result[0].str).isEqualTo("not null string")
        assertThat(result[0].nullableStr).isEqualTo(null)
        assertThat(result[0].anotherNullableStr).isEqualTo("another not null string")
        assertThat(result[0].flag).isEqualTo(true)
        assertThat(result[0].nullableFlag).isEqualTo(null)
        assertThat(result[0].anotherNullableFlag).isEqualTo(false)
        assertThat(result[0].money).isEqualTo(BigDecimal("123.1"))
        assertThat(result[0].nullableMoney == null).isEqualTo(true)
        assertThat(result[0].anotherNullableMoney).isEqualTo(BigDecimal("123.2"))
    }
}
