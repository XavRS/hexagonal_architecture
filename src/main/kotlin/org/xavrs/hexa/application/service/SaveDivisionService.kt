package org.xavrs.hexa.application.service

import org.springframework.stereotype.Service
import org.xavrs.hexa.application.port.input.SaveDivisionUseCase
import org.xavrs.hexa.application.port.output.DivisionPort
import org.xavrs.hexa.domain.Division

@Service
class SaveDivisionService(
    private val divisionPort: DivisionPort
) : SaveDivisionUseCase {

    override suspend fun invoke(division: Division) {
        divisionPort.add(division)
    }
}
