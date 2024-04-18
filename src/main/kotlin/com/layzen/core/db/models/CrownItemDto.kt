package com.layzen.core.db.models

import com.layzen.features.crowns.CrownItem
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class CrownItemDto(
    @BsonId val crownId: ObjectId = ObjectId(),
    val suitDetailName: String,
    val crownsCount: String,
    val valksCount: String,
    val iconName: String
)

fun CrownItemDto.toModel(): CrownItem = CrownItem(
    crownId = crownId.toString(),
    suitDetailName = suitDetailName,
    crownsCount = crownsCount,
    valksCount = valksCount,
    iconName = iconName
)

fun CrownItem.toDto(): CrownItemDto = CrownItemDto(
    suitDetailName = suitDetailName,
    crownsCount = crownsCount,
    valksCount = valksCount,
    iconName = iconName
)
