package com.layzen.features.gear_score

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class GearScoreItem(
    @BsonId
    val gearScoreId: String = ObjectId().toString(),
    val discordNickname: String,
    val mention: String,
    val apSucc: String,
    val apAwak: String,
    val dp: String,
    val gs: String
)
