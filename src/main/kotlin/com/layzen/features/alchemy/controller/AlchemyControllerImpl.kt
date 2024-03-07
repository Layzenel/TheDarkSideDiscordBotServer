package com.layzen.features.alchemy.controller

import com.layzen.core.BaseResponse
import com.layzen.core.Request
import com.layzen.features.alchemy.AlchemyItem
import com.layzen.features.alchemy.repository.AlchemyRepository
import com.layzen.util.acceptOrThrowException
import io.ktor.server.application.call

class AlchemyControllerImpl(
    private val alchemyRepository: AlchemyRepository
) : AlchemyController {

    override suspend fun getAllAlchemyItems(request: Request): BaseResponse<Any> {
        return alchemyRepository.getAllAlchemyItems()
    }

    override suspend fun addAlchemyItem(request: Request): BaseResponse<Any> {
        val alchemyItem = request.call.acceptOrThrowException<AlchemyItem>("Crown item body required")
        return alchemyRepository.addAlchemyItem(alchemyItem)
    }
}