package com.layzen.features.alchemy.controller

import com.layzen.core.BaseResponse
import com.layzen.core.Request

interface AlchemyController {

    suspend fun getAllAlchemyItems(request: Request): BaseResponse<Any>

    suspend fun addAlchemyItem(request: Request): BaseResponse<Any>
}