package com.layzen.features.ancient_anvil

import com.layzen.features.ancient_anvil.controller.AncientAnvilController
import com.layzen.features.ancient_anvil.controller.AncientAnvilControllerImpl
import com.layzen.features.ancient_anvil.repository.AncientAnvilRepository
import com.layzen.features.ancient_anvil.repository.AncientAnvilRepositoryImpl
import com.layzen.features.ancient_anvil.service.AncientAnvilService
import com.layzen.features.ancient_anvil.service.AncientAnvilServiceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val moduleAncientAnvil = module {
    singleOf(::AncientAnvilControllerImpl) bind AncientAnvilController::class
    singleOf(::AncientAnvilRepositoryImpl) bind AncientAnvilRepository::class
    singleOf(::AncientAnvilServiceImpl) bind AncientAnvilService::class
}