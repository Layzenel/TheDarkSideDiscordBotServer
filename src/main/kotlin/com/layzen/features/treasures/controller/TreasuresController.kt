package com.layzen.features.treasures.controller

import com.layzen.core.BaseResponse
import com.layzen.core.Request
import com.layzen.features.treasures.SingleTreasureItem

interface TreasuresController {

    suspend fun getAllTreasureItems(request: Request): BaseResponse<Any>

    suspend fun getTreasureItemById(request: SingleTreasureItem?): BaseResponse<Any>

    suspend fun addTreasureItem(request: Request): BaseResponse<Any>
}