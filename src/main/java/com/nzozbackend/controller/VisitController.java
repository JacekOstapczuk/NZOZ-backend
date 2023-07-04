package com.nzozbackend.controller;

import com.nzozbackend.controller.exception.OutpostNotFoundException;
import com.nzozbackend.domain.Dto.VisitDto;
import com.nzozbackend.domain.*;
import com.nzozbackend.domain.VisitSettings.*;
import com.nzozbackend.mapper.VisitMapper;
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
    private final VisitSettlementBasic visitSettlementBasic;
    private final VisitSettlementConfig visitSettlementConfig;

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

    @PutMapping(value = "{visitId}/addVisitType/{visitType}")
    public ResponseEntity<VisitDto> addVisitType(@PathVariable Long visitId, @PathVariable String visitType) {
        Visit modifiedVisit = visitService.findVisit(visitId);

        VisitType setVisitType;
        switch (visitType) {
            case "First" -> {
                setVisitType = VisitType.INSTANCE;
                setVisitType.setFirstVisit(modifiedVisit);
                visitService.saveVisitDto(visitMapper.mapToVisitDto(modifiedVisit));
            }
            case "FollowUp" -> {
                setVisitType = VisitType.INSTANCE;
                setVisitType.setFollowUpVisit(modifiedVisit);
                visitService.saveVisitDto(visitMapper.mapToVisitDto(modifiedVisit));
            }
            case "Diagnostic" -> {
                setVisitType = VisitType.INSTANCE;
                setVisitType.setDiagnosticVisit(modifiedVisit);
                visitService.saveVisitDto(visitMapper.mapToVisitDto(modifiedVisit));
            }
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "{visitId}/addVisitSettlement/{visitSettlement}")
    public ResponseEntity<Void> addVisitSettlement(@PathVariable Long visitId, @PathVariable String visitSettlement) {
        Visit modifiedVisit = visitService.findVisit(visitId);
        VisitSettlement settlementToEdit = modifiedVisit.getSettlement();

        switch (visitSettlement) {
            case "Cardio":
                VisitSettlement visitSettlementCardio = new VisitSettlementCardio(settlementToEdit);
                modifiedVisit.setSettlement(visitSettlementCardio);
                visitService.saveVisitDto(visitMapper.mapToVisitDto(modifiedVisit));
                break;
            case "Lungs":
                VisitSettlement visitSettlementLungs = new VisitSettlementLungs(settlementToEdit);
                modifiedVisit.setSettlement(visitSettlementLungs);
                visitService.saveVisitDto(visitMapper.mapToVisitDto(modifiedVisit));
                break;
            case "Prostate":
                VisitSettlement visitSettlementProstate = new VisitSettlementProstate(settlementToEdit);
                modifiedVisit.setSettlement(visitSettlementProstate);
                visitService.saveVisitDto(visitMapper.mapToVisitDto(modifiedVisit));
                break;
        }
        visitService.saveVisitDto(visitMapper.mapToVisitDto(modifiedVisit));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{visitId}")
    public ResponseEntity<Void> deleteVisit(@PathVariable Long visitId) {
        visitService.deleteVisitById(visitId);
        return ResponseEntity.ok().build();
    }
}
