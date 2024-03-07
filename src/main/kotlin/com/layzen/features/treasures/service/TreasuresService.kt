package com.layzen.features.treasures.service

import com.layzen.core.db.models.TreasureItemDto

interface TreasuresService {

    suspend fun getAllTreasureItems(): List<TreasureItemDto>

    suspend fun getTreasureItemById(treasureId: String): TreasureItemDto?

    suspend fun addTreasureItem(treasureItem: TreasureItemDto): Boolean
}