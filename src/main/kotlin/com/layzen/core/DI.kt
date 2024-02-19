package com.layzen.core

import com.layzen.core.db.Database
import com.layzen.core.db.DatabaseImpl
import com.layzen.core.db.config.DatabaseConfig
import com.layzen.core.db.config.DatabaseConfigImpl
import com.layzen.core.error_handler.ExceptionHandler
import com.layzen.core.error_handler.ExceptionHandlerImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val moduleCore = module {
    singleOf(::DatabaseImpl) bind Database::class
    singleOf(::DatabaseConfigImpl) bind DatabaseConfig::class
    singleOf(::ExceptionHandlerImpl) bind ExceptionHandler::class
}