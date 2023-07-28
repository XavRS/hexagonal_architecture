package org.xavrs.hexa.application.port.input

import org.xavrs.hexa.domain.Division

interface GetAllDivisionsUseCase {
    suspend operator fun invoke(): List<Division>
}
