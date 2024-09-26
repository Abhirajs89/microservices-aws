package com.abhiraj.appointment_ms.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "patient-service")
public interface PatientServiceClient {

    @GetMapping("/patients/{id}/exists")
    ResponseEntity<Boolean> checkPatientExists(@PathVariable("id") Long id);
}
