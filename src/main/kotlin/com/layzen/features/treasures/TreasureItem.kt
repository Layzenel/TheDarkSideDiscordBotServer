package com.layzen.features.treasures

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class TreasureItem(
    @BsonId val treasureId: String = ObjectId().toString(),
    val name: String,
    val description: String,
    val guideUrl: String,
    val craftImageUrl: String,
    val iconUrl: String,
    val pieces: List<String>,
    val locations: List<String>,
    val monsters: List<String>
)
