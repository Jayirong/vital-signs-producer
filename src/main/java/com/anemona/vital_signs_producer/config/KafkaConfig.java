package com.anemona.vital_signs_producer.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;
import com.anemona.vital_signs_producer.dto.EstadoVitalDTO;

// aqui configuramos Kafka, KafkaTemplate, etc.
@Configuration
public class KafkaConfig {
    
    @Bean
    public ProducerFactory<String, EstadoVitalDTO> producerFactory() {
        Map<String, Object> config = new HashMap<>();
        //creo que hay que cambiar esto para cuando pase las cosas a docker
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka-1:9092,kafka-2:9093,kafka-3:9094");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public KafkaTemplate<String, EstadoVitalDTO> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

}
