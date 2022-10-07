package com.hydra_billing.camunda.api.hydra.oms

import com.hydra_billing.camunda.Logger.*
import io.ktor.client.HttpClient
import io.ktor.client.request.*
import kotlinx.coroutines.*

class TaskEvent(val client: HttpClient) {
    companion object : Logged {
        val logger = getLogger()
    }

    fun update(
        taskId: String,
        eventName: String?,
        assignee: String?,
        users: Array<String?>?,
        version: Long
    ) {
        val client = this.client

        logger.info(
            "Update task taskId = $taskId, eventName = $eventName, assignee = $assignee, users = $users, version = $version"
        )

        runBlocking {
            client.put<Any> {
                url { encodedPath = "/widget/events/tasks/$taskId" }
                body =
                    mapOf(
                        "assignee" to assignee,
                        "event_name" to eventName,
                        "users" to users,
                        "version" to version
                    )
            }
        }
    }
}
