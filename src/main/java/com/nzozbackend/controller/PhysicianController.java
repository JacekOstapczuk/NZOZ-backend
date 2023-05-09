package com.nzozbackend.controller;


import com.nzozbackend.domain.Dto.PhysicianDto;
import com.nzozbackend.service.PhysicianService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nzoz/physican")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PhysicianController {

    PhysicianService physicianService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createPhysician(@RequestBody PhysicianDto physicianDto) {
        physicianService.savePhysicianDto(physicianDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity <List<PhysicianDto>> getPhysicians() {
        return ResponseEntity.ok(physicianService.findAllPhysicianDto());
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Void>updatePhysician(@RequestBody PhysicianDto physicianDto  ) {
        physicianService.savePhysicianDto(physicianDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping (value = "{taskId}")
    public ResponseEntity <Void> deletePhysician(@PathVariable Long physicianId) {
        physicianService.deletePhysicianById(physicianId);
        return ResponseEntity.ok().build();
    }
}
