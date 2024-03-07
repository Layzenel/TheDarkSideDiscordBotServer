package com.layzen.features.alchemy.service

import com.layzen.core.db.models.AlchemyItemDto

interface AlchemyService {

    suspend fun getAllAlchemyItems(): List<AlchemyItemDto>

    suspend fun addAlchemyItem(alchemyItem: AlchemyItemDto): Boolean
}