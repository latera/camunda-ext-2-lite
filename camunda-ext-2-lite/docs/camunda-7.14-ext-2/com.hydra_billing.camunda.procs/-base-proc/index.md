//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.procs](../index.md)/[BaseProc](index.md)

# BaseProc

[jvm]\
abstract class [BaseProc](index.md) : JavaDelegate

## Functions

| Name | Summary |
|---|---|
| [execute](execute.md) | [jvm]<br>open override fun [execute](execute.md)(execution: DelegateExecution) |
| [perform](perform.md) | [jvm]<br>abstract fun [perform](perform.md)(execution: DelegateExecution) |
| [wrapExecutionException](wrap-execution-exception.md) | [jvm]<br>fun [wrapExecutionException](wrap-execution-exception.md)(execution: DelegateExecution, e: Exception) |

## Inheritors

| Name |
|---|
| [GetCustomerAccountChargesProc](../../com.hydra_billing.camunda.procs.hydra.accounts/-get-customer-account-charges-proc/index.md) |
| [GetPersonalAccountByIDProc](../../com.hydra_billing.camunda.procs.hydra.accounts/-get-personal-account-by-i-d-proc/index.md) |
| [CreateEquipmentAddressProc](../../com.hydra_billing.camunda.procs.hydra.addresses/-create-equipment-address-proc/index.md) |
| [CreateEquipmentComponentAddressProc](../../com.hydra_billing.camunda.procs.hydra.addresses/-create-equipment-component-address-proc/index.md) |
| [CreatePersonAddressProc](../../com.hydra_billing.camunda.procs.hydra.addresses/-create-person-address-proc/index.md) |
| [DeleteEquipmentComponentAddressProc](../../com.hydra_billing.camunda.procs.hydra.addresses/-delete-equipment-component-address-proc/index.md) |
| [GetEquipmentAddressProc](../../com.hydra_billing.camunda.procs.hydra.addresses/-get-equipment-address-proc/index.md) |
| [GetEquipmentAddressesProc](../../com.hydra_billing.camunda.procs.hydra.addresses/-get-equipment-addresses-proc/index.md) |
| [GetEquipmentComponentAddressProc](../../com.hydra_billing.camunda.procs.hydra.addresses/-get-equipment-component-address-proc/index.md) |
| [GetEquipmentComponentAddressesProc](../../com.hydra_billing.camunda.procs.hydra.addresses/-get-equipment-component-addresses-proc/index.md) |
| [UpdateEquipmentAddressProc](../../com.hydra_billing.camunda.procs.hydra.addresses/-update-equipment-address-proc/index.md) |
| [UpdateEquipmentComponentAddressProc](../../com.hydra_billing.camunda.procs.hydra.addresses/-update-equipment-component-address-proc/index.md) |
| [GetCatalogItemByIdProc](../../com.hydra_billing.camunda.procs.hydra.catalog/-get-catalog-item-by-id-proc/index.md) |
| [ActualizeCustomerContractProc](../../com.hydra_billing.camunda.procs.hydra.docs/-actualize-customer-contract-proc/index.md) |
| [CreateCustomerContractProc](../../com.hydra_billing.camunda.procs.hydra.docs/-create-customer-contract-proc/index.md) |
| [AttachFileToDocumentProc](../../com.hydra_billing.camunda.procs.hydra.docs.files/-attach-file-to-document-proc/index.md) |
| [DeleteAttachmentProc](../../com.hydra_billing.camunda.procs.hydra.docs.files/-delete-attachment-proc/index.md) |
| [GetAttachmentsByDocumentProc](../../com.hydra_billing.camunda.procs.hydra.docs.files/-get-attachments-by-document-proc/index.md) |
| [CreateCustomerEquipmentProc](../../com.hydra_billing.camunda.procs.hydra.objects/-create-customer-equipment-proc/index.md) |
| [GetCustomerEquipmentByIdProc](../../com.hydra_billing.camunda.procs.hydra.objects/-get-customer-equipment-by-id-proc/index.md) |
| [GetCustomerEquipmentListProc](../../com.hydra_billing.camunda.procs.hydra.objects/-get-customer-equipment-list-proc/index.md) |
| [GetCustomerServiceSubscriptionListProc](../../com.hydra_billing.camunda.procs.hydra.objects/-get-customer-service-subscription-list-proc/index.md) |
| [GetReferenceByCodeProc](../../com.hydra_billing.camunda.procs.hydra.references/-get-reference-by-code-proc/index.md) |
| [GetReferencesByTypeCodeProc](../../com.hydra_billing.camunda.procs.hydra.references/-get-references-by-type-code-proc/index.md) |
| [CreateCustomerServiceSubscriptionProc](../../com.hydra_billing.camunda.procs.hydra.services/-create-customer-service-subscription-proc/index.md) |
| [GetCustomerServiceSubscriptionProc](../../com.hydra_billing.camunda.procs.hydra.services/-get-customer-service-subscription-proc/index.md) |
| [CreateCustomerAccountProc](../../com.hydra_billing.camunda.procs.hydra.subjects/-create-customer-account-proc/index.md) |
| [CreateCustomerProc](../../com.hydra_billing.camunda.procs.hydra.subjects/-create-customer-proc/index.md) |
| [CreatePersonProc](../../com.hydra_billing.camunda.procs.hydra.subjects/-create-person-proc/index.md) |
| [GetBaseSubjectAddressesProc](../../com.hydra_billing.camunda.procs.hydra.subjects/-get-base-subject-addresses-proc/index.md) |
| [GetCustomerNetworkServiceSubcriptionsProc](../../com.hydra_billing.camunda.procs.hydra.subjects/-get-customer-network-service-subcriptions-proc/index.md) |
| [GetCustomerProc](../../com.hydra_billing.camunda.procs.hydra.subjects/-get-customer-proc/index.md) |
| [UpdateCustomerProc](../../com.hydra_billing.camunda.procs.hydra.subjects/-update-customer-proc/index.md) |
| [SendMultipartMailProc](../../com.hydra_billing.camunda.procs.mail/-send-multipart-mail-proc/index.md) |
| [GetCustomerByHydraCustomerIdProc](../../com.hydra_billing.camunda.procs.odoo/-get-customer-by-hydra-customer-id-proc/index.md) |
| [UploadFileProc](../../com.hydra_billing.camunda.procs.oms/-upload-file-proc/index.md) |
