package com.layzen.features.ancient_anvil.service

import com.layzen.core.db.Database
import com.layzen.core.db.models.AncientAnvilDto
import com.layzen.core.db.models.AncientAnvilGroupDto
import com.mongodb.client.model.Filters
import org.litote.kmongo.coroutine.aggregate
import org.litote.kmongo.descending
import org.litote.kmongo.sort

class AncientAnvilServiceImpl(
    private val database: Database
) : AncientAnvilService {

    override suspend fun getAllAncientAnvilItems(): List<AncientAnvilDto> {
        return database.collectionAncientAnvil.aggregate<AncientAnvilDto>(
            sort(descending(AncientAnvilDto::ancientAnvilId))
        ).toList()
    }

    override suspend fun getAncientAnvilByGroup(group: AncientAnvilGroupDto): AncientAnvilDto? {
        return database.collectionAncientAnvil.findOne(Filters.eq(AncientAnvilDto::group.name, group))
    }

    override suspend fun addAncientAnvilItem(ancientAnvilItem: AncientAnvilDto): Boolean {
        return database.collectionAncientAnvil.insertOne(ancientAnvilItem).wasAcknowledged()
    }
}