package org.xavrs.hexa.infrastructure.db.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.xavrs.hexa.infrastructure.db.model.DivisionModel

@Repository
interface DivisionRepository : JpaRepository<DivisionModel, String>
