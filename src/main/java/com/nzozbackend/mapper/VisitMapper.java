package com.nzozbackend.mapper;

import com.nzozbackend.domain.Dto.PhysicianDto;
import com.nzozbackend.domain.Dto.VisitDto;
import com.nzozbackend.domain.Physician;
import com.nzozbackend.domain.Visit;

import java.util.List;
import java.util.stream.Collectors;

public class VisitMapper {

    public Visit mapToVisit (final VisitDto visitDto) {
        return new Visit(
                visitDto.getId(),
                visitDto.getPhysician(),
                visitDto.getPatient(),
                visitDto.getPaymaster(),
                visitDto.getOutpost(),
                visitDto.getDate()
        );
    }

    public VisitDto mapToVisitDto (final Visit visit) {
        return new VisitDto(
                visit.getId(),
                visit.getPhysician(),
                visit.getPatient(),
                visit.getPaymaster(),
                visit.getOutpost(),
                visit.getDate()
        );
    }

    public List<VisitDto> mapToVisitDtoList(final List<Visit> visitList) {
        return visitList.stream()
                .map(this::mapToVisitDto )
                .collect(Collectors.toList());
    }
}
