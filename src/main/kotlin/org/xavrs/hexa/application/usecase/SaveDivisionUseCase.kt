package org.xavrs.hexa.application.usecase

import org.springframework.stereotype.Service
import org.xavrs.hexa.application.service.DivisionService
import org.xavrs.hexa.domain.Division

@Service
class SaveDivisionUseCase(
    private val divisionService: DivisionService
) {

    suspend operator fun invoke(division: Division) {
        divisionService.add(division)
    }
}
