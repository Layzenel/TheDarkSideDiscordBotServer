package com.layzen.features.treasures.controller

import com.layzen.core.BaseResponse
import com.layzen.core.Request
import com.layzen.core.error_handler.MissingRequestBodyException
import com.layzen.features.treasures.SingleTreasureItem
import com.layzen.features.treasures.TreasureItem
import com.layzen.features.treasures.repository.TreasuresRepository
import com.layzen.util.acceptOrThrowException
import io.ktor.server.application.call

class TreasuresControllerImpl(
    private val treasuresRepository: TreasuresRepository
) : TreasuresController {

    override suspend fun getAllTreasureItems(request: Request): BaseResponse<Any> {
        return treasuresRepository.getAllTreasureItems()
    }

    override suspend fun getTreasureItemById(request: SingleTreasureItem?): BaseResponse<Any> {
        if (request != null && (request.treasureId.isNotBlank())) {
            return treasuresRepository.getTreasureItemById(request.treasureId)
        } else throw MissingRequestBodyException("Invalid treasure id")
    }

    override suspend fun addTreasureItem(request: Request): BaseResponse<Any> {
        val treasureItem = request.call.acceptOrThrowException<TreasureItem>("Treasure item body required")
        return treasuresRepository.addTreasureItem(treasureItem)
    }
}