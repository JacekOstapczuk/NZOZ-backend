package com.nzozbackend.service;

import com.nzozbackend.domain.Dto.VisitDto;
import com.nzozbackend.domain.Visit;
import com.nzozbackend.mapper.VisitMapper;
import com.nzozbackend.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitService {
    public final VisitRepository visitRepository;
    public final VisitMapper visitMapper;

    public List<VisitDto> findAllVisitDto() {
        return visitMapper.mapToVisitDtoList(visitRepository.findAll());
    }

    public Visit findVisit(Long visitId) {
        return visitRepository.findById(visitId).get();
    }

    public Visit saveVisitDto(VisitDto visitDto) {
        return visitRepository.save(visitMapper.mapToVisit(visitDto));
    }

    public void deleteVisitById(final Long visitId) {
        visitRepository.deleteById(visitId);
    }
}
