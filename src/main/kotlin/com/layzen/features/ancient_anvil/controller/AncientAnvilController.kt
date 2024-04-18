package com.layzen.features.ancient_anvil.controller

import com.layzen.core.BaseResponse
import com.layzen.core.Request

interface AncientAnvilController {

    suspend fun getAllAncientAnvilItems(request: Request): BaseResponse<Any>

    suspend fun getAncientAnvilByGroup(request: Request): BaseResponse<Any>

    suspend fun addAncientAnvilItem(request: Request): BaseResponse<Any>
}