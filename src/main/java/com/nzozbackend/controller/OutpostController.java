package com.nzozbackend.controller;


import com.nzozbackend.domain.Dto.OutpostDto;
import com.nzozbackend.service.OutpostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nzoz/outpost")
@RequiredArgsConstructor
@CrossOrigin("*")
public class OutpostController {
    OutpostService outpostService;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Void> createOutpost(@RequestBody OutpostDto outpostDto) {
        outpostService.saveOutpostDto(outpostDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity <List<OutpostDto>> getOutposts() {
        return ResponseEntity.ok(outpostService.findAllOutpostDto());
    }

    @PutMapping (consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Void> updateOutpost( @RequestBody  OutpostDto outpostDto) {
        outpostService.saveOutpostDto(outpostDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping (value = "{taskId}")
    public ResponseEntity <Void> deleteOutpost( @PathVariable Long outpostId ) {
        outpostService.deleteOutpostById(outpostId);
        return ResponseEntity.ok().build();
    }

}
