//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.procs.hydra.subjects](../index.md)/[CreatePersonProc](index.md)

# CreatePersonProc

[jvm]\
class [CreatePersonProc](index.md) : [BaseProc](../../com.hydra_billing.camunda.procs/-base-proc/index.md)

This delegate is designed to create a Person base subject via Hydra REST API.

This delegate is using the following execution variables:

<ul><li><code>hydraPersonFirstName</code> - Person first name (*required*) /String/</li><li><code>hydraPersonLastName</code> - Person last name (*required*) /String/</li><li><code>hydraPersonSubjectStateId</code> - Person state ID (*required*) / [com.hydra_billing.camunda.api.hydra.common_types.SubjectState](../../com.hydra_billing.camunda.api.hydra.common_types/-subject-state/index.md)/</li><li><code>hydraPersonSecondName</code> - Person second name /String?/</li><li><code>hydraPersonOpfId</code> - Person opf ID /Long?/</li><li><code>hydraPersonFirmId</code> - Person firm ID (default is 100) /Long?/</li><li><code>hydraPersonSexId</code> - Person sex ID / [com.hydra_billing.camunda.api.hydra.common_types.SubjectSex](../../com.hydra_billing.camunda.api.hydra.common_types/-subject-sex/index.md)/</li><li><code>hydraPersonInn</code> - Person INN /String?/</li><li><code>hydraPersonPassportSerial</code> - Person passport serial number /String?/</li><li><code>hydraPersonPassportNo</code> - Person passport number /String?/</li><li><code>hydraPersonDoPassportDate</code> - Person passport issued date /String?/</li><li><code>hydraPersonPassportPlace</code> - Person passport issued place /String?/</li><li><code>hydraPersonPassportBirthDate</code> - Person birth date based on passport /String?/</li><li><code>hydraPersonPassportBirthPlace</code> - Person birth place based on passport /String?/</li><li><code>hydraPersonPensInsuranceNumber</code> - Person social insurance number /String?/</li><li><code>hydraPersonMedInsuranceNumber</code> - Person medical insurance number /String?/</li><li><code>hydraPersonCitizenRegiondId</code> - Person citizenship Hydra region ID /Long?/</li><li><code>hydraPersonKpp</code> - Person KPP /String?/</li><li><code>hydraPersonComment</code> - Person base subject comment /String?/</li><li><code>hydraPersonTags</code> - Person tags /Array<String>?/</li><li><code>hydraPersonAdditionalValues</code> - Person additional values /Array<com.hydra_billing.camunda.api.hydra.common_types.AdditionalValue>?/</li></ul>

The result of this delegate execution is the created Person base subject and the following variables stored in the Camunda execution:

<ul><li><code>hydraPerson</code> - Created Person base subject /Person.Person/</li></ul>

## Constructors

| | |
|---|---|
| [CreatePersonProc](-create-person-proc.md) | [jvm]<br>fun [CreatePersonProc](-create-person-proc.md)() |

## Functions

| Name | Summary |
|---|---|
| [doAction](do-action.md) | [jvm]<br>fun [doAction](do-action.md)(restApi: HttpClient, createPersonParams: [Person.CreateParams](../../com.hydra_billing.camunda.api.hydra.rest.v2.subjects.persons/-person/-create-params/index.md)): [Person.Person](../../com.hydra_billing.camunda.api.hydra.rest.v2.subjects.persons/-person/-person/index.md) |
| [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md) | [jvm]<br>open override fun [execute](../../com.hydra_billing.camunda.procs/-base-proc/execute.md)(execution: DelegateExecution) |
| [perform](perform.md) | [jvm]<br>open override fun [perform](perform.md)(execution: DelegateExecution) |
| [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md) | [jvm]<br>fun [wrapExecutionException](../../com.hydra_billing.camunda.procs/-base-proc/wrap-execution-exception.md)(execution: DelegateExecution, e: Exception) |
