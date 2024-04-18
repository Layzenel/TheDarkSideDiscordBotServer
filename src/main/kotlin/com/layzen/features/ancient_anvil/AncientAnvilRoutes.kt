package com.layzen.features.ancient_anvil

import com.layzen.features.ancient_anvil.controller.AncientAnvilController
import io.ktor.server.application.call
import io.ktor.server.locations.get
import io.ktor.server.locations.post
import io.ktor.server.response.respond
import io.ktor.server.routing.Routing
import org.koin.ktor.ext.inject

fun Routing.routesAncientAnvil() {
    val controller: AncientAnvilController by inject()

    get<AllAncientAnvilItems> {
        call.respond(controller.getAllAncientAnvilItems(this))
    }
    get<AncientAnvilItemsByGroup> {
        call.respond(controller.getAncientAnvilByGroup(this))
    }
    post<CreateAncientAnvilItem> {
        call.respond(controller.addAncientAnvilItem(this))
    }
}