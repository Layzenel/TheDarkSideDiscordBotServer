package com.layzen.features.crowns.repository

import com.layzen.core.BaseResponse
import com.layzen.features.crowns.CrownItem

interface CrownsRepository {

    suspend fun getAllCrownItems(): BaseResponse<Any>

    suspend fun addCrownItem(crownItem: CrownItem): BaseResponse<Any>
}