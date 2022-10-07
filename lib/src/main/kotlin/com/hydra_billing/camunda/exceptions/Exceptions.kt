package com.hydra_billing.camunda.exceptions

open class BaseRequestException(val code: Int, message: String) : Exception(message)

// Runtime exceptions
class EmptyExecutionVariable(message: String) : Exception(message)

class WrongNumberFormat(message: String) : Exception(message)

class NoSuchConstant(message: String) : Exception(message)

class CantCastVariable(message: String) : Exception(message)

// HTTP exceptions
class BadRequestException(code: Int, message: String) : BaseRequestException(code, message)

class RedirectException(code: Int, message: String) : BaseRequestException(code, message)

class ServerErrorException(code: Int, message: String) : BaseRequestException(code, message)

// IO Exception
class ConnectionException(message: String) : Exception(message)
