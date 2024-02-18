package com.layzen.plugins

import com.layzen.features.gear_score.gearScoreRoutes
import com.layzen.features.treasures.treasureRoutes
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.locations.Locations
import io.ktor.server.routing.routing

fun Application.configureRouting() {
    install(Locations)
    routing {
        treasureRoutes()
        gearScoreRoutes()
    }
}
