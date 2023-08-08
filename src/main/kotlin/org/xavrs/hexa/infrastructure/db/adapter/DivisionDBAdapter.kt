package org.xavrs.hexa.infrastructure.db.adapter

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Component
import org.xavrs.hexa.application.service.DivisionService
import org.xavrs.hexa.domain.Division
import org.xavrs.hexa.infrastructure.db.model.DivisionModel
import org.xavrs.hexa.infrastructure.db.repository.DivisionRepository

@Component
class DivisionDBAdapter(
    private val divisionRepository: DivisionRepository
) : DivisionService {
    override suspend fun getAllDivisions() = withContext(Dispatchers.IO) {
        divisionRepository.findAll().toList().map { it.toDomainModel() }
    }

    override suspend fun add(division: Division) {
        withContext(Dispatchers.IO) {
            divisionRepository.save(DivisionModel(division))
        }
    }
}
