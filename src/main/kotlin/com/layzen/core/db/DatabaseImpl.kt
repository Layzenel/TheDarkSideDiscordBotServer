package com.layzen.core.db

import com.layzen.core.db.config.DatabaseConfig
import com.layzen.core.db.models.AlchemyItemDto
import com.layzen.core.db.models.AncientAnvilDto
import com.layzen.core.db.models.CrownItemDto
import com.layzen.core.db.models.GearScoreItemDto
import com.layzen.core.db.models.TreasureItemDto
import org.litote.kmongo.coroutine.CoroutineClient
import org.litote.kmongo.coroutine.CoroutineCollection
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

class DatabaseImpl(private val databaseConfig: DatabaseConfig) : Database {

    override val dbName: String
        get() = databaseConfig.databaseName

    override val clientConnection: String
        get() = "mongodb://mongodb:27017"

    override val mongoClient: CoroutineClient
        get() = KMongo.createClient(clientConnection).coroutine

    override val database: CoroutineDatabase
        get() = mongoClient.getDatabase(databaseConfig.databaseName)

    override val collectionTreasures: CoroutineCollection<TreasureItemDto>
        get() = database.getCollection("Treasures")

    override val collectionGearScore: CoroutineCollection<GearScoreItemDto>
        get() = database.getCollection("Gear Score")

    override val collectionCrowns: CoroutineCollection<CrownItemDto>
        get() = database.getCollection("Crowns")

    override val collectionAlchemy: CoroutineCollection<AlchemyItemDto>
        get() = database.getCollection("Alchemy")

    override val collectionAncientAnvil: CoroutineCollection<AncientAnvilDto>
        get() = database.getCollection("AncientAnvil")
}