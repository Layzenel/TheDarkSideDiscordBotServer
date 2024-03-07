package com.layzen.core.db.models

import com.layzen.features.gear_score.GearScoreItem
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class GearScoreItemDto(
    @BsonId val gearScoreId: ObjectId = ObjectId(),
    val discordNickname: String,
    val mention: String,
    val apSucc: String,
    val apAwak: String,
    val dp: String,
    val gs: String
)

fun GearScoreItemDto.toModel(): GearScoreItem = GearScoreItem(
    gearScoreId = gearScoreId.toString(),
    discordNickname = discordNickname,
    mention = mention,
    apSucc = apSucc,
    apAwak = apAwak,
    dp = dp,
    gs = gs
)

fun GearScoreItem.toDto(): GearScoreItemDto = GearScoreItemDto(
    discordNickname = discordNickname,
    mention = mention,
    apSucc = apSucc,
    apAwak = apAwak,
    dp = dp,
    gs = gs
)
