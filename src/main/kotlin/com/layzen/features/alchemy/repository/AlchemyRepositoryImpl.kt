package com.layzen.features.alchemy.repository

import com.layzen.core.BaseResponse
import com.layzen.core.db.models.toDto
import com.layzen.core.db.models.toModel
import com.layzen.core.error_handler.ExceptionHandler
import com.layzen.features.alchemy.AlchemyItem
import com.layzen.features.alchemy.service.AlchemyService
import io.ktor.http.HttpStatusCode

class AlchemyRepositoryImpl(
    private val alchemyService: AlchemyService,
    private val exceptionHandler: ExceptionHandler
) : AlchemyRepository {

    override suspend fun getAllAlchemyItems(): BaseResponse<Any> {
        val alchemyItems = alchemyService.getAllAlchemyItems().map { it.toModel() }
        return BaseResponse.SuccessResponse(statusCode = HttpStatusCode.OK, data = alchemyItems)
    }

    override suspend fun addAlchemyItem(alchemyItem: AlchemyItem): BaseResponse<Any> {
        if (alchemyService.addAlchemyItem(alchemyItem.toDto())) {
            return BaseResponse.SuccessResponse(statusCode = HttpStatusCode.OK, data = true)
        } else throw exceptionHandler.respondGenericException()
    }
}