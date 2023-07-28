package org.xavrs.hexa.infrastructure

import org.xavrs.hexa.domain.DomainModel

interface InfraModel<T : DomainModel> {
    fun toDomainModel(): T
}
