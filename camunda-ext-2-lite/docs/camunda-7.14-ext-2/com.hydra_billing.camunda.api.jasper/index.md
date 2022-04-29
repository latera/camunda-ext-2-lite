//[camunda-7.14-ext-2](../../index.md)/[com.hydra_billing.camunda.api.jasper](index.md)

# Package com.hydra_billing.camunda.api.jasper

## Types

| Name | Summary |
|---|---|
| [Attachment](-attachment/index.md) | [jvm]<br>data class [Attachment](-attachment/index.md)(**contentType**: String, **fileName**: String) |
| [DetailsExport](-details-export/index.md) | [jvm]<br>data class [DetailsExport](-details-export/index.md)(**id**: String, **options**: [Options](-options/index.md), **status**: String, **outputResource**: [OutputResource](-output-resource/index.md), **attachments**: Array<[Attachment](-attachment/index.md)>) |
| [ErrorDescriptor](-error-descriptor/index.md) | [jvm]<br>data class [ErrorDescriptor](-error-descriptor/index.md)(**message**: String, **errorCode**: String, **parameters**: Array<String>) |
| [ExecuteReportParams](-execute-report-params/index.md) | [jvm]<br>data class [ExecuteReportParams](-execute-report-params/index.md)(**reportUnitUri**: String, **parameters**: LinkedHashMap<String, Any>, **outputFormat**: String, **freshData**: Boolean, **saveDataSnapshot**: Boolean, **interactive**: Boolean, **allowInlineScripts**: Boolean, **ignorePagination**: Boolean?, **pages**: Int?, **async**: Boolean, **transformerKey**: String?, **attachmentsPrefix**: String, **baseUrl**: String?) |
| [ExecuteReportResponse](-execute-report-response/index.md) | [jvm]<br>data class [ExecuteReportResponse](-execute-report-response/index.md)(**currentPage**: Int, **exports**: Array<[Export](-export/index.md)>, **reportURI**: String, **requestId**: String, **status**: String) |
| [ExecutionDetailsResponse](-execution-details-response/index.md) | [jvm]<br>data class [ExecutionDetailsResponse](-execution-details-response/index.md)(**status**: String, **totalPages**: Int, **requestId**: String, **reportURI**: String, **exports**: Array<[DetailsExport](-details-export/index.md)>) |
| [ExecutionStatusResponse](-execution-status-response/index.md) | [jvm]<br>data class [ExecutionStatusResponse](-execution-status-response/index.md)(**value**: String, **errorDescriptor**: [ErrorDescriptor](-error-descriptor/index.md)?) |
| [Export](-export/index.md) | [jvm]<br>data class [Export](-export/index.md)(**id**: String, **status**: String) |
| [Options](-options/index.md) | [jvm]<br>data class [Options](-options/index.md)(**outputFormat**: String, **attachmentsPrefix**: String, **baseUrl**: String?, **allowInlineScripts**: Boolean) |
| [OutputResource](-output-resource/index.md) | [jvm]<br>data class [OutputResource](-output-resource/index.md)(**contentType**: String) |
| [Report](-report/index.md) | [jvm]<br>class [Report](-report/index.md)(**client**: HttpClient)<br>Report class is responsible for handling requests to JasperReports API. |
