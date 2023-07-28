package org.xavrs.hexa.infrastructure.rabbitmq.event

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import java.io.Serializable
import java.time.LocalDateTime

abstract class Event(
    val aggregateId: String,
    val correlationId: String,
    occurredOnString: String
) : Serializable {
    @JsonSerialize(using = LocalDateTimeSerializer::class)
    val occurredOn = LocalDateTime.parse(occurredOnString)
    companion object {
        private const val serialVersionUID: Long = 1L
    }
}

data class EventMetadata(
    @JsonProperty("aggregateId")
    val aggregateId: String,
    @JsonProperty("occurredOn")
    val occurredOn: String,
    @JsonProperty("correlationId")
    val correlationId: String,
) : Serializable {
    companion object {
        private const val serialVersionUID: Long = 1L
    }
}
