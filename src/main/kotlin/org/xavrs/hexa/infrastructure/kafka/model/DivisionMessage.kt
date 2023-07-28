package org.xavrs.hexa.infrastructure.kafka.model

import org.apache.avro.generic.GenericRecord
import org.xavrs.hexa.domain.Division
import org.xavrs.hexa.infrastructure.InfraModel

data class DivisionMessage(
    val code: String,
    val description: String
) : InfraModel<Division> {
    constructor(division: Division) : this(division.code, division.description.toString())

    constructor(record: GenericRecord) : this(
        code = record["code"].toString(),
        description = record["description"].toString()
    )

    override fun toDomainModel(): Division {
        return Division.Builder(
            code = this.code,
            description = this.description
        ).build()
    }
}
