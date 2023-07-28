package org.xavrs.hexa.infrastructure.kafka.config

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class StreamConfig {
    @Bean
    fun schemaRegistry(
        @Value("\${spring.kafka.properties.schema.registry.url}") schemaRegistryUrl: String,
        @Value("\${spring.kafka.properties.basic.auth.credentials.source}") credentialsSource: String,
        @Value("\${spring.kafka.properties.basic.auth.user.info}") userInfo: String
    ): Map<String, String> = mapOf(
        Pair("schema.registry.url", schemaRegistryUrl),
        Pair("basic.auth.credentials.source", credentialsSource),
        Pair("basic.auth.user.info", userInfo)
    )

    @Bean
    fun divisionMasterTopic(
        @Value("\${division_topic}") topic: String
    ): NewTopic {
        return TopicBuilder.name(topic)
            .build()
    }
}
