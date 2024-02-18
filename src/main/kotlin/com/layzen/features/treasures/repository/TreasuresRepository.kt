package com.layzen.features.treasures.repository

import com.layzen.core.BaseResponse
import com.layzen.features.treasures.TreasureItem

interface TreasuresRepository {

    suspend fun getAllTreasureItems(): BaseResponse<Any>

    suspend fun getTreasureItemById(treasureId: String): BaseResponse<Any>

    suspend fun addTreasureItem(treasureItem: TreasureItem): BaseResponse<Any>
}