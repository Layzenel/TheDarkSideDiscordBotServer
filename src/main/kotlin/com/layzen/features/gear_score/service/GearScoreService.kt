package com.layzen.features.gear_score.service

import com.layzen.features.gear_score.GearScoreItem

interface GearScoreService {

    suspend fun getAllGearScoreItems(): List<GearScoreItem>

    suspend fun getGearScoreItemById(gearScoreId: String): GearScoreItem?

    suspend fun addGearScoreItem(gearScoreItem: GearScoreItem): Boolean

    suspend fun updateGearScoreItem(gearScoreId: String, gearScoreItem: GearScoreItem): Boolean

    suspend fun deleteGearScoreItem(gearScoreId: String): Boolean
}