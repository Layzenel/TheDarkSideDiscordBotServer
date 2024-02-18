package com.layzen.features.treasures.repository

import com.layzen.core.BaseResponse
import com.layzen.core.error_handler.ExceptionHandler
import com.layzen.features.treasures.TreasureItem
import com.layzen.features.treasures.service.TreasuresService
import io.ktor.http.HttpStatusCode

class TreasuresRepositoryImpl(
    private val treasuresService: TreasuresService,
    private val exceptionHandler: ExceptionHandler
) : TreasuresRepository {

    override suspend fun getAllTreasureItems(): BaseResponse<Any> {
        val treasureItems = treasuresService.getAllTreasureItems()
        return BaseResponse.SuccessResponse(statusCode = HttpStatusCode.OK, data = treasureItems)
    }

    override suspend fun getTreasureItemById(treasureId: String): BaseResponse<Any> {
        val treasureItem = treasuresService.getTreasureItemById(treasureId)
        if (treasureItem != null) {
            return BaseResponse.SuccessResponse(statusCode = HttpStatusCode.OK, data = treasureItem)
        } else throw exceptionHandler.respondNotFoundException("Treasure not exists")
    }

    override suspend fun addTreasureItem(treasureItem: TreasureItem): BaseResponse<Any> {
        if (treasuresService.addTreasureItem(treasureItem)) {
            return BaseResponse.SuccessResponse(statusCode = HttpStatusCode.OK, data = treasureItem)
        } else throw exceptionHandler.respondGenericException()
    }
}