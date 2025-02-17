package com.anemona.vital_signs_producer.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.anemona.vital_signs_producer.service.VitalSignsService;

// config del scheduler
@Component
public class SchedulerConfig {

    private final VitalSignsService vitalSignsService;

    public SchedulerConfig(VitalSignsService vitalSignsService) {
        this.vitalSignsService = vitalSignsService;
    }

    @Scheduled(fixedRate = 1000) //cada segundo
    public void generateAndSendVitalSigns() {
        vitalSignsService.sendVitalSigns();
    }
    
}
