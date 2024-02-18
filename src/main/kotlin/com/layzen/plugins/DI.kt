package com.layzen.plugins

import com.layzen.core.coreModules
import com.layzen.features.gear_score.gearScoreModules
import com.layzen.features.treasures.treasuresModule
import io.ktor.server.application.Application
import io.ktor.server.application.install
import org.koin.ktor.plugin.Koin

fun Application.configureKoin() {
    install(Koin) {
        modules(coreModules)
        modules(treasuresModule)
        modules(gearScoreModules)
    }
}