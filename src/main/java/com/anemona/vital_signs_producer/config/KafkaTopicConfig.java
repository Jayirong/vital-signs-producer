package com.anemona.vital_signs_producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

// se supone que aca creamos de forma automatica los topicos, para no estar haciendolos desde consola
@Configuration
public class KafkaTopicConfig {
    
    @Bean
    public NewTopic topicSenalesVitales() {
        return TopicBuilder.name("senales_vitales")
            .partitions(3)
            .replicas(3)
            .build();
    }

    @Bean
    public NewTopic topicAlertas() {
        return TopicBuilder.name("alertas")
            .partitions(3)
            .replicas(3)
            .build();
    }

}
