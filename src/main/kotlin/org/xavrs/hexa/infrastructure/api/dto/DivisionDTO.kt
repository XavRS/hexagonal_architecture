package org.xavrs.hexa.infrastructure.api.dto

import org.xavrs.hexa.domain.Division
import org.xavrs.hexa.infrastructure.InfraModel

data class DivisionDTO(
    val code: String,
    val description: String
) : InfraModel<Division> {
    constructor(division: Division) :
        this(division.code, division.description.toString())

    override fun toDomainModel(): Division {
        return Division.Builder(
            code = this.code,
            description = this.description
        ).build()
    }
}
