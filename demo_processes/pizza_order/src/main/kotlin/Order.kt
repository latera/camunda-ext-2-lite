package com.hydra_billing.pizza_order

import org.camunda.bpm.engine.delegate.DelegateExecution
import java.math.BigDecimal

object Order {

    data class OrderData(
        val customerName: String? = null,
        val customerPhone: String? = null,
        val pizzaType: String? = null,
        val orderStatus: String? = null,
        val ingredientCheese: Boolean? = null,
        val ingredientSalami: Boolean? = null,
        val ingredientPepper: Boolean? = null,
        val ingredientMushrooms: Boolean? = null,
        val ingredientVegetables: Boolean? = null,
        val ingredientOlives: Boolean? = null,
        val pizzaPrice: BigDecimal? = null
    )

    private fun getOrderVariable(execution: DelegateExecution, variableName: String): String {
        return execution
            .getVariable(variableName)
            ?.toString()
            .orEmpty()
    }

    private fun variableToBoolean(variable: String): Boolean {
        return variable.toLowerCase() == "true"
    }

    fun getFromExecution(execution: DelegateExecution): OrderData {
        return OrderData(
            customerName = getOrderVariable(execution, "customerName"),
            customerPhone = getOrderVariable(execution, "customerPhone"),
            pizzaType = getOrderVariable(execution, "pizzaType"),
            orderStatus = getOrderVariable(execution, "orderStatus"),
            ingredientCheese = variableToBoolean(getOrderVariable(execution, "ingredientCheese")),
            ingredientSalami = variableToBoolean(getOrderVariable(execution, "ingredientSalami")),
            ingredientPepper = variableToBoolean(getOrderVariable(execution, "ingredientPepper")),
            ingredientMushrooms = variableToBoolean(getOrderVariable(execution, "ingredientMushrooms")),
            ingredientVegetables = variableToBoolean(getOrderVariable(execution, "ingredientVegetables")),
            ingredientOlives = variableToBoolean(getOrderVariable(execution, "ingredientOlives")),
            pizzaPrice = getOrderVariable(execution, "pizzaPrice").toBigDecimalOrNull()

        )
    }

    fun setToExecution(execution: DelegateExecution, orderData: OrderData) {
        execution.setVariable("customerName", orderData.customerName)
        execution.setVariable("customerPhone", orderData.customerPhone)
        execution.setVariable("pizzaType", orderData.pizzaType)
        execution.setVariable("orderStatus", orderData.orderStatus)
        execution.setVariable("ingredientCheese", orderData.ingredientCheese)
        execution.setVariable("ingredientSalami", orderData.ingredientSalami)
        execution.setVariable("ingredientPepper", orderData.ingredientPepper)
        execution.setVariable("ingredientMushrooms", orderData.ingredientMushrooms)
        execution.setVariable("ingredientVegetables", orderData.ingredientVegetables)
        execution.setVariable("ingredientOlives", orderData.ingredientOlives)
        execution.setVariable("pizzaPrice", orderData.pizzaPrice)
    }
}
