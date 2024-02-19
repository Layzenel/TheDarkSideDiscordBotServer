package com.layzen.features.crowns

import com.layzen.features.crowns.controller.CrownsController
import io.ktor.server.application.call
import io.ktor.server.locations.get
import io.ktor.server.locations.post
import io.ktor.server.response.respond
import io.ktor.server.routing.Routing
import org.koin.ktor.ext.inject

fun Routing.routesCrowns() {
    val controller: CrownsController by inject()

    get<AllCrownItems> {
        call.respond(controller.getAllCrownItems(this))
    }
    post<CreateCrownItem> {
        call.respond(controller.addCrownItem(this))
    }
}