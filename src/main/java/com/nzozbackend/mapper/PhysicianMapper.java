package com.nzozbackend.mapper;

import com.nzozbackend.domain.Dto.OutpostDto;
import com.nzozbackend.domain.Dto.PaymasterDto;
import com.nzozbackend.domain.Dto.PhysicianDto;
import com.nzozbackend.domain.Outpost;
import com.nzozbackend.domain.Paymaster;
import com.nzozbackend.domain.Physician;

import java.util.List;
import java.util.stream.Collectors;

public class PhysicianMapper {


    public Physician mapToPhysician (final PhysicianDto physicianDto) {
        return new   Physician(
                physicianDto.getId(),
                physicianDto.getName(),
                physicianDto.getSurname(),
                physicianDto.getPWZ(),
                physicianDto.getVisit()
        );
    }

    public PhysicianDto mapToPhysicianDto (final Physician physician) {
        return new   PhysicianDto(
                physician.getId(),
                physician.getName(),
                physician.getSurname(),
                physician.getPWZ(),
                physician.getVisit()
        );
    }

    public List<PhysicianDto> mapToPhysicianDtoList(final List<Physician> physicianList) {
        return physicianList.stream()
                .map(this::mapToPhysicianDto )
                .collect(Collectors.toList());
    }
}
