package org.xavrs.hexa.application.port.input

import org.xavrs.hexa.domain.Division

interface SaveDivisionUseCase {
    suspend operator fun invoke(division: Division)
}
