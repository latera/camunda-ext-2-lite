package com.hydra_billing.camunda.Logger

import org.slf4j.*

interface Logged

inline fun <reified T : Logged> T.getLogger(): Logger = LoggerFactory.getLogger(T::class.java)
