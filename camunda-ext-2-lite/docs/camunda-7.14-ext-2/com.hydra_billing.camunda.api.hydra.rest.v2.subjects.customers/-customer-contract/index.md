//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.api.hydra.rest.v2.subjects.customers](../index.md)/[CustomerContract](index.md)

# CustomerContract

[jvm]\
class [CustomerContract](index.md)(**client**: HttpClient)

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) : [Logged](../../com.hydra_billing.camunda.Logger/-logged/index.md) |
| [CreateParams](-create-params/index.md) | [jvm]<br>data class [CreateParams](-create-params/index.md)(**n_doc_type_id**: [DocumentType](../../com.hydra_billing.camunda.api.hydra.common_types/-document-type/index.md), **n_provider_id**: Long, **n_firm_id**: Long, **n_workflow_id**: [DocumentWorkflow](../../com.hydra_billing.camunda.api.hydra.common_types/-document-workflow/index.md), **n_parent_doc_id**: Long?, **vc_doc_no**: String?, **d_doc**: String?, **d_begin**: String?, **d_end**: String?, **vc_rem**: String?) |
| [CustomerContract](-customer-contract/index.md) | [jvm]<br>data class [CustomerContract](-customer-contract/index.md)(**n_doc_id**: Long, **n_doc_type_id**: [DocumentType](../../com.hydra_billing.camunda.api.hydra.common_types/-document-type/index.md), **n_doc_state_id**: [DocumentState](../../com.hydra_billing.camunda.api.hydra.common_types/-document-state/index.md), **n_parent_doc_id**: Long, **n_workflow_id**: [DocumentWorkflow](../../com.hydra_billing.camunda.api.hydra.common_types/-document-workflow/index.md), **d_doc**: String, **d_time**: String, **vc_doc_no**: String, **d_begin**: String, **d_end**: String?, **n_firm_id**: Long, **vc_rem**: String?, **n_provider_id**: Long, **additional_values**: Array<[AdditionalValue](../../com.hydra_billing.camunda.api.hydra.common_types/-additional-value/index.md)>) |
| [Response](-response/index.md) | [jvm]<br>data class [Response](-response/index.md)(**contract**: [CustomerContract.CustomerContract](-customer-contract/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [create](create.md) | [jvm]<br>fun [create](create.md)(params: [CustomerContract.CreateParams](-create-params/index.md), customerId: Long): [CustomerContract.CustomerContract](-customer-contract/index.md) |
| [get](get.md) | [jvm]<br>fun [get](get.md)(customerId: Long, contractId: Long): [CustomerContract.CustomerContract](-customer-contract/index.md) |
| [update](update.md) | [jvm]<br>fun [update](update.md)(params: [CustomerContract.CustomerContract](-customer-contract/index.md), customerId: Long): [CustomerContract.CustomerContract](-customer-contract/index.md) |

## Properties

| Name | Summary |
|---|---|
| [client](client.md) | [jvm]<br>val [client](client.md): HttpClient |
