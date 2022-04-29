//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.api.hydra.rest.v2.documents](../index.md)/[DocumentAttachment](index.md)

# DocumentAttachment

[jvm]\
class [DocumentAttachment](index.md)(**client**: HttpClient)

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) : [Logged](../../com.hydra_billing.camunda.Logger/-logged/index.md) |
| [CreateParams](-create-params/index.md) | [jvm]<br>data class [CreateParams](-create-params/index.md)(**base64_content**: String, **file_name**: String, **name**: String) |
| [File](-file/index.md) | [jvm]<br>data class [File](-file/index.md)(**n_doc_file_id**: Long, **extension**: String, **base64_content**: String, **file_name**: String, **name**: String) |
| [ListResponse](-list-response/index.md) | [jvm]<br>data class [ListResponse](-list-response/index.md)(**files**: Array<[DocumentAttachment.File](-file/index.md)>) |
| [Response](-response/index.md) | [jvm]<br>data class [Response](-response/index.md)(**file**: [DocumentAttachment.File](-file/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [create](create.md) | [jvm]<br>fun [create](create.md)(documentId: Long, params: [DocumentAttachment.CreateParams](-create-params/index.md)): [DocumentAttachment.File](-file/index.md) |
| [delete](delete.md) | [jvm]<br>fun [delete](delete.md)(documentId: Long, fileId: Long): Boolean |
| [list](list.md) | [jvm]<br>fun [list](list.md)(documentId: Long): Array<[DocumentAttachment.File](-file/index.md)> |

## Properties

| Name | Summary |
|---|---|
| [client](client.md) | [jvm]<br>val [client](client.md): HttpClient |
