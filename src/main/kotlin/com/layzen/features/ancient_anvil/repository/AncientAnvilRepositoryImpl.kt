package com.layzen.features.ancient_anvil.repository

import com.layzen.core.BaseResponse
import com.layzen.core.db.models.toDto
import com.layzen.core.db.models.toModel
import com.layzen.core.error_handler.ExceptionHandler
import com.layzen.features.ancient_anvil.AncientAnvilGroup
import com.layzen.features.ancient_anvil.AncientAnvilItem
import com.layzen.features.ancient_anvil.service.AncientAnvilService
import io.ktor.http.HttpStatusCode

class AncientAnvilRepositoryImpl(
    private val ancientAnvilService: AncientAnvilService,
    private val exceptionHandler: ExceptionHandler
) : AncientAnvilRepository {

    override suspend fun getAllAncientAnvilItems(): BaseResponse<Any> {
        val ancientAnvilItems = ancientAnvilService.getAllAncientAnvilItems().map { it.toModel() }
        return BaseResponse.SuccessResponse(statusCode = HttpStatusCode.OK, data = ancientAnvilItems)
    }

    override suspend fun getAncientAnvilByGroup(group: AncientAnvilGroup): BaseResponse<Any> {
        val ancientAnvilItem = ancientAnvilService.getAncientAnvilByGroup(group.toDto())?.toModel()
        if (ancientAnvilItem != null) {
            return BaseResponse.SuccessResponse(statusCode = HttpStatusCode.OK, data = ancientAnvilItem)
        } else throw exceptionHandler.respondNotFoundException("Ancient Anvil Item not found")
    }

    override suspend fun addAncientAnvilItem(ancientAnvilItem: AncientAnvilItem): BaseResponse<Any> {
        if (ancientAnvilService.addAncientAnvilItem(ancientAnvilItem.toDto())) {
            return BaseResponse.SuccessResponse(statusCode = HttpStatusCode.OK, data = true)
        } else throw exceptionHandler.respondGenericException()
    }
}