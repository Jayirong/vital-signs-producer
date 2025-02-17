package com.anemona.vital_signs_producer.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.anemona.vital_signs_producer.dto.EstadoVitalDTO;

// logica de negocio (enviar cosos a Kafka)
@Service
public class VitalSignsService {
    
    private final KafkaTemplate<String, EstadoVitalDTO> kafkaTemplate;
    private final VitalSignsGenerator vitalSignsGenerator;

    public VitalSignsService(KafkaTemplate<String, EstadoVitalDTO> kafkaTemplate, VitalSignsGenerator vitalSignsGenerator) {
        this.kafkaTemplate = kafkaTemplate;
        this.vitalSignsGenerator = vitalSignsGenerator;
    }

    public void sendVitalSigns(){
        EstadoVitalDTO estadoVital = vitalSignsGenerator.generateVitalSigns();
        System.out.println("Enviando sennal vital: " + estadoVital);
        kafkaTemplate.send("senales_vitales", estadoVital);
    }

}
