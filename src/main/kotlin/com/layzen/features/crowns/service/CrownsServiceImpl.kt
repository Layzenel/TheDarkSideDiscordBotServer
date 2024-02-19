package com.layzen.features.crowns.service

import com.layzen.core.db.Database
import com.layzen.features.crowns.CrownItem
import org.litote.kmongo.coroutine.aggregate
import org.litote.kmongo.descending
import org.litote.kmongo.sort

class CrownsServiceImpl(
    private val database: Database
) : CrownsService {

    override suspend fun getAllCrownItems(): List<CrownItem> {
        return database.crownsCollection.aggregate<CrownItem>(
            sort(descending(CrownItem::crownsCount))
        ).toList()
    }

    override suspend fun addCrownItem(crownItem: CrownItem): Boolean {
        return database.crownsCollection.insertOne(crownItem).wasAcknowledged()
    }
}