package com.layzen.features.alchemy

import com.layzen.features.alchemy.controller.AlchemyController
import com.layzen.features.alchemy.controller.AlchemyControllerImpl
import com.layzen.features.alchemy.repository.AlchemyRepository
import com.layzen.features.alchemy.repository.AlchemyRepositoryImpl
import com.layzen.features.alchemy.service.AlchemyService
import com.layzen.features.alchemy.service.AlchemyServiceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val moduleAlchemy = module {
    singleOf(::AlchemyControllerImpl) bind AlchemyController::class
    singleOf(::AlchemyRepositoryImpl) bind AlchemyRepository::class
    singleOf(::AlchemyServiceImpl) bind AlchemyService::class
}