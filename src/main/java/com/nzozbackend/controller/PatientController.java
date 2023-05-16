package com.nzozbackend.controller;


import com.nzozbackend.domain.Dto.PatientDto;
import com.nzozbackend.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nzoz/patient")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PatientController {

    private final PatientService patientService;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createPatient(@RequestBody PatientDto patientDto) {
        patientService.savePatientDto(patientDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<PatientDto>> getPatients() {
        return ResponseEntity.ok(patientService.findAllPatientDto());
    }


    @GetMapping(value = "{patientId}")
    public ResponseEntity<PatientDto> getPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(patientService.findPatientDto(patientId));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updatePatient(@RequestBody PatientDto patientDto) {
        patientService.savePatientDto(patientDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{patientId}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long patientId) {
        patientService.deletePatientById(patientId);
        return ResponseEntity.ok().build();
    }
}
