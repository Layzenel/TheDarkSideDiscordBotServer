package com.layzen.features.crowns.controller

import com.layzen.core.BaseResponse
import com.layzen.core.Request

interface CrownsController {

    suspend fun getAllCrownItems(request: Request): BaseResponse<Any>

    suspend fun addCrownItem(request: Request): BaseResponse<Any>
}