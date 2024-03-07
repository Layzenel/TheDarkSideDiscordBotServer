package com.layzen.features.crowns.service

import com.layzen.core.db.Database
import com.layzen.core.db.models.CrownItemDto
import org.litote.kmongo.coroutine.aggregate
import org.litote.kmongo.descending
import org.litote.kmongo.sort

class CrownsServiceImpl(
    private val database: Database
) : CrownsService {

    override suspend fun getAllCrownItems(): List<CrownItemDto> {
        return database.collectionCrowns.aggregate<CrownItemDto>(
            sort(descending(CrownItemDto::crownsCount))
        ).toList()
    }

    override suspend fun addCrownItem(crownItem: CrownItemDto): Boolean {
        return database.collectionCrowns.insertOne(crownItem).wasAcknowledged()
    }
}