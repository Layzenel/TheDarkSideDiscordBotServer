package com.layzen.features.gear_score

import com.layzen.features.gear_score.controller.GearScoreController
import io.ktor.server.application.call
import io.ktor.server.locations.delete
import io.ktor.server.locations.get
import io.ktor.server.locations.post
import io.ktor.server.locations.put
import io.ktor.server.response.respond
import io.ktor.server.routing.Routing
import org.koin.ktor.ext.inject

fun Routing.routesGearScore() {
    val controller: GearScoreController by inject()

    get<AllGearScoreItems> {
        call.respond(controller.getAllGearScoreItems(this))
    }
    post<CreateGearScoreItem> {
        call.respond(controller.addGearScoreItem(this))
    }
    put<UpdateGearScoreItem> {
        call.respond(controller.updateGearScoreItem(this))
    }
    delete<DeleteGearScoreItem> {request ->
        call.respond(controller.deleteGearScoreItem(request))
    }
}