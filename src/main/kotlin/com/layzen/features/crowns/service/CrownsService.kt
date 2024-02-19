package com.layzen.features.crowns.service

import com.layzen.features.crowns.CrownItem

interface CrownsService {

    suspend fun getAllCrownItems(): List<CrownItem>

    suspend fun addCrownItem(crownItem: CrownItem): Boolean
}