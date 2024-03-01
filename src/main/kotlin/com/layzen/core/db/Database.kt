package com.layzen.core.db

import com.layzen.features.crowns.CrownItem
import com.layzen.features.gear_score.GearScoreItem
import com.layzen.features.treasures.TreasureItem
import org.litote.kmongo.coroutine.CoroutineClient
import org.litote.kmongo.coroutine.CoroutineCollection
import org.litote.kmongo.coroutine.CoroutineDatabase

interface Database {
    val dbName: String
    val clientConnection: String
    val mongoClient: CoroutineClient
    val database: CoroutineDatabase
    val treasuresCollection: CoroutineCollection<TreasureItem>
    val gearScoreCollection: CoroutineCollection<GearScoreItem>
    val crownsCollection: CoroutineCollection<CrownItem>
}