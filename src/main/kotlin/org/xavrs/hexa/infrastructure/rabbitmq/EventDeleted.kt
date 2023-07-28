package org.xavrs.hexa.infrastructure.rabbitmq

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component
import org.xavrs.hexa.infrastructure.rabbitmq.event.DeletedEvent

@Component
class EventDeleted {

    @RabbitListener(queues = ["\${event_deleted_queue}"])
    fun eventDeletedMessage(@Payload message: DeletedEvent) {
        println("Received: ${message}")
    }
}
