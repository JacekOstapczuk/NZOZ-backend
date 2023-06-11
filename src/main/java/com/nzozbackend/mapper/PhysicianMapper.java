package com.nzozbackend.mapper;

import com.nzozbackend.domain.Dto.PhysicianDto;
import com.nzozbackend.domain.Physician;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PhysicianMapper {

    public Physician mapToPhysician(final PhysicianDto physicianDto) {
        return new Physician(
                physicianDto.getId(),
                physicianDto.getName(),
                physicianDto.getSurname(),
                physicianDto.getPwz(),
                physicianDto.getVisits()
        );
    }

    public PhysicianDto mapToPhysicianDto(final Physician physician) {
        return new PhysicianDto(
                physician.getId(),
                physician.getName(),
                physician.getSurname(),
                physician.getPwz(),
                physician.getVisits()
        );
    }

    public List<PhysicianDto> mapToPhysicianDtoList(final List<Physician> physicianList) {
        return physicianList.stream()
                .map(this::mapToPhysicianDto)
                .collect(Collectors.toList());
    }
}
