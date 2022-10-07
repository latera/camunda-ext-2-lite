package com.hydra_billing.camunda.procs

import com.hydra_billing.camunda.exceptions.*
import io.ktor.client.HttpClient
import io.ktor.client.features.*
import io.ktor.http.HttpStatusCode
import io.ktor.network.sockets.*
import org.camunda.bpm.engine.delegate.BpmnError
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate

abstract class BaseProc : JavaDelegate {
    private val connections: MutableList<HttpClient> = mutableListOf()

    fun addClient(client: HttpClient) {
        this.connections.add(client)
    }

    fun closeConnections() {
        connections.forEach { it ->
            it.close()
        }
    }

    override fun execute(execution: DelegateExecution) {
        try {
            perform(execution)
            closeConnections()
        } catch (e: EmptyExecutionVariable) {
            wrapExecutionException(execution, e)
        } catch (e: WrongNumberFormat) {
            wrapExecutionException(execution, e)
        } catch (e: NoSuchConstant) {
            wrapExecutionException(execution, e)
        } catch (e: CantCastVariable) {
            wrapExecutionException(execution, e)
        } catch (e: BadRequestException) {
            wrapResponseException(execution, e)
        } catch (e: RedirectException) {
            wrapResponseException(execution, e)
        } catch (e: ServerErrorException) {
            wrapResponseException(execution, e)
        } catch (e: HttpRequestTimeoutException) {
            wrapRequestException(execution, e)
        } catch (e: ConnectTimeoutException) {
            wrapRequestException(execution, e)
        } catch (e: SocketTimeoutException) {
            wrapRequestException(execution, e)
        } finally {
            closeConnections()
        }
    }

    abstract fun perform(execution: DelegateExecution)

    fun wrapExecutionException(execution: DelegateExecution, e: Exception) {

        val msg: String = "ProcessInstanceId: ${execution.processInstanceId}, transitionId: ${execution.currentTransitionId}," +
            "activityName: ${execution.currentActivityName}, activityId: ${execution.currentActivityId}. ${e.message}"
        throw BpmnError("ParseExecutionException", msg)
    }

    fun wrapResponseException(execution: DelegateExecution, e: BaseRequestException) {

        val msg: String = "ProcessInstanceId: ${execution.processInstanceId}, transitionId: ${execution.currentTransitionId}," +
            "activityName: ${execution.currentActivityName}, activityId: ${execution.currentActivityId}. " +
            "statusCode: ${e.code},  ${e.message}"
        throw BpmnError("HTTPResponseException", msg)
    }

    fun wrapRequestException(execution: DelegateExecution, e: Exception) {
        val statusCode = HttpStatusCode.RequestTimeout.value

        val msg: String = "ProcessInstanceId: ${execution.processInstanceId}, transitionId: ${execution.currentTransitionId}," +
            "activityName: ${execution.currentActivityName}, activityId: ${execution.currentActivityId}. " +
            "statusCode: $statusCode,  ${e.message}"
        throw BpmnError("HTTPRequestException", msg)
    }

    fun wrapSMTPException(execution: DelegateExecution, e: Exception) {

        val msg: String = "ProcessInstanceId: ${execution.processInstanceId}, transitionId: ${execution.currentTransitionId}," +
            "activityName: ${execution.currentActivityName}, activityId: ${execution.currentActivityId}. ${e.message}"
        throw BpmnError("SMTPException", msg)
    }

    fun wrapSocketException(execution: DelegateExecution, e: Exception) {

        val msg: String = "ProcessInstanceId: ${execution.processInstanceId}, transitionId: ${execution.currentTransitionId}," +
            "activityName: ${execution.currentActivityName}, activityId: ${execution.currentActivityId}. ${e.message}"
        throw BpmnError("SocketException", msg)
    }

    fun wrapJDBIException(execution: DelegateExecution, e: Exception) {

        val msg: String = "ProcessInstanceId: ${execution.processInstanceId}, transitionId: ${execution.currentTransitionId}," +
            "activityName: ${execution.currentActivityName}, activityId: ${execution.currentActivityId}. ${e.message}"
        throw BpmnError("JDBIException", msg)
    }
}
