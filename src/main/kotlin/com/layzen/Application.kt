package com.layzen

import com.layzen.plugins.configureKoin
import com.layzen.plugins.configureRouting
import com.layzen.plugins.configureSerialization
import com.layzen.plugins.configureStatusPages
import io.ktor.server.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSerialization()
    configureKoin()
    configureRouting()
    configureStatusPages()
}
