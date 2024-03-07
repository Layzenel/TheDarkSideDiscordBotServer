package com.layzen.features.alchemy

import com.layzen.features.alchemy.controller.AlchemyController
import io.ktor.server.application.call
import io.ktor.server.locations.get
import io.ktor.server.locations.post
import io.ktor.server.response.respond
import io.ktor.server.routing.Routing
import org.koin.ktor.ext.inject

fun Routing.routesAlchemy() {
    val controller: AlchemyController by inject()

    get<AllAlchemyItems> {
        call.respond(controller.getAllAlchemyItems(this))
    }
    post<CreateAlchemyItem> {
        call.respond(controller.addAlchemyItem(this))
    }
}