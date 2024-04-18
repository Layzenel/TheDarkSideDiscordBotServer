package com.layzen.features.ancient_anvil.repository

import com.layzen.core.BaseResponse
import com.layzen.features.ancient_anvil.AncientAnvilGroup
import com.layzen.features.ancient_anvil.AncientAnvilItem

interface AncientAnvilRepository {

    suspend fun getAllAncientAnvilItems(): BaseResponse<Any>

    suspend fun getAncientAnvilByGroup(group: AncientAnvilGroup): BaseResponse<Any>

    suspend fun addAncientAnvilItem(ancientAnvilItem: AncientAnvilItem): BaseResponse<Any>
}