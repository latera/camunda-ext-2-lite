package com.hydra_billing.camunda.listeners.task

import com.hydra_billing.camunda.api.hydra.oms.TaskEvent
import io.ktor.client.HttpClient
import io.ktor.client.request.*
import kotlinx.coroutines.*
import org.camunda.bpm.engine.delegate.DelegateTask
import org.camunda.bpm.engine.delegate.TaskListener
import org.camunda.bpm.engine.impl.cfg.TransactionState
import org.camunda.bpm.engine.impl.context.Context
import org.camunda.bpm.engine.impl.interceptor.CommandContext

class TaskNotifier(val client: HttpClient) : TaskListener {
    override fun notify(task: DelegateTask) {
        val transactionListener = { commandContext: CommandContext ->
            val assignee = TaskNotifier.getAssignee(task)
            val candidates = TaskNotifier.getCandidates(task)
            val users = candidates.toTypedArray() + assignee
            val version = System.currentTimeMillis()
            try {
                TaskEvent(client).update(task.getId(), task.getEventName(), assignee, users, version)
            } catch (e: Exception) {
                client.close()
                throw e
            }
        }

        Context.getCommandContext()
            .getTransactionContext()
            .addTransactionListener(TransactionState.COMMITTED, transactionListener)
    }

    companion object {
        fun getAssignee(task: DelegateTask): String? {
            val assigneeId = task.getAssignee()

            if (assigneeId != null) {
                return task.getExecution()
                    .getProcessEngineServices()
                    .getIdentityService()
                    .createUserQuery()
                    .userId(assigneeId)
                    .singleResult()
                    .getEmail()
            } else {
                return null
            }
        }

        fun getCandidates(task: DelegateTask): List<String?> {
            val candidateGroups: List<String?> = task.getCandidates().map { it.getGroupId() }
            val query =
                task.getExecution().getProcessEngineServices().getIdentityService().createUserQuery()

            val candidates =
                candidateGroups.fold(listOf<String?>()) { _, group ->
                    query.memberOfGroup(group).list().map { it.getEmail() }
                }

            return candidates
        }
    }
}
