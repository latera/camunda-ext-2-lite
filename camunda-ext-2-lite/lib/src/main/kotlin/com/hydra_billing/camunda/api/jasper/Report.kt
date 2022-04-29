package com.hydra_billing.camunda.api.jasper

import io.ktor.client.HttpClient
import io.ktor.client.request.*
import kotlinx.coroutines.*

data class Export(val id: String, val status: String)

data class ExecuteReportParams(
    val reportUnitUri: String,
    val parameters: LinkedHashMap<String, Any>,
    val outputFormat: String = "pdf",
    val freshData: Boolean = false,
    val saveDataSnapshot: Boolean = false,
    val interactive: Boolean = true,
    val allowInlineScripts: Boolean = true,
    val ignorePagination: Boolean? = null,
    val pages: Int? = null,
    val async: Boolean = false,
    val transformerKey: String? = null,
    val attachmentsPrefix: String = "attachments",
    val baseUrl: String? = null
)

data class ExecuteReportResponse(
    val currentPage: Int,
    val exports: Array<Export>,
    val reportURI: String,
    val requestId: String,
    val status: String
)

data class Options(
    val outputFormat: String,
    val attachmentsPrefix: String,
    val baseUrl: String? = null,
    val allowInlineScripts: Boolean
)

data class OutputResource(val contentType: String)

data class Attachment(val contentType: String, val fileName: String)

data class DetailsExport(
    val id: String,
    val options: Options,
    val status: String,
    val outputResource: OutputResource,
    val attachments: Array<Attachment>
)

data class ExecutionDetailsResponse(
    val status: String,
    val totalPages: Int,
    val requestId: String,
    val reportURI: String,
    val exports: Array<DetailsExport>
)

data class ErrorDescriptor(
    val message: String,
    val errorCode: String,
    val parameters: Array<String>
)

data class ExecutionStatusResponse(val value: String, val errorDescriptor: ErrorDescriptor? = null)

/**
 * Report class is responsible for handling requests to JasperReports API.
 *
 * @property client HTTP client configured to send requests to JasperReports API.
 * @constructor Creates JasperReports API connector instance.
 */
class Report(val client: HttpClient) {
    /**
     * Performs 'Running a Report Asynchronously' method. Runs report asynchronously.
     * @param params instance of ExecuteReportParams containing parameters for request.
     * @return instance of ExecuteReportResponse containing the response results, contains the
     * requestID needed to track the execution until completion.
     */
    fun executeReport(params: ExecuteReportParams): ExecuteReportResponse {
        val client = this.client

        val response = runBlocking {
            client.post<ExecuteReportResponse> {
                url { encodedPath = "/rest_v2/reportExecutions" }
                body = params
            }
        }

        return response
    }

    /**
     * Performs 'Requesting Report Output' method. Downloads report output.
     * @param requestId request id.
     * @param exportId export id.
     * @return request response.
     */
    fun getReportResult(requestId: String, exportId: String): String {
        val client = this.client

        val response = runBlocking {
            client.get<String> {
                url {
                    encodedPath = "/rest_v2/reportExecutions/$requestId/exports/$exportId/outputResource"
                }
            }
        }

        return response
    }

    /**
     * Performs 'Requesting Report Output' method. Downloads attachments.
     * @param requestId request id.
     * @param exportId export id.
     * @param fileName filename.
     * @param attachmentsPrefix attachment prefix, default value = 'attachments'.
     * @return request response.
     */
    fun getFileFromReport(
        requestId: String,
        exportId: String,
        fileName: String,
        attachmentsPrefix: String = "attachments"
    ): String {
        val client = this.client

        val response = runBlocking {
            client.get<String> {
                url {
                    encodedPath =
                        "/rest_v2/reportExecutions/$requestId/exports/$exportId/$attachmentsPrefix/$fileName"
                }
            }
        }

        return response
    }

    /**
     * Performs 'Requesting Report Execution Details' method. Gets report details.
     * @param requestId request id.
     * @return instance of ExecutionDetailsResponse containing the response results.
     */
    fun getReportExecutionDetails(requestId: String): ExecutionDetailsResponse {
        val client = this.client

        val response = runBlocking {
            client.get<ExecutionDetailsResponse> {
                url { encodedPath = "/rest_v2/reportExecutions/$requestId" }
            }
        }

        return response
    }

    /**
     * Performs 'Polling Report Execution' method. Gets status of the report execution.
     * @param requestId request id.
     * @return instance of ExecutionStatusResponse containing the response results.
     */
    fun getReportExecutionStatus(requestId: String): ExecutionStatusResponse {
        val client = this.client

        val response = runBlocking {
            client.get<ExecutionStatusResponse> {
                url { encodedPath = "/rest_v2/reportExecutions/$requestId/status" }
            }
        }

        return response
    }
}
