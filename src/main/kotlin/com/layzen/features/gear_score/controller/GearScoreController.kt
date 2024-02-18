package com.layzen.features.gear_score.controller

import com.layzen.core.BaseResponse
import com.layzen.core.Request
import com.layzen.features.gear_score.DeleteGearScoreItem

interface GearScoreController {

    suspend fun getAllGearScoreItems(request: Request): BaseResponse<Any>

    suspend fun addGearScoreItem(request: Request): BaseResponse<Any>

    suspend fun updateGearScoreItem(request: Request): BaseResponse<Any>

    suspend fun deleteGearScoreItem(request: DeleteGearScoreItem?): BaseResponse<Any>
}