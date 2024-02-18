package com.layzen.features.treasures

import com.layzen.features.treasures.controller.TreasuresController
import io.ktor.server.application.call
import io.ktor.server.locations.get
import io.ktor.server.locations.post
import io.ktor.server.response.respond
import io.ktor.server.routing.Routing
import org.koin.ktor.ext.inject

fun Routing.treasureRoutes() {
    val controller: TreasuresController by inject()

    get<AllTreasures> {
        call.respond(controller.getAllTreasureItems(this))
    }
    get<SingleTreasureItem> {request ->
        call.respond(controller.getTreasureItemById(request))
    }
    post<CreateTreasure> {
        call.respond(controller.addTreasureItem(this))
    }
}