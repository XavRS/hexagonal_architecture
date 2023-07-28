package org.xavrs.hexa.infrastructure.kafka.consumer

import kotlinx.coroutines.runBlocking
import org.apache.avro.generic.GenericRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component
import org.xavrs.hexa.application.port.input.SaveDivisionUseCase
import org.xavrs.hexa.infrastructure.kafka.model.DivisionMessage

@Component
class DivisionListener(
    private val saveDivisionUseCase: SaveDivisionUseCase
) {

    @KafkaListener(
        topics = ["\${division_topic}"],
        properties = [("auto.offset.reset=earliest")]
    )
    fun listen(@Payload record: GenericRecord) {
        val divisionMessage = DivisionMessage(record)
        runBlocking {
            saveDivisionUseCase(divisionMessage.toDomainModel())
        }
    }
}
