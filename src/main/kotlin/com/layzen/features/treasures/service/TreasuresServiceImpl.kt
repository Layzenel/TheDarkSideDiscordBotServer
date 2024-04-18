package com.layzen.features.treasures.service

import com.layzen.core.db.Database
import com.layzen.core.db.models.TreasureItemDto
import com.mongodb.client.model.Aggregates.sort
import org.bson.types.ObjectId
import org.litote.kmongo.coroutine.aggregate
import org.litote.kmongo.descending

class TreasuresServiceImpl(
    private val database: Database
) : TreasuresService {

    override suspend fun getAllTreasureItems(): List<TreasureItemDto> {
        return database.collectionTreasures.aggregate<TreasureItemDto>(
            sort(descending(TreasureItemDto::name))
        ).toList()
    }

    override suspend fun getTreasureItemById(treasureId: String): TreasureItemDto? {
        return database.collectionTreasures.findOneById(ObjectId(treasureId))
    }

    override suspend fun addTreasureItem(treasureItem: TreasureItemDto): Boolean {
        return database.collectionTreasures.insertOne(treasureItem).wasAcknowledged()
    }
}