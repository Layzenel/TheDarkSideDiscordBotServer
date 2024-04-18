package com.layzen.core.db.models

import com.layzen.features.treasures.TreasureItem
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class TreasureItemDto(
    @BsonId val treasureId: ObjectId = ObjectId(),
    val name: String,
    val description: String,
    val guideUrl: String,
    val craftImageUrl: String,
    val iconUrl: String,
    val pieces: List<String>,
    val locations: List<String>,
    val monsters: List<String>
)

fun TreasureItemDto.toModel(): TreasureItem = TreasureItem(
    treasureId = treasureId.toString(),
    name = name,
    description = description,
    guideUrl = guideUrl,
    craftImageUrl = craftImageUrl,
    iconUrl = iconUrl,
    pieces = pieces,
    locations = locations,
    monsters = monsters
)

fun TreasureItem.toDto(): TreasureItemDto = TreasureItemDto(
    name = name,
    description = description,
    guideUrl = guideUrl,
    craftImageUrl = craftImageUrl,
    iconUrl = iconUrl,
    pieces = pieces,
    locations = locations,
    monsters = monsters
)
