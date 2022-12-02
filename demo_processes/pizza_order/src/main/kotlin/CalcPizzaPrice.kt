package com.hydra_billing.pizza_order

import com.hydra_billing.camunda.procs.BaseProc
import org.camunda.bpm.engine.delegate.DelegateExecution
import java.math.BigDecimal
import kotlin.reflect.full.memberProperties

class CalcPizzaPrice : BaseProc() {
    override fun perform(execution: DelegateExecution) {
        val orderData = Order.getFromExecution(execution)
        val pizzaPriceTotal: BigDecimal = doAction(orderData)
        setToExecution(execution, pizzaPriceTotal)
    }

    fun doAction(orderData: Order.OrderData): BigDecimal {
        var pizzaPrice = BigDecimal("0")
        pizzaPrice += PizzaPrice.getPrice(orderData.pizzaType!!)
        pizzaPrice += getIngredientsPriceTotal(orderData)
        return pizzaPrice
    }

    fun getIngredientsPriceTotal(orderData: Order.OrderData): BigDecimal {
        var ingredientsPriceTotal = BigDecimal("0")

        for (ingredient in orderData::class.memberProperties.filter { it.name.contains("ingredient") }) {
            if (ingredient.getter.call(orderData).toString().toBoolean()) {
                try {
                    ingredientsPriceTotal += IngredientPrice.getPrice("${ingredient.name.replace("ingredient", "")}")
                } catch (e: NoSuchElementException) {
                }
            }
        }
        return ingredientsPriceTotal
    }

    private fun setToExecution(execution: DelegateExecution, pizzaTotalPrice: BigDecimal) {
        execution.setVariable("pizzaPrice", pizzaTotalPrice)
    }
}
