package com.nzozbackend.mapper;

import com.nzozbackend.domain.Dto.PaymasterDto;
import com.nzozbackend.domain.Paymaster;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class PaymasterMapper {

    public Paymaster mapToPaymaster (final PaymasterDto paymasterDto) {
        return new  Paymaster(
                paymasterDto.getId(),
                paymasterDto.getName(),
               paymasterDto.getVisits()
        );
    }

    public PaymasterDto mapToPaymasterDto (final Paymaster paymaster) {
        return new  PaymasterDto(
                paymaster.getId(),
                paymaster.getName(),
              paymaster.getVisits()
                );
    }

    public List<PaymasterDto> mapToPaymasterDtoList(final List<Paymaster> paymasterList) {
        return paymasterList.stream()
                .map(this::mapToPaymasterDto)
                .collect(Collectors.toList());
    }
}
