package org.xavrs.hexa.infrastructure.api.handler

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.awaitBody
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.json
import org.xavrs.hexa.application.port.input.GetAllDivisionsUseCase
import org.xavrs.hexa.application.port.input.SaveDivisionUseCase
import org.xavrs.hexa.infrastructure.api.dto.DivisionDTO

@Component
class DivisionHandler(
    val getAllDivisionsUseCase: GetAllDivisionsUseCase,
    val saveDivisionUseCase: SaveDivisionUseCase
) {
    suspend fun getAll(request: ServerRequest): ServerResponse {
        return ServerResponse.ok().json().bodyValueAndAwait(
            getAllDivisionsUseCase()
        )
    }

    suspend fun add(request: ServerRequest): ServerResponse {
        val divisionDTO = request.awaitBody(DivisionDTO::class)
        saveDivisionUseCase(divisionDTO.toDomainModel())
        return ServerResponse.ok().json().bodyValueAndAwait(
            getAllDivisionsUseCase()
        )
    }
}
