package com.layzen.features.ancient_anvil

import io.ktor.server.locations.Location

@Location("v1/ancient-anvil")
class AllAncientAnvilItems

@Location("v1/ancient-anvil")
class AncientAnvilItemsByGroup(val group: String?)

@Location("v1/ancient-anvil")
class CreateAncientAnvilItem