package com.anemona.vital_signs_producer.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.anemona.vital_signs_producer.dto.EstadoVitalDTO;

// Genera datos simulados
@Service
public class VitalSignsGenerator {
    
    private final Random random =  new Random();

    public EstadoVitalDTO generateVitalSigns() {
        EstadoVitalDTO estadoVital = new EstadoVitalDTO();
        estadoVital.setFrecuencia_cardiaca(60 + random.nextInt(100)); //rangos desde 60 a 160 bpm
        estadoVital.setPresion_arterial_sis(90 + random.nextInt(50)); //90-140 mmHg
        estadoVital.setPresion_arterial_dias(60 + random.nextInt(40)); //60-100
        estadoVital.setSaturacion_oxigeno(90 + random.nextFloat() * 10); //90-100%
        estadoVital.setId_paciente(1L);
        return estadoVital;
    }
}
