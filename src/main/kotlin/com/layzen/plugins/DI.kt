package com.layzen.plugins

import com.layzen.core.moduleCore
import com.layzen.features.alchemy.moduleAlchemy
import com.layzen.features.crowns.moduleCrowns
import com.layzen.features.gear_score.moduleGearScore
import com.layzen.features.treasures.moduleTreasures
import io.ktor.server.application.Application
import io.ktor.server.application.install
import org.koin.ktor.plugin.Koin

fun Application.configureKoin() {
    install(Koin) {
        modules(moduleCore)
        modules(moduleTreasures)
        modules(moduleGearScore)
        modules(moduleCrowns)
        modules(moduleAlchemy)
    }
}