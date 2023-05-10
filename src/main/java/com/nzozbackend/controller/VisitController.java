package com.nzozbackend.controller;


import com.nzozbackend.domain.*;
import com.nzozbackend.domain.Dto.VisitDto;
import com.nzozbackend.mapper.VisitMapper;
import com.nzozbackend.repository.PatientRepository;
import com.nzozbackend.repository.PaymasterRepository;
import com.nzozbackend.repository.PhysicianRepository;
import com.nzozbackend.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nzoz/visit")
@RequiredArgsConstructor
@CrossOrigin("*")
public class VisitController {
    private final VisitService visitService;
    private final PhysicianService physicianService;
    private final PatientService patientService;
    private final PaymasterService paymasterService;
    public final OutpostService outpostService;
    private final VisitMapper visitMapper;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createVisit(@RequestBody VisitDto visitDto) {
        visitService.saveVisitDto(visitDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<VisitDto>> getVisits() {
        return ResponseEntity.ok(visitService.findAllVisitDto());
    }

    @PutMapping
    public ResponseEntity<Void> updateVisit(@RequestBody VisitDto visitDto) {
        visitService.saveVisitDto(visitDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "{visitId}/addPhysician/{physicianId}")
    public ResponseEntity<Void> addPhysician(@PathVariable Long visitId, @PathVariable Long physicianId) {
        Physician addedPhysician = physicianService.findPhysician(physicianId);
        Visit modifiedVisit = visitService.findVisit(visitId);
        modifiedVisit.setPhysician(addedPhysician);
        visitService.saveVisitDto(visitMapper.mapToVisitDto(modifiedVisit));
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "{visitId}/addPatient/{patientId}")
    public ResponseEntity<Void> addPatient(@PathVariable Long visitId, @PathVariable Long patientId) {
        Patient addedPatient = patientService.findPatient(patientId);
        Visit modifiedVisit = visitService.findVisit(visitId);
        modifiedVisit.setPatient(addedPatient);
        visitService.saveVisitDto(visitMapper.mapToVisitDto(modifiedVisit));
        return ResponseEntity.ok().build();
    }


    @PutMapping(value = "{visitId}/addPaymaster/{paymasterId}")
    public ResponseEntity<Void> addPaymaster(@PathVariable Long visitId, @PathVariable Long paymasterId) {
        Paymaster addedPaymaster = paymasterService.findPaymaster(paymasterId);
        Visit modifiedVisit = visitService.findVisit(visitId);
        modifiedVisit.setPaymaster(addedPaymaster);
        visitService.saveVisitDto(visitMapper.mapToVisitDto(modifiedVisit));
        return ResponseEntity.ok().build();
    }


    @PutMapping(value = "{visitId}/addOutpost/{outpostId}")
    public ResponseEntity<Void> addOutpost(@PathVariable Long visitId, @PathVariable Long outpostId) {
        Outpost addedOutpost = outpostService.findOutpost(outpostId);
        Visit modifiedVisit = visitService.findVisit(visitId);
        modifiedVisit.setOutpost(addedOutpost);
        visitService.saveVisitDto(visitMapper.mapToVisitDto(modifiedVisit));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{visitId}")
    public ResponseEntity<Void> deleteVisit(@PathVariable Long visitId) {
        visitService.deleteVisitById(visitId);
        return ResponseEntity.ok().build();
    }
}
