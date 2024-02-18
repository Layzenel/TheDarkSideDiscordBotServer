package com.layzen.features.gear_score.controller

import com.layzen.core.BaseResponse
import com.layzen.core.Request
import com.layzen.core.error_handler.MissingRequestBodyException
import com.layzen.features.gear_score.DeleteGearScoreItem
import com.layzen.features.gear_score.GearScoreItem
import com.layzen.features.gear_score.repository.GearScoreRepository
import com.layzen.util.acceptOrThrowException
import io.ktor.server.application.call

class GearScoreControllerImpl(
    private val gearScoreRepository: GearScoreRepository
) : GearScoreController {

    override suspend fun getAllGearScoreItems(request: Request): BaseResponse<Any> {
        return gearScoreRepository.getAllGearScoreItems()
    }

    override suspend fun addGearScoreItem(request: Request): BaseResponse<Any> {
        val gearScoreItem = request.call.acceptOrThrowException<GearScoreItem>("Gear score item body required")
        return gearScoreRepository.addGearScoreItem(gearScoreItem)
    }

    override suspend fun updateGearScoreItem(request: Request): BaseResponse<Any> {
        val gearScoreItemId = request.call.parameters["gearScoreItemId"]
        val gearScoreItem = request.call.acceptOrThrowException<GearScoreItem>("Gear score item body required")
        if (!gearScoreItemId.isNullOrBlank()) {
            return gearScoreRepository.updateGearScoreItem(gearScoreItemId, gearScoreItem)
        } else throw MissingRequestBodyException("Invalid gear score id")
    }

    override suspend fun deleteGearScoreItem(request: DeleteGearScoreItem?): BaseResponse<Any> {
        if (request != null && (request.gearScoreItemId?.isBlank() == false)) {
            return gearScoreRepository.deleteGearScoreItem(request.gearScoreItemId)
        } else throw MissingRequestBodyException("Invalid gear score id")
    }
}