package com.hydra_billing.vacation_request

import org.camunda.bpm.engine.delegate.DelegateExecution

object Order {

    data class OrderData(
        val firstName: String? = null,
        val lastName: String? = null,
        val email: String? = null,
        val beginDate: String? = null,
        val endDate: String? = null,
        val motivationText: String? = null,
        val resolution: String? = null,
        val resolutionText: String? = null,
        val adjustResult: String? = null
    )

    private fun getOrderVariable(execution: DelegateExecution, variableName: String): String {
        return execution
            .getVariable(variableName)
            ?.toString()
            .orEmpty()
    }

    fun getFromExecution(execution: DelegateExecution): OrderData {
        return OrderData(
            firstName = getOrderVariable(execution, "firstName"),
            lastName = getOrderVariable(execution, "lastName"),
            email = getOrderVariable(execution, "email"),
            beginDate = getOrderVariable(execution, "beginDate"),
            endDate = getOrderVariable(execution, "endDate"),
            motivationText = getOrderVariable(execution, "motivationText"),
            resolution = getOrderVariable(execution, "resolution"),
            resolutionText = getOrderVariable(execution, "resolutionText"),
            adjustResult = getOrderVariable(execution, "adjustResult")
        )
    }

    fun setToExecution(execution: DelegateExecution, orderData: OrderData) {
        execution.setVariable("firstName", orderData.firstName)
        execution.setVariable("lastName", orderData.lastName)
        execution.setVariable("email", orderData.email)
        execution.setVariable("beginDate", orderData.beginDate)
        execution.setVariable("endDate", orderData.endDate)
        execution.setVariable("motivationText", orderData.motivationText)
        execution.setVariable("resolution", orderData.resolution)
        execution.setVariable("resolutionText", orderData.resolutionText)
        execution.setVariable("adjustResult", orderData.adjustResult)
    }
}
