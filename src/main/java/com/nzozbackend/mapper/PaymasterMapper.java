package com.nzozbackend.mapper;

import com.nzozbackend.domain.Dto.OutpostDto;
import com.nzozbackend.domain.Dto.PatientDto;
import com.nzozbackend.domain.Dto.PaymasterDto;
import com.nzozbackend.domain.Outpost;
import com.nzozbackend.domain.Patient;
import com.nzozbackend.domain.Paymaster;

import java.util.List;
import java.util.stream.Collectors;

public class PaymasterMapper {

    public Paymaster mapToPaymaster (final PaymasterDto paymasterDto) {
        return new  Paymaster(
                paymasterDto.getId(),
                paymasterDto.getName(),
                paymasterDto.getVisit()
        );
    }

    public PaymasterDto mapToPaymasterDto (final Paymaster paymaster) {
        return new  PaymasterDto(
                paymaster.getId(),
                paymaster.getName(),
                paymaster.getVisit()
                );
    }

    public List<PaymasterDto> mapToPaymasterDtoList(final List<Paymaster> paymasterList) {
        return paymasterList.stream()
                .map(this::mapToPaymasterDto)
                .collect(Collectors.toList());
    }
}
