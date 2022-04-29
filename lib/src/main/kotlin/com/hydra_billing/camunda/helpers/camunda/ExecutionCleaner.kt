package com.hydra_billing.camunda.helpers.camunda

import org.camunda.bpm.engine.delegate.DelegateExecution

fun clearVariable(execution: DelegateExecution, variable: String) {
    execution.removeVariable(variable)
}

fun clearVariables(execution: DelegateExecution, variables: Array<String>) {
    variables.forEach { clearVariable(execution, it) }
}
