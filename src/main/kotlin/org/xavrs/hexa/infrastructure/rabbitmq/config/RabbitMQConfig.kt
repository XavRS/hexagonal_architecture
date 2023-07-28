package org.xavrs.hexa.infrastructure.rabbitmq.config

import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Declarables
import org.springframework.amqp.core.DirectExchange
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.QueueBuilder
import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableRabbit
class RabbitMQConfig {

    @Bean
    fun converter(): Jackson2JsonMessageConverter {
        return Jackson2JsonMessageConverter()
    }

    @Bean
    fun topicBindings(
        @Value("\${event_deleted_queue}") queueName: String,
        @Value("\${event_deleted_queue_dlq}") dlqName: String
    ): Declarables {
        val topicExchange = DirectExchange("hexa")
        val dlqExchange = DirectExchange("hexa.dlq")
        val dqlQueue = Queue(dlqName)
        val queue = QueueBuilder.durable(queueName)
            .withArgument("x-dead-letter-exchange", dlqExchange.name)
            .withArgument("x-dead-letter-routing-key", "event_deleted.dlq")
            .build()

        return Declarables(
            queue,
            dqlQueue,
            topicExchange,
            dlqExchange,
            BindingBuilder
                .bind(queue)
                .to(topicExchange).with("event_deleted.event"),
            BindingBuilder
                .bind(dqlQueue)
                .to(dlqExchange).with("event_deleted.dlq")
        )
    }
}
