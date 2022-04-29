package com.hydra_billing.camunda.http_clients.mock_clients.hydra.rest.v2

import com.hydra_billing.camunda.http_clients.NullableTypeAdapterFactory
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.*
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.features.*
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.*
import io.ktor.http.*

object PersonMockClient {
    fun getClient(): HttpClient {
        return HttpClient(MockEngine) {
            engine {
                addHandler { request ->
                    when (request.url.fullPath) {
                        "/rest/v2/subjects/persons/" -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                            respond(
                                """{
                    "person": {
                      "n_person_id": 99948001,
                      "n_opf_id": 10041,
                      "vc_opf_code": "ИП",
                      "vc_opf_name": "Индивидуальный предприниматель",
                      "vc_first_name": "Клаус",
                      "vc_surname": "Майне",
                      "vc_second_name": null,
                      "n_sex_id": 1138,
                      "vc_sex": "Мужской",
                      "vc_inn": "123123123",
                      "n_doc_auth_type_id": null,
                      "vc_doc_auth_type_code": null,
                      "vc_doc_auth_type_name": null,
                      "vc_doc_serial": "6237",
                      "vc_doc_no": "421753",
                      "d_doc": "2020-12-15T04:35:32+03:00",
                      "vc_document": "ОВД",
                      "vc_doc_department": "123-531",
                      "d_birth": "2000-12-15T04:35:32+03:00",
                      "vc_birth_place": "Германия",
                      "vc_pens_insurance": "1512567343446",
                      "vc_med_insurance": "54352342435",
                      "n_subject_id": 99948001,
                      "n_subj_type_id": 18001,
                      "n_parent_subj_id": null,
                      "n_subj_state_id": 2011,
                      "vc_subj_state_name": "Активен",
                      "n_base_subject_id": 99948001,
                      "n_firm_id": 100,
                      "vc_firm": "Offline Telecom",
                      "n_region_id": 40230101,
                      "vc_region": "г. Москва",
                      "n_owner_id": 100,
                      "vc_subj_name": "Майне Клаус",
                      "vc_subj_code": "Майне К.",
                      "vc_name": "Майне Клаус",
                      "vc_code": "Майне К.",
                      "d_created": "2020-12-15T04:35:32+03:00",
                      "n_creator_id": 50162901,
                      "t_tags": [
                        "тестовый_абонент"
                      ],
                      "vc_tags": "тестовый_абонент",
                      "vc_rem": "Commentary",
                      "vc_code_upper": "МАЙНЕ К.",
                      "vc_name_upper": "МАЙНЕ КЛАУС",
                      "n_subj_group_id": null,
                      "vc_subj_group_name": null,
                      "n_citizenship_id": 54306901,
                      "vc_citizenship": "USA",
                      "vc_kpp": "111101123",
                      "additional_values": [
                        {
                          "code": "SUBJ_VAL_VC_SUBJ_NAME_GENITIVE",
                          "name": "ФИО в родительном падеже",
                          "value": null
                        },
                        {
                          "code": "SUBJ_VAL_C_FL_VIP",
                          "name": "VIP-клиент",
                          "value": null
                        },
                        {
                          "code": "SUBJ_VAL_HTML_TAG",
                          "name": "Служебный тэг",
                          "value": [
                            null
                          ]
                        }
                      ]
                    },
                    "navigation": {
                      "self": "http://example.org/rest/v2/subjects/persons/",
                      "customers": [

                      ],
                      "persons": "http://example.org/rest/v2/subjects/persons"
                    }
                  }""",
                                headers = responseHeaders
                            )
                        }
                        else -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Text.Plain.toString()))
                            respond("Wrong request", headers = responseHeaders)
                        }
                    }
                }
            }

            install(JsonFeature) {
                serializer =
                    GsonSerializer {
                        disableHtmlEscaping()
                        registerTypeAdapterFactory(NullableTypeAdapterFactory())
                    }
            }
            defaultRequest {
                host = "localhost"
                port = 3000
                header("Accept", "application/json")
                header("Content-Type", "application/json")
            }
        }
    }
}
