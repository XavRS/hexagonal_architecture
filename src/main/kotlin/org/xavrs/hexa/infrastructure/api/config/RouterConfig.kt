package org.xavrs.hexa.infrastructure.api.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.coRouter
import org.xavrs.hexa.infrastructure.api.handler.DivisionHandler

@Configuration
class RouterConfig {
    @Bean
    fun divisionRouter(handler: DivisionHandler) = coRouter {
        "/api/division".nest {
            GET("", handler::getAll)
            POST("", handler::add)
        }
    }
}
