package com.layzen.features.gear_score.service

import com.layzen.core.db.Database
import com.layzen.features.gear_score.GearScoreItem
import org.litote.kmongo.coroutine.aggregate
import org.litote.kmongo.descending
import org.litote.kmongo.sort

class GearScoreServiceImpl(
    private val database: Database
) : GearScoreService {

    override suspend fun getAllGearScoreItems(): List<GearScoreItem> {
        return database.gearScoreCollection.aggregate<GearScoreItem>(
            sort(descending(GearScoreItem::gs))
        ).toList()
    }

    override suspend fun getGearScoreItemById(gearScoreId: String): GearScoreItem? {
        return database.gearScoreCollection.findOneById(gearScoreId)
    }

    override suspend fun addGearScoreItem(gearScoreItem: GearScoreItem): Boolean {
        return database.gearScoreCollection.insertOne(gearScoreItem).wasAcknowledged()
    }

    override suspend fun updateGearScoreItem(gearScoreId: String, gearScoreItem: GearScoreItem): Boolean {
        return database.gearScoreCollection.updateOneById(
            id = gearScoreId,
            update = gearScoreItem,
            updateOnlyNotNullProperties = true
        ).wasAcknowledged()
    }

    override suspend fun deleteGearScoreItem(gearScoreId: String): Boolean {
        return database.gearScoreCollection.deleteOneById(gearScoreId).wasAcknowledged()
    }
}