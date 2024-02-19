package com.layzen.features.crowns

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class CrownItem(
    @BsonId val crownId: String = ObjectId().toString(),
    val suitDetailName: String,
    val crownsCount: String,
    val valksCount: String,
    val iconName: String
)
