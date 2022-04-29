package com.hydra_billing.camunda.procs.odoo

import com.hydra_billing.camunda.Logger.Logged
import com.hydra_billing.camunda.Logger.getLogger
import com.hydra_billing.camunda.api.odoo.Customer
import com.hydra_billing.camunda.helpers.camunda.getLong
import com.hydra_billing.camunda.helpers.common.DataClassHelper
import com.hydra_billing.camunda.helpers.odoo.LoginHelper
import com.hydra_billing.camunda.procs.BaseProc
import io.ktor.client.*
import org.camunda.bpm.engine.delegate.DelegateExecution

/**
 * This delegate is designed to get Odoo customer by Hydra customer ID.
 *
 * This delegate is using the following execution variables:
 * - <code>hydraCustomerId</code> - Customer ID (*required) /Long/
 *
 * The result of this delegate execution is the Odoo customer and the
 * following variables stored in the Camunda execution:
 * - <code>odooCustomer</code> - Odoo contact /Customer.CustomerData/
 */
class GetCustomerByHydraCustomerIdProc : BaseProc() {

    companion object : Logged {
        val logger = getLogger()
    }

    override fun perform(execution: DelegateExecution) {
        val client = LoginHelper.getOdooClient()
        val hydraCustomerId = getLong(execution, "hydraCustomerId")
        val odooCustomer = doAction(client, hydraCustomerId)
        setToExecution(execution, odooCustomer)
    }

    fun doAction(client: HttpClient, customerId: Long): Customer.CustomerData {
        return Customer(client).getByHydraId(customerId)
    }

    private fun setToExecution(execution: DelegateExecution, odooCustomer: Customer.CustomerData) {
        execution.setVariable(
            "odooCustomer",
            DataClassHelper.convertDataClassToMap<Customer.CustomerData>(
                odooCustomer
            )
        )
    }
}
