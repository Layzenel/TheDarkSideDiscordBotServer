package com.layzen.features.gear_score.service

import com.layzen.core.db.Database
import com.layzen.core.db.models.GearScoreItemDto
import org.bson.types.ObjectId
import org.litote.kmongo.coroutine.aggregate
import org.litote.kmongo.descending
import org.litote.kmongo.sort

class GearScoreServiceImpl(
    private val database: Database
) : GearScoreService {

    override suspend fun getAllGearScoreItems(): List<GearScoreItemDto> {
        return database.collectionGearScore.aggregate<GearScoreItemDto>(
            sort(descending(GearScoreItemDto::gs))
        ).toList()
    }

    override suspend fun getGearScoreItemById(gearScoreId: String): GearScoreItemDto? {
        return database.collectionGearScore.findOneById(gearScoreId)
    }

    override suspend fun addGearScoreItem(gearScoreItem: GearScoreItemDto): Boolean {
        return database.collectionGearScore.insertOne(gearScoreItem).wasAcknowledged()
    }

    override suspend fun updateGearScoreItem(gearScoreId: String, gearScoreItem: GearScoreItemDto): Boolean {
        return database.collectionGearScore.updateOneById(
            id = ObjectId(gearScoreId),
            update = gearScoreItem,
            updateOnlyNotNullProperties = true
        ).wasAcknowledged()
    }

    override suspend fun deleteGearScoreItem(gearScoreId: String): Boolean {
        return database.collectionGearScore.deleteOneById(gearScoreId).wasAcknowledged()
    }
}