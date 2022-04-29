package com.hydra_billing.camunda.procs

import com.hydra_billing.camunda.exceptions.CantCastVariable
import com.hydra_billing.camunda.exceptions.EmptyExecutionVariable
import com.hydra_billing.camunda.exceptions.NoSuchConstant
import com.hydra_billing.camunda.exceptions.WrongNumberFormat
import org.camunda.bpm.engine.delegate.BpmnError
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate

abstract class BaseProc : JavaDelegate {

    override fun execute(execution: DelegateExecution) {
        try {
            perform(execution)
        } catch (e: EmptyExecutionVariable) {
            wrapExecutionException(execution, e)
        } catch (e: WrongNumberFormat) {
            wrapExecutionException(execution, e)
        } catch (e: NoSuchConstant) {
            wrapExecutionException(execution, e)
        } catch (e: CantCastVariable) {
            wrapExecutionException(execution, e)
        }
    }

    abstract fun perform(execution: DelegateExecution)

    fun wrapExecutionException(execution: DelegateExecution, e: Exception) {

        val msg: String = "ProcessInstanceId: ${execution.processInstanceId}, transitionId: ${execution.currentTransitionId}," +
            "activityName: ${execution.currentActivityName}, activityId: ${execution.currentActivityId}. ${e.message}"
        throw BpmnError("ParseExecutionException", msg)
    }
}
