package com.presentation

import com.application.ExampleService
import com.configuration.ThreadPoolComponent
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.buildAndAwait

@Component
class ExampleHandler(
    private val threadPoolComponent: ThreadPoolComponent,
    private val exampleService: ExampleService,
) {
    suspend fun getExample(request: ServerRequest): ServerResponse {
        return withContext(threadPoolComponent.dispatcherWithThreads) {
            ServerResponse.ok().bodyValueAndAwait("test")
        }
    }

    suspend fun createExample(request: ServerRequest): ServerResponse {
        return withContext(threadPoolComponent.dispatcherWithThreads) {
            ServerResponse.noContent().buildAndAwait()
        }
    }
}