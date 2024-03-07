package com.layzen.features.alchemy.repository

import com.layzen.core.BaseResponse
import com.layzen.features.alchemy.AlchemyItem

interface AlchemyRepository {

    suspend fun getAllAlchemyItems(): BaseResponse<Any>

    suspend fun addAlchemyItem(alchemyItem: AlchemyItem): BaseResponse<Any>
}