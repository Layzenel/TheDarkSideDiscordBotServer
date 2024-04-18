package com.layzen.plugins

import com.layzen.features.alchemy.routesAlchemy
import com.layzen.features.ancient_anvil.routesAncientAnvil
import com.layzen.features.crowns.routesCrowns
import com.layzen.features.gear_score.routesGearScore
import com.layzen.features.treasures.routesTreasures
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.locations.Locations
import io.ktor.server.routing.routing

fun Application.configureRouting() {
    install(Locations)
    routing {
        routesCrowns()
        routesGearScore()
        routesTreasures()
        routesAlchemy()
        routesAncientAnvil()
    }
}
