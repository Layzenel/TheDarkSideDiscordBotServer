package com.layzen.features.crowns

import com.layzen.features.crowns.controller.CrownsController
import com.layzen.features.crowns.controller.CrownsControllerImpl
import com.layzen.features.crowns.repository.CrownsRepository
import com.layzen.features.crowns.repository.CrownsRepositoryImpl
import com.layzen.features.crowns.service.CrownsService
import com.layzen.features.crowns.service.CrownsServiceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val moduleCrowns = module {
    singleOf(::CrownsControllerImpl) bind CrownsController::class
    singleOf(::CrownsRepositoryImpl) bind CrownsRepository::class
    singleOf(::CrownsServiceImpl) bind CrownsService::class
}