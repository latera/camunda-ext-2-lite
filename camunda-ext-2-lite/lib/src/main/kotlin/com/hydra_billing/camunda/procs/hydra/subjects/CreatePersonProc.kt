package com.hydra_billing.camunda.procs.hydra.subjects

import com.hydra_billing.camunda.api.hydra.common_types.AdditionalValue
import com.hydra_billing.camunda.api.hydra.common_types.SubjectSex
import com.hydra_billing.camunda.api.hydra.common_types.SubjectState
import com.hydra_billing.camunda.api.hydra.rest.v2.subjects.persons.Person
import com.hydra_billing.camunda.helpers.camunda.*
import com.hydra_billing.camunda.helpers.common.DataClassHelper
import com.hydra_billing.camunda.helpers.hydra.rest.v2.LoginHelper
import com.hydra_billing.camunda.procs.BaseProc
import io.ktor.client.*
import org.camunda.bpm.engine.delegate.DelegateExecution

/**
 * This delegate is designed to create a Person base subject via Hydra REST API.
 *
 * This delegate is using the following execution variables:
 * - <code>hydraPersonFirstName</code> - Person first name (*required*) /String/
 * - <code>hydraPersonLastName</code> - Person last name (*required*) /String/
 * - <code>hydraPersonSubjectStateId</code> - Person state ID (*required*) /
 * [com.hydra_billing.camunda.api.hydra.common_types.SubjectState]/
 * - <code>hydraPersonSecondName</code> - Person second name /String?/
 * - <code>hydraPersonOpfId</code> - Person opf ID /Long?/
 * - <code>hydraPersonFirmId</code> - Person firm ID (default is 100) /Long?/
 * - <code>hydraPersonSexId</code> - Person sex ID /
 * [com.hydra_billing.camunda.api.hydra.common_types.SubjectSex]/
 * - <code>hydraPersonInn</code> - Person INN /String?/
 * - <code>hydraPersonPassportSerial</code> - Person passport serial number /String?/
 * - <code>hydraPersonPassportNo</code> - Person passport number /String?/
 * - <code>hydraPersonDoPassportDate</code> - Person passport issued date /String?/
 * - <code>hydraPersonPassportPlace</code> - Person passport issued place /String?/
 * - <code>hydraPersonPassportBirthDate</code> - Person birth date based on passport /String?/
 * - <code>hydraPersonPassportBirthPlace</code> - Person birth place based on passport /String?/
 * - <code>hydraPersonPensInsuranceNumber</code> - Person social insurance number /String?/
 * - <code>hydraPersonMedInsuranceNumber</code> - Person medical insurance number /String?/
 * - <code>hydraPersonCitizenRegiondId</code> - Person citizenship Hydra region ID /Long?/
 * - <code>hydraPersonKpp</code> - Person KPP /String?/
 * - <code>hydraPersonComment</code> - Person base subject comment /String?/
 * - <code>hydraPersonTags</code> - Person tags /Array<String>?/
 * - <code>hydraPersonAdditionalValues</code> - Person additional values
 * /Array<com.hydra_billing.camunda.api.hydra.common_types.AdditionalValue>?/
 *
 * The result of this delegate execution is the created Person base subject and the following
 * variables stored in the Camunda execution:
 * - <code>hydraPerson</code> - Created Person base subject /Person.Person/
 */
class CreatePersonProc : BaseProc() {

    override fun perform(execution: DelegateExecution) {
        val restApi = LoginHelper.getRestApiClient()
        val person = doAction(restApi, preparePersonParams(execution))
        setToExecution(execution, person)
    }

    fun doAction(restApi: HttpClient, createPersonParams: Person.CreateParams): Person.Person {
        return Person(restApi).create(createPersonParams)
    }

    private fun preparePersonParams(execution: DelegateExecution): Person.CreateParams {
        return Person.CreateParams(
            vc_first_name = getString(execution, "hydraPersonFirstName"),
            vc_surname = getString(execution, "hydraPersonLastName"),
            vc_second_name = getNullableString(execution, "hydraPersonSecondName"),
            n_subj_state_id = getNullableHydraConstant<SubjectState>(execution, "hydraPersonSubjectStateId") ?: SubjectState.On,
            n_opf_id = getNullableLong(execution, "hydraPersonOpfId"),
            n_firm_id = getNullableLong(execution, "hydraPersonFirmId") ?: 100,
            n_sex_id = getNullableHydraConstant<SubjectSex>(execution, "hydraPersonSexId"),
            vc_inn = getNullableString(execution, "hydraPersonInn"),
            vc_doc_serial = getNullableString(execution, "hydraPersonPassportSerial"),
            vc_doc_no = getNullableString(execution, "hydraPersonPassportNo"),
            d_doc = getNullableString(execution, "hydraPersonDoPassportDate"),
            vc_document = getNullableString(execution, "hydraPersonPassportPlace"),
            d_birth = getNullableString(execution, "hydraPersonPassportBirthDate"),
            vc_birth_place = getNullableString(execution, "hydraPersonPassportBirthPlace"),
            vc_pens_insurance = getNullableString(execution, "hydraPersonPensInsuranceNumber"),
            vc_med_insurance = getNullableString(execution, "hydraPersonMedInsuranceNumber"),
            n_citizenship_id = getNullableLong(execution, "hydraPersonCitizenRegionId"),
            vc_kpp = getNullableString(execution, "hydraPersonKpp"),
            vc_rem = getNullableString(execution, "hydraPersonComment"),
            t_tags = getVariableAs<Array<String>?>(execution, "hydraPersonTags"),
            additional_values = getVariableAs<Array<AdditionalValue>?>(execution, "hydraPersonAdditionalValues")
        )
    }

    private fun setToExecution(execution: DelegateExecution, person: Person.Person) {
        execution.setVariable(
            "hydraPerson",
            DataClassHelper.convertDataClassToMap<Person.Person>(
                person
            )
        )
    }
}
