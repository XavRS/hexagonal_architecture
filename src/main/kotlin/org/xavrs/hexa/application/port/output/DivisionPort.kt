package org.xavrs.hexa.application.port.output

import org.xavrs.hexa.domain.Division

interface DivisionPort {
    suspend fun getAllDivisions(): List<Division>
    suspend fun add(division: Division)
}
