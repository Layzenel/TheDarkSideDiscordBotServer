package com.layzen.features.treasures

import com.layzen.features.treasures.controller.TreasuresController
import com.layzen.features.treasures.controller.TreasuresControllerImpl
import com.layzen.features.treasures.repository.TreasuresRepository
import com.layzen.features.treasures.repository.TreasuresRepositoryImpl
import com.layzen.features.treasures.service.TreasuresService
import com.layzen.features.treasures.service.TreasuresServiceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val treasuresModule = module {
    singleOf(::TreasuresControllerImpl) bind TreasuresController::class
    singleOf(::TreasuresRepositoryImpl) bind TreasuresRepository::class
    singleOf(::TreasuresServiceImpl) bind TreasuresService::class
}
