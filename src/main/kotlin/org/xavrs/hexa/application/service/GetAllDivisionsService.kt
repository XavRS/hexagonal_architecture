package org.xavrs.hexa.application.service

import org.springframework.stereotype.Service
import org.xavrs.hexa.application.port.input.GetAllDivisionsUseCase
import org.xavrs.hexa.application.port.output.DivisionPort
import org.xavrs.hexa.domain.Division

@Service
class GetAllDivisionsService(
    private val divisionPort: DivisionPort
) : GetAllDivisionsUseCase {
    override suspend fun invoke(): List<Division> {
        return divisionPort.getAllDivisions()
    }
}
