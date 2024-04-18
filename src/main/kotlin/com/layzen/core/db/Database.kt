package com.layzen.core.db

import com.layzen.core.db.models.AlchemyItemDto
import com.layzen.core.db.models.AncientAnvilDto
import com.layzen.core.db.models.CrownItemDto
import com.layzen.core.db.models.GearScoreItemDto
import com.layzen.core.db.models.TreasureItemDto
import org.litote.kmongo.coroutine.CoroutineClient
import org.litote.kmongo.coroutine.CoroutineCollection
import org.litote.kmongo.coroutine.CoroutineDatabase

interface Database {
    val dbName: String
    val clientConnection: String
    val mongoClient: CoroutineClient
    val database: CoroutineDatabase
    val collectionTreasures: CoroutineCollection<TreasureItemDto>
    val collectionGearScore: CoroutineCollection<GearScoreItemDto>
    val collectionCrowns: CoroutineCollection<CrownItemDto>
    val collectionAlchemy: CoroutineCollection<AlchemyItemDto>
    val collectionAncientAnvil: CoroutineCollection<AncientAnvilDto>
}