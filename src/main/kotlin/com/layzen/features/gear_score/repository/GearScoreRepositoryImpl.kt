package com.layzen.features.gear_score.repository

import com.layzen.core.BaseResponse
import com.layzen.core.db.models.toDto
import com.layzen.core.db.models.toModel
import com.layzen.core.error_handler.ExceptionHandler
import com.layzen.features.gear_score.GearScoreItem
import com.layzen.features.gear_score.service.GearScoreService
import io.ktor.http.HttpStatusCode

class GearScoreRepositoryImpl(
    private val gearScoreService: GearScoreService,
    private val exceptionHandler: ExceptionHandler
) : GearScoreRepository {

    override suspend fun getAllGearScoreItems(): BaseResponse<Any> {
        val gearScoreItems = gearScoreService.getAllGearScoreItems().map { it.toModel() }
        return BaseResponse.SuccessResponse(statusCode = HttpStatusCode.OK, data = gearScoreItems)
    }

    override suspend fun addGearScoreItem(gearScoreItem: GearScoreItem): BaseResponse<Any> {
        if (gearScoreService.addGearScoreItem(gearScoreItem.toDto())) {
            return BaseResponse.SuccessResponse(statusCode = HttpStatusCode.OK, data = true)
        } else throw exceptionHandler.respondGenericException()
    }

    override suspend fun updateGearScoreItem(gearScoreId: String, gearScoreItem: GearScoreItem): BaseResponse<Any> {
        if (gearScoreService.updateGearScoreItem(gearScoreId, gearScoreItem.toDto())) {
            return BaseResponse.SuccessResponse(statusCode = HttpStatusCode.OK, data = true)
        } else throw exceptionHandler.respondNotFoundException("Gear score item not found")
    }

    override suspend fun deleteGearScoreItem(gearScoreId: String): BaseResponse<Any> {
        if (isGearScoreItemExist(gearScoreId)) {
            if (gearScoreService.deleteGearScoreItem(gearScoreId)) {
                return BaseResponse.SuccessResponse(statusCode = HttpStatusCode.OK, data = true)
            } else throw exceptionHandler.respondGenericException()
        } else throw exceptionHandler.respondNotFoundException("Gear score item not found")
    }

    private suspend fun isGearScoreItemExist(gearScoreId: String): Boolean {
        return gearScoreService.getGearScoreItemById(gearScoreId) != null
    }
}