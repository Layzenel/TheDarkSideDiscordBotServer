package com.layzen.features.crowns.controller

import com.layzen.core.BaseResponse
import com.layzen.core.Request
import com.layzen.features.crowns.CrownItem
import com.layzen.features.crowns.repository.CrownsRepository
import com.layzen.util.acceptOrThrowException
import io.ktor.server.application.call

class CrownsControllerImpl(
    private val crownsRepository: CrownsRepository
) : CrownsController {

    override suspend fun getAllCrownItems(request: Request): BaseResponse<Any> {
        return crownsRepository.getAllCrownItems()
    }

    override suspend fun addCrownItem(request: Request): BaseResponse<Any> {
        val crownItem = request.call.acceptOrThrowException<CrownItem>("Crown item body required")
        return crownsRepository.addCrownItem(crownItem)
    }
}