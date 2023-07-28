package org.xavrs.hexa.infrastructure.db.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.xavrs.hexa.domain.Division
import org.xavrs.hexa.infrastructure.InfraModel

@Entity
@Table(name = "divisions")
class DivisionModel() : InfraModel<Division> {
    @Id
    @Column(name = "ID")
    var code: String = ""

    @Column(name = "NAME")
    var description: String = ""

    constructor(division: Division) : this() {
        this.code = division.code
        this.description = division.description.toString()
    }

    override fun toDomainModel(): Division {
        return Division.Builder(
            code = this.code,
            description = this.description
        ).build()
    }
}
