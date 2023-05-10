package com.nzozbackend.controller;


import com.nzozbackend.domain.Dto.PaymasterDto;
import com.nzozbackend.repository.PaymasterRepository;
import com.nzozbackend.service.PaymasterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nzoz/paymaster")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PaymasterController {
    private final  PaymasterService paymasterService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createPaymaster(@RequestBody PaymasterDto paymasterDto) {
        paymasterService.savePaymasterDto(paymasterDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity <List<PaymasterDto>> getPaymasters() {
        return ResponseEntity.ok(paymasterService.findAllPaymasterDto());
    }

    @PutMapping
    public ResponseEntity <Void> updatePaymaster( @RequestBody PaymasterDto paymasterDto  ) {
        paymasterService.savePaymasterDto(paymasterDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping (value = "{paymasterId}")
    public ResponseEntity <Void> deletePaymaster( @PathVariable Long paymasterId) {
        paymasterService.deletePaymasterById(paymasterId);
        return ResponseEntity.ok().build();
    }
}
