//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.api.jasper](../index.md)/[Report](index.md)

# Report

[jvm]\
class [Report](index.md)(**client**: HttpClient)

Report class is responsible for handling requests to JasperReports API.

## Constructors

| | |
|---|---|
| [Report](-report.md) | [jvm]<br>fun [Report](-report.md)(client: HttpClient)<br>Creates JasperReports API connector instance. |

## Functions

| Name | Summary |
|---|---|
| [executeReport](execute-report.md) | [jvm]<br>fun [executeReport](execute-report.md)(params: [ExecuteReportParams](../-execute-report-params/index.md)): [ExecuteReportResponse](../-execute-report-response/index.md)<br>Performs 'Running a Report Asynchronously' method. |
| [getFileFromReport](get-file-from-report.md) | [jvm]<br>fun [getFileFromReport](get-file-from-report.md)(requestId: String, exportId: String, fileName: String, attachmentsPrefix: String = "attachments"): String<br>Performs 'Requesting Report Output' method. |
| [getReportExecutionDetails](get-report-execution-details.md) | [jvm]<br>fun [getReportExecutionDetails](get-report-execution-details.md)(requestId: String): [ExecutionDetailsResponse](../-execution-details-response/index.md)<br>Performs 'Requesting Report Execution Details' method. |
| [getReportExecutionStatus](get-report-execution-status.md) | [jvm]<br>fun [getReportExecutionStatus](get-report-execution-status.md)(requestId: String): [ExecutionStatusResponse](../-execution-status-response/index.md)<br>Performs 'Polling Report Execution' method. |
| [getReportResult](get-report-result.md) | [jvm]<br>fun [getReportResult](get-report-result.md)(requestId: String, exportId: String): String<br>Performs 'Requesting Report Output' method. |

## Properties

| Name | Summary |
|---|---|
| [client](client.md) | [jvm]<br>val [client](client.md): HttpClient<br>HTTP client configured to send requests to JasperReports API. |
