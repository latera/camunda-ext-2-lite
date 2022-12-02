package com.hydra_billing.vacation_request

import com.hydra_billing.camunda.procs.BaseProc
import org.camunda.bpm.engine.delegate.DelegateExecution
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class SetInternalVarsProc : BaseProc() {
    override fun perform(execution: DelegateExecution) {
        execution.setVariable("firstName", "James")
        execution.setVariable("lastName", "Carter")
        execution.setVariable("email", "james@example.com ")
        execution.setVariable("beginDate", ZonedDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME))
        execution.setVariable("endDate", ZonedDateTime.now().plusDays(7).format(DateTimeFormatter.ISO_OFFSET_DATE_TIME))
        execution.setVariable("motivationText", "I had a lot of work last 7 years")
    }
}
