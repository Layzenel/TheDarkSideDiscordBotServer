package com.layzen.plugins

import com.layzen.core.error_handler.AuthenticationException
import com.layzen.core.error_handler.AuthorizationException
import com.layzen.core.error_handler.BadRequestException
import com.layzen.core.error_handler.ConflictException
import com.layzen.core.error_handler.ErrorData
import com.layzen.core.error_handler.MissingRequestBodyException
import com.layzen.core.error_handler.NotFoundException
import com.layzen.core.error_handler.ResponseErrors
import com.layzen.core.error_handler.SomethingWentWrongException
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.response.respond

fun Application.configureStatusPages() {
    install(StatusPages) {
        exception<AuthenticationException> { call, cause ->
            call.respond(HttpStatusCode.Unauthorized, ResponseErrors.Errors(listOf(ErrorData(cause.message))))
        }
        exception<AuthorizationException> { call, cause ->
            call.respond(HttpStatusCode.Forbidden, ResponseErrors.Errors(listOf(ErrorData(cause.message))))
        }
        exception<BadRequestException> { call, cause ->
            call.respond(HttpStatusCode.BadRequest, ResponseErrors.Errors(listOf(ErrorData(cause.message))))
        }
        exception<NotFoundException> { call, cause ->
            call.respond(HttpStatusCode.NotFound, ResponseErrors.Errors(listOf(ErrorData(cause.message))))
        }
        exception<ConflictException> { call, cause ->
            call.respond(HttpStatusCode.Conflict, ResponseErrors.Errors(listOf(ErrorData(cause.message))))
        }
        exception<SomethingWentWrongException> { call, cause ->
            call.respond(HttpStatusCode.ExpectationFailed, ResponseErrors.Errors(listOf(ErrorData(cause.message))))
        }
        exception<MissingRequestBodyException> { call, cause ->
            call.respond(HttpStatusCode.BadRequest, ResponseErrors.Errors(listOf(ErrorData(cause.message))))
        }
    }
}