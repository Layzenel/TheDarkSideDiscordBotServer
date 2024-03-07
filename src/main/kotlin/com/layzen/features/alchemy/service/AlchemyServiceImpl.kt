package com.layzen.features.alchemy.service

import com.layzen.core.db.Database
import com.layzen.core.db.models.AlchemyItemDto
import org.litote.kmongo.coroutine.aggregate
import org.litote.kmongo.descending
import org.litote.kmongo.sort

class AlchemyServiceImpl(
    private val database: Database
) : AlchemyService {

    override suspend fun getAllAlchemyItems(): List<AlchemyItemDto> {
        return database.collectionAlchemy.aggregate<AlchemyItemDto>(
            sort(descending(AlchemyItemDto::name))
        ).toList()
    }

    override suspend fun addAlchemyItem(alchemyItem: AlchemyItemDto): Boolean {
        return database.collectionAlchemy.insertOne(alchemyItem).wasAcknowledged()
    }
}