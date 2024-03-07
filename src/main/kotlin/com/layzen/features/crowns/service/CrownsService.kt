package com.layzen.features.crowns.service

import com.layzen.core.db.models.CrownItemDto

interface CrownsService {

    suspend fun getAllCrownItems(): List<CrownItemDto>

    suspend fun addCrownItem(crownItem: CrownItemDto): Boolean
}