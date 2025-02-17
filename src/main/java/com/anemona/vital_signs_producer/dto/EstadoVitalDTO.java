package com.anemona.vital_signs_producer.dto;

import lombok.Data;

// DTO de señales vitales
@Data
public class EstadoVitalDTO {
    private Long id_estado;
    private int frecuencia_cardiaca;
    private int presion_arterial_sis;
    private int presion_arterial_dias;
    private float saturacion_oxigeno;
    private Long id_paciente;
}

