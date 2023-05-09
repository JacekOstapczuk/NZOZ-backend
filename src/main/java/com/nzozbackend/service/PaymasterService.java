package com.nzozbackend.service;

import com.nzozbackend.domain.Dto.PaymasterDto;
import com.nzozbackend.domain.Paymaster;
import com.nzozbackend.mapper.PaymasterMapper;
import com.nzozbackend.repository.PaymasterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymasterService {

    public final PaymasterRepository paymasterRepository;
    PaymasterMapper paymasterMapper;


    public List<PaymasterDto> findAllPaymasterDto(){
        return     paymasterMapper.mapToPaymasterDtoList( paymasterRepository.findAll());
    }

    public Paymaster savePaymasterDto (PaymasterDto paymasterDto) {
        return paymasterRepository.save( paymasterMapper.mapToPaymaster(paymasterDto));
    }

    public void deletePaymasterById(final Long paymasterId){
        paymasterRepository.deleteById(paymasterId);
    };
}
