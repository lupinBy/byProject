package com.presentation

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class ExampleRouter(
    private val exampleHandler: ExampleHandler,
) {
    @Bean
    fun exampleRouter(): RouterFunction<ServerResponse> = coRouter {
        (accept(MediaType.APPLICATION_JSON) and "/example").nest {
            GET("", exampleHandler::getExample)
            POST("", exampleHandler::createExample)
        }
    }
}