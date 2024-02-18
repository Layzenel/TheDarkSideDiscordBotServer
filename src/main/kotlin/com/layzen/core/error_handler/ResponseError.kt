package com.layzen.core.error_handler

data class ResponseErrors(val errors: Errors) {
    data class Errors(val errors: List<ErrorData?> = listOf())
}

data class ErrorData(val message: String?)