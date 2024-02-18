package com.layzen.util

import com.layzen.core.error_handler.MissingRequestBodyException
import io.ktor.server.application.ApplicationCall
import io.ktor.server.request.receiveNullable

suspend inline fun <reified T : Any> ApplicationCall.acceptOrThrowException(errorMessage: String): T {
    return kotlin.runCatching { this.receiveNullable<T>() }.getOrNull() ?: throw MissingRequestBodyException(errorMessage)
}