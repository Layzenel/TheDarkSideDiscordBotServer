package com.layzen.features.treasures.service

import com.layzen.core.db.Database
import com.layzen.features.treasures.TreasureItem
import com.mongodb.client.model.Aggregates.sort
import org.litote.kmongo.coroutine.aggregate
import org.litote.kmongo.descending

class TreasuresServiceImpl(
    private val database: Database
) : TreasuresService {

    override suspend fun getAllTreasureItems(): List<TreasureItem> {
        return database.treasuresCollection.aggregate<TreasureItem>(
            sort(descending(TreasureItem::name))
        ).toList()
    }

    override suspend fun getTreasureItemById(treasureId: String): TreasureItem? {
        return database.treasuresCollection.findOneById(treasureId)
    }

    override suspend fun addTreasureItem(treasureItem: TreasureItem): Boolean {
        return database.treasuresCollection.insertOne(treasureItem).wasAcknowledged()
    }
}