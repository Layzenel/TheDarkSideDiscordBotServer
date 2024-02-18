package com.layzen.features.gear_score

import io.ktor.server.locations.Location


@Location("v1/gear-score")
class AllGearScoreItems

@Location("v1/gear-score")
class CreateGearScoreItem

@Location("v1/gear-score")
class UpdateGearScoreItem

@Location("v1/gear-score")
class DeleteGearScoreItem(val gearScoreItemId: String?)