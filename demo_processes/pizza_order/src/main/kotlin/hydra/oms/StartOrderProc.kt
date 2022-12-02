package com.hydra_billing.pizza_order.hydra.oms

import com.hydra_billing.camunda.api.hydra.oms.Order
import com.hydra_billing.camunda.api.hydra.oms.Order.OrderParams
import com.hydra_billing.camunda.helpers.hydra.oms.LoginHelper
import com.hydra_billing.camunda.procs.BaseProc
import org.camunda.bpm.engine.delegate.DelegateExecution
import com.hydra_billing.pizza_order.Order as CurrentOrder

class StartOrderProc : BaseProc() {
    override fun perform(execution: DelegateExecution) {
        val client = LoginHelper.getHomsClient()
        addClient(client)
        val homsApi = Order(client)
        val orderData = getOrderData(execution)
        val startOrderParams = getStartOrderParams(execution)
        CurrentOrder.setToExecution(execution, orderData)
        doAction(homsApi, getOrderParams(startOrderParams, orderData))
    }

    data class StartOrderParams(
        val code: String,
        val bp_id: String?,
        val user_email: String?
    )

    fun doAction(homsApi: Order, orderParams: OrderParams<CurrentOrder.OrderData>) {
        homsApi.update<CurrentOrder.OrderData>(orderParams)
    }

    private fun getOrderData(execution: DelegateExecution): CurrentOrder.OrderData {
        return CurrentOrder.getFromExecution(execution)
    }

    private fun getStartOrderParams(execution: DelegateExecution): StartOrderParams {
        return StartOrderParams(
            code = execution.getVariable("homsOrderCode").toString(),
            bp_id = execution.processInstanceId,
            user_email = execution.getVariable("initiatorEmail").toString()
        )
    }

    fun getOrderParams(startOrderParams: StartOrderParams, orderData: CurrentOrder.OrderData): OrderParams<CurrentOrder.OrderData> {
        return OrderParams<CurrentOrder.OrderData>(
            order_type_code = "pizza_order",
            code = startOrderParams.code,
            bp_id = startOrderParams.bp_id,
            ext_code = null,
            bp_state = "in_progress",
            state = "in_progress",
            archived = false,
            data = orderData,
            done_at = null,
            user_email = startOrderParams.user_email
        )
    }
}
