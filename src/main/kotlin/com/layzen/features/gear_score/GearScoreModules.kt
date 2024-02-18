package com.layzen.features.gear_score

import com.layzen.features.gear_score.controller.GearScoreController
import com.layzen.features.gear_score.controller.GearScoreControllerImpl
import com.layzen.features.gear_score.repository.GearScoreRepository
import com.layzen.features.gear_score.repository.GearScoreRepositoryImpl
import com.layzen.features.gear_score.service.GearScoreService
import com.layzen.features.gear_score.service.GearScoreServiceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val gearScoreModules = module {
    singleOf(::GearScoreControllerImpl) bind GearScoreController::class
    singleOf(::GearScoreRepositoryImpl) bind GearScoreRepository::class
    singleOf(::GearScoreServiceImpl) bind GearScoreService::class
}