package com.nzozbackend.controller;


import com.nzozbackend.domain.Dto.VisitDto;
import com.nzozbackend.service.VisitService;
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
    VisitService visitService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createVisit(@RequestBody VisitDto visitDto) {
        visitService.saveVisitDto(visitDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity <List<VisitDto>> getVisits() {
        return ResponseEntity.ok(visitService.findAllVisitDto());
    }

    @PutMapping
    public ResponseEntity <VisitDto> updateVisit( @RequestBody VisitDto visitDto  ) {
visitService.saveVisitDto(visitDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping (value = "{taskId}")
    public ResponseEntity <Void> deleteVisit( @PathVariable Long visitId ) {
        visitService.deleteVisitById(visitId);
        return ResponseEntity.ok().build();
    }
}
