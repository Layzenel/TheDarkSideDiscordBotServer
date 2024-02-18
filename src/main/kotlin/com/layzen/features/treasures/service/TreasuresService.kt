package com.layzen.features.treasures.service

import com.layzen.features.treasures.TreasureItem

interface TreasuresService {

    suspend fun getAllTreasureItems(): List<TreasureItem>

    suspend fun getTreasureItemById(treasureId: String): TreasureItem?

    suspend fun addTreasureItem(treasureItem: TreasureItem): Boolean
}