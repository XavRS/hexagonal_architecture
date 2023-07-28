package org.xavrs.hexa.infrastructure.rabbitmq.event

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

data class DeletedEvent(
    @JsonProperty("idDivision")
    val idDivision: String,
    @JsonProperty("meta")
    private val meta: EventMetadata
) : Event(
    aggregateId = meta.aggregateId,
    correlationId = meta.correlationId,
    occurredOnString = meta.occurredOn
) {
    companion object {
        private const val serialVersionUID: Long = 1L
    }

    override fun toString(): String {
        return jacksonObjectMapper().writeValueAsString(this)
    }
}
