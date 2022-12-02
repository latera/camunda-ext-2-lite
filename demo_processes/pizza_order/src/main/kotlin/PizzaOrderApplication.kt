package org.latera.new_customer_process

import ch.qos.logback.classic.LoggerContext
import ch.qos.logback.classic.util.ContextInitializer
import com.hydra_billing.camunda.api.hydra.oms.Order
import com.hydra_billing.camunda.api.hydra.oms.Order.OrderParams
import com.hydra_billing.camunda.helpers.hydra.oms.LoginHelper
import com.hydra_billing.camunda.listeners.task.TaskNotifier
import org.camunda.bpm.application.PreUndeploy
import org.camunda.bpm.application.ProcessApplication
import org.camunda.bpm.application.impl.ServletProcessApplication
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.ExecutionListener
import org.camunda.bpm.engine.delegate.TaskListener
import org.slf4j.LoggerFactory
import java.net.URL
import javax.servlet.ServletContextEvent
import com.hydra_billing.pizza_order.Order as CurrentOrder

@ProcessApplication("pizza_order")
class PizzaOrderApplication() : ServletProcessApplication() {
    private val client = LoginHelper.getHomsClient()

    override fun getTaskListener(): TaskListener {
        return TaskNotifier(client)
    }

    override fun getExecutionListener(): ExecutionListener {
        return CustomExecutionListener()
    }

    override fun contextInitialized(sce: ServletContextEvent) {
        super.contextInitialized(sce)

        val lc = LoggerFactory.getILoggerFactory() as LoggerContext
        val ci = ContextInitializer(lc)
        val url: URL = ci.findURLOfDefaultConfigurationFile(true)
        lc.reset()
        ci.configureByResource(url)
    }

    @PreUndeploy
    fun closeClient() {
        this.client.close()
    }

    inner class CustomExecutionListener : ExecutionListener {
        override fun notify(execution: DelegateExecution) {
            val eventName = execution.eventName
            val orderCode = execution.getVariable("homsOrderCode")?.toString().orEmpty()

            if (eventName == ExecutionListener.EVENTNAME_END && orderCode.isNotEmpty()) {
                val homsApi = Order(client)

                val orderParams =
                    OrderParams<CurrentOrder.OrderData>(
                        order_type_code = "pizza_order",
                        code = orderCode,
                        bp_id = execution.processInstanceId,
                        ext_code = null,
                        bp_state = "in_progress",
                        state = "in_progress",
                        archived = false,
                        data = CurrentOrder.getFromExecution(execution),
                        done_at = null,
                        user_email = execution.getVariable("initiatorEmail").toString()
                    )

                homsApi.update<CurrentOrder.OrderData>(orderParams)
            }
        }
    }
}
