package com.layzen.features.ancient_anvil.controller

import com.layzen.core.BaseResponse
import com.layzen.core.Request
import com.layzen.core.error_handler.MissingRequestBodyException
import com.layzen.features.ancient_anvil.AncientAnvilItem
import com.layzen.features.ancient_anvil.repository.AncientAnvilRepository
import com.layzen.util.acceptOrThrowException
import io.ktor.server.application.call

class AncientAnvilControllerImpl(
    private val ancientAnvilRepository: AncientAnvilRepository
) : AncientAnvilController {

    override suspend fun getAllAncientAnvilItems(request: Request): BaseResponse<Any> {
        return ancientAnvilRepository.getAllAncientAnvilItems()
    }

    override suspend fun getAncientAnvilByGroup(request: Request): BaseResponse<Any> {
        val group = request.call.parameters["group"]
        if (!group.isNullOrBlank()) {
            return ancientAnvilRepository.getAncientAnvilByGroup(enumValueOf(group))
        } else throw MissingRequestBodyException("Invalid gear score id")
    }

    override suspend fun addAncientAnvilItem(request: Request): BaseResponse<Any> {
        val ancientAnvilItem = request.call.acceptOrThrowException<AncientAnvilItem>("Ancient anvil item body required")
        return ancientAnvilRepository.addAncientAnvilItem(ancientAnvilItem)
    }
}