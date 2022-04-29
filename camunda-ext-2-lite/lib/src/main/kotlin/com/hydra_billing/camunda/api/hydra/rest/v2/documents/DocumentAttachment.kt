package com.hydra_billing.camunda.api.hydra.rest.v2.documents

import com.hydra_billing.camunda.Logger.*
import io.ktor.client.HttpClient
import io.ktor.client.request.*
import io.ktor.client.statement.HttpResponse
import io.ktor.http.*
import kotlinx.coroutines.*

class DocumentAttachment(val client: HttpClient) {
    companion object : Logged {
        val logger = getLogger()
    }

    data class CreateParams(
        val base64_content: String,
        val file_name: String,
        val name: String
    )

    data class Response(
        val file: File
    )

    data class ListResponse(
        val files: Array<File>
    )

    data class File(
        val n_doc_file_id: Long,
        val extension: String,
        val base64_content: String,
        val file_name: String,
        val name: String
    )

    fun create(documentId: Long, params: CreateParams): File {
        val client = this.client

        logger.info("Create file with $params")

        val response = runBlocking {
            client.post<Response> {
                url { encodedPath = "/rest/v2/documents/$documentId/files" }

                body = mapOf("file" to params)
            }
        }

        return response.file
    }

    fun list(documentId: Long): Array<File> {
        val perPage = 1000
        var page = 1
        val client = this.client
        val result: ArrayList<File> = ArrayList()

        logger.info("Get files for document $documentId")

        while (true) {
            val response = runBlocking {
                client.get<ListResponse> {
                    url { encodedPath = "/rest/v2/documents/$documentId/files" }

                    parameter("page", page)
                    parameter("per_page", perPage)
                }
            }
            result.addAll(response.files)
            page += 1

            if (response.files.size < perPage) {
                break
            }
        }

        return result.toTypedArray()
    }

    fun delete(documentId: Long, fileId: Long): Boolean {
        val client = this.client

        logger.info("Delete file $fileId for document $documentId")

        val response: HttpResponse = runBlocking {
            client.delete {
                url { encodedPath = "/rest/v2/documents/$documentId/files/$fileId" }
            }
        }

        return response.status == HttpStatusCode.NoContent
    }
}
