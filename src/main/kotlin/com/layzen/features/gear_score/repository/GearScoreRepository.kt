package com.layzen.features.gear_score.repository

import com.layzen.core.BaseResponse
import com.layzen.features.gear_score.GearScoreItem

interface GearScoreRepository {

    suspend fun getAllGearScoreItems(): BaseResponse<Any>

    suspend fun addGearScoreItem(gearScoreItem: GearScoreItem): BaseResponse<Any>

    suspend fun updateGearScoreItem(gearScoreId: String, gearScoreItem: GearScoreItem): BaseResponse<Any>

    suspend fun deleteGearScoreItem(gearScoreId: String): BaseResponse<Any>
}