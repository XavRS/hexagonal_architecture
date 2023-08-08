package org.xavrs.hexa.application.service

import org.xavrs.hexa.domain.Division

interface DivisionService {
    suspend fun getAllDivisions(): List<Division>
    suspend fun add(division: Division)
}
