import com.hydra_billing.camunda.api.planado_v2.Job
import com.hydra_billing.camunda.api.planado_v2.common_types.Contact
import com.hydra_billing.camunda.api.planado_v2.common_types.SiteAddress
import com.hydra_billing.camunda.api.planado_v2.common_types.Skill
import com.hydra_billing.camunda.api.planado_v2.common_types.job.*
import com.hydra_billing.camunda.http_clients.mock_clients.planado_v2.JobMockClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class JobTest {
    @Test
    @DisplayName("Planado v2 job create test")
    fun create() {
        val httpClient = JobMockClient.getClient()
        val api = Job(httpClient)
        val jobCreateParams = Job.CreateParams(
            scheduled_at = "2021-08-24T14:00:00Z",
            scheduled_duration = JobDuration(60),
            assignee = JobAssignee(worker = JobWorker("138dbf6e-2978-6cd0-fdae-22fb66229a7f", "nikegor24@gmail.com")),
            job_type = JobType("138dbf6e-2a5d-6fe0-fdae-22fb66229a7f", "Монтаж"),
            template = JobTemplate("1399ec54-47c0-6420-e6c9-7e0e1c3a5e05", "netsurf_customer_connection"),
            client = JobClient("139b79e6-ba13-6220-758f-32061e2079b2"),
            address = SiteAddress(
                formatted = "Passeig de Gràcia, 92, 08008 Barcelona, Spain",
                apartment = "123",
                floor = "1",
                entrance_no = "123",
                description = "some address"
            ),
            skills = arrayOf<Skill>(Skill("d2299ab1-a89d-4a6f-bce9-f395172c9c35")),
            contacts = arrayOf<Contact>(
                Contact(
                    name = "Pedro",
                    value = "(834) 362-5246",
                    type = "phone"
                )
            )
        )
        val result = api.create(jobCreateParams)

        assertThat(result.job_uuid).isEqualTo("139e3f3e-eec9-6e90-1a33-7eedef81b28f")
    }

    @Test
    @DisplayName("Planado v2 job update test")
    fun update() {
        val httpClient = JobMockClient.getClient()
        val api = Job(httpClient)
        val job_uuid = "139e3f4b-6a42-6660-a9d1-5e3aefc1c29a"
        val jobUpdateParams = Job.UpdateParams(
            skills = arrayOf()
        )
        val result = api.update(id = job_uuid, params = jobUpdateParams)

        assertThat(result.job_uuid).isEqualTo("139e3f4b-6a42-6660-a9d1-5e3aefc1c29a")
    }

    @Test
    @DisplayName("Planado v2 job get test")
    fun get() {
        val httpClient = JobMockClient.getClient()
        val api = Job(httpClient)
        val jobUuid = "1399ec57-c76b-6c90-8ea4-7aa936ee4847"
        val result = api.get(jobUuid)

        assertThat(result.uuid).isEqualTo("1399ec57-c76b-6c90-8ea4-7aa936ee4847")
        assertThat(result.external_id).isEqualTo("123123123")
        assertThat(result.external_order_id).isEqualTo("123123123123123")
        assertThat(result.serial_no).isEqualTo(68)
        assertThat(result.status).isEqualTo("suspended")
        assertThat(result.scheduled_at).isEqualTo("2021-05-24T14:00:00Z")
        assertThat(result.scheduled_duration).isEqualTo(JobDuration(60))
        assertThat(result.template).isEqualTo(
            JobTemplate(
                uuid = "1399ec54-47c0-6420-e6c9-7e0e1c3a5e05",
                name = "netsurf_customer_connection"
            )
        )
        assertThat(result.client).isEqualTo(
            JobClient(
                uuid = "139b79e6-ba13-6220-758f-32061e2079b2",
                external_id = "38c1a2c325cd6c445a26aa7ff698d982"
            )
        )
        assertThat(result.site).isEqualTo(null)
        assertThat(result.type).isEqualTo(JobType(uuid = "138dbf6e-2a5d-6fe0-fdae-22fb66229a7f", code = "Монтаж"))
        assertThat(result.assignee).isEqualTo(
            JobAssignee(
                worker = JobWorker(
                    uuid = "138dbf6e-2978-6cd0-fdae-22fb66229a7f",
                    email = "nikegor24@gmail.com"
                )
            )
        )
        assertThat(result.skills).isEqualTo(
            arrayOf<Skill>(
                Skill(
                    uuid = "d2299ab1-a89d-4a6f-bce9-f395172c9c35",
                    name = "Чтение"
                )
            )
        )
        assertThat(result.territory).isEqualTo(
            JobTerritory(
                uuid = "29e9e04d-2c11-46ae-9aa9-f3e0525615e2",
                name = "Интернет"
            )
        )
        assertThat(result.description).isEqualTo("Some description")
        assertThat(result.contacts).isEqualTo(
            arrayOf<Contact>(
                Contact(
                    name = "Pedro",
                    value = "(834) 362-5246",
                    type = "phone"
                )
            )
        )
        assertThat(result.possible_resolutions).isEqualTo(
            arrayOf<JobResolution>(
                JobResolution(
                    uuid = "138dbf6e-2a07-6380-fdae-22fb66229a7f",
                    name = "Выполнен",
                    successful = true
                ),
                JobResolution(uuid = "138dbf6e-2a18-6ca0-fdae-22fb66229a7f", name = "Не выполнен", successful = false)
            )
        )
        assertThat(result.custom_fields).isEqualTo(arrayOf<JobCustomField>())
        assertThat(result.report_fields).isEqualTo(
            arrayOf<JobCustomField>(
                JobCustomField(
                    uuid = "1399ec55-d904-6b60-e6c9-7e0e1c3a5e05",
                    name = "Equipment MAC",
                    field_type = "barcode",
                    data_type = "string",
                    required = false,
                    value = "1234567890005",
                    filled_at = "2021-05-24T13:56:09Z"
                ),
                JobCustomField(
                    uuid = "1399ec55-d941-6310-e6c9-7e0e1c3a5e05",
                    name = "Scanned Contract",
                    field_type = "file",
                    data_type = "attachment",
                    required = false
                ),
            )
        )
    }
}
