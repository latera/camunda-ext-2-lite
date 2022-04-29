//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.api](../index.md)/[SMTPApi](index.md)

# SMTPApi

[jvm]\
object [SMTPApi](index.md)

## Types

| Name | Summary |
|---|---|
| [Config](-config/index.md) | [jvm]<br>data class [Config](-config/index.md)(**host**: String, **port**: Int, **user**: String, **password**: String, **tls**: Boolean, **ssl**: Boolean, **timeout**: Long) |

## Functions

| Name | Summary |
|---|---|
| [createAttachmentPart](create-attachment-part.md) | [jvm]<br>fun [createAttachmentPart](create-attachment-part.md)(filePath: String, name: String): BodyPart |
| [createAttachmentPartFromString](create-attachment-part-from-string.md) | [jvm]<br>fun [createAttachmentPartFromString](create-attachment-part-from-string.md)(base64String: String, name: String, type: String): BodyPart |
| [createAttachmentPartFromUrl](create-attachment-part-from-url.md) | [jvm]<br>fun [createAttachmentPartFromUrl](create-attachment-part-from-url.md)(fileUrl: String, name: String): BodyPart |
| [createHTMLPart](create-h-t-m-l-part.md) | [jvm]<br>fun [createHTMLPart](create-h-t-m-l-part.md)(html: String): BodyPart |
| [createTextPart](create-text-part.md) | [jvm]<br>fun [createTextPart](create-text-part.md)(text: String): BodyPart |
| [getSession](get-session.md) | [jvm]<br>fun [getSession](get-session.md)(config: [SMTPApi.Config](-config/index.md)): Session |
| [getTransport](get-transport.md) | [jvm]<br>fun [getTransport](get-transport.md)(session: Session): Transport |
| [prepareMessage](prepare-message.md) | [jvm]<br>fun [prepareMessage](prepare-message.md)(session: Session, from: String, addresses: Array<String>, subject: String): MimeMessage |
| [sendMultipartMessage](send-multipart-message.md) | [jvm]<br>fun [sendMultipartMessage](send-multipart-message.md)(session: Session, from: String, addresses: Array<String>, subject: String, parts: Array<BodyPart>, transport: Transport? = null, closeConnection: Boolean = true) |
