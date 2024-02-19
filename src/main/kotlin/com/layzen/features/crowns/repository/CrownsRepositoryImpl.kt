package com.layzen.features.crowns.repository

import com.layzen.core.BaseResponse
import com.layzen.core.error_handler.ExceptionHandler
import com.layzen.features.crowns.CrownItem
import com.layzen.features.crowns.service.CrownsService
import io.ktor.http.HttpStatusCode

class CrownsRepositoryImpl(
    private val crownsService: CrownsService,
    private val exceptionHandler: ExceptionHandler
) : CrownsRepository {

    override suspend fun getAllCrownItems(): BaseResponse<Any> {
        val crownItems = crownsService.getAllCrownItems()
        return BaseResponse.SuccessResponse(statusCode = HttpStatusCode.OK, data = crownItems)
    }

    override suspend fun addCrownItem(crownItem: CrownItem): BaseResponse<Any> {
        if (crownsService.addCrownItem(crownItem)) {
            return BaseResponse.SuccessResponse(statusCode = HttpStatusCode.OK, data = true)
        } else throw exceptionHandler.respondGenericException()
    }
}