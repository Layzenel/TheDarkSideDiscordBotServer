package com.layzen.features.treasures

import io.ktor.server.locations.Location

@Location("v1/treasures")
class AllTreasures

@Location("v1/treasure")
class CreateTreasure

@Location("v1/treasure")
class SingleTreasureItem(val treasureId: String)

