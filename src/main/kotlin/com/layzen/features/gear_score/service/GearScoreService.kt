package com.layzen.features.gear_score.service

import com.layzen.core.db.models.GearScoreItemDto

interface GearScoreService {

    suspend fun getAllGearScoreItems(): List<GearScoreItemDto>

    suspend fun getGearScoreItemById(gearScoreId: String): GearScoreItemDto?

    suspend fun addGearScoreItem(gearScoreItem: GearScoreItemDto): Boolean

    suspend fun updateGearScoreItem(gearScoreId: String, gearScoreItem: GearScoreItemDto): Boolean

    suspend fun deleteGearScoreItem(gearScoreId: String): Boolean
}