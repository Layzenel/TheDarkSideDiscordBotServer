package com.layzen.core.db

import com.layzen.core.db.config.DatabaseConfig
import com.layzen.features.gear_score.GearScoreItem
import com.layzen.features.treasures.TreasureItem
import org.litote.kmongo.coroutine.CoroutineClient
import org.litote.kmongo.coroutine.CoroutineCollection
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

class DatabaseImpl(private val databaseConfig: DatabaseConfig) : Database {

    override val dbName: String
        get() = databaseConfig.databaseName

    override val mongoClient: CoroutineClient
        get() = KMongo.createClient().coroutine

    override val database: CoroutineDatabase
        get() = mongoClient.getDatabase(databaseConfig.databaseName)

    override val treasuresCollection: CoroutineCollection<TreasureItem>
        get() = database.getCollection("Treasures")

    override val gearScoreCollection: CoroutineCollection<GearScoreItem>
        get() = database.getCollection("Gear Score")
}