package com.layzen.core

import io.ktor.server.application.ApplicationCall
import io.ktor.util.pipeline.PipelineContext

typealias Request = PipelineContext<Unit, ApplicationCall>