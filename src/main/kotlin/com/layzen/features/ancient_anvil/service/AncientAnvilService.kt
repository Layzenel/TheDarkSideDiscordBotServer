package com.layzen.features.ancient_anvil.service

import com.layzen.core.db.models.AncientAnvilDto
import com.layzen.core.db.models.AncientAnvilGroupDto

interface AncientAnvilService {

    suspend fun getAllAncientAnvilItems(): List<AncientAnvilDto>

    suspend fun getAncientAnvilByGroup(group: AncientAnvilGroupDto): AncientAnvilDto?

    suspend fun addAncientAnvilItem(ancientAnvilItem: AncientAnvilDto): Boolean
}