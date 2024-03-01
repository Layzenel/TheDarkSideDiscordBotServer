package com.layzen

import com.layzen.plugins.configureKoin
import com.layzen.plugins.configureRouting
import com.layzen.plugins.configureSerialization
import com.layzen.plugins.configureStatusPages
import io.ktor.server.application.Application
import io.ktor.server.netty.EngineMain

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {
    configureSerialization()
    configureKoin()
    configureRouting()
    configureStatusPages()
}
