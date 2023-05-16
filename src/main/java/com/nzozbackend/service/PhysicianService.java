package com.nzozbackend.service;

import com.nzozbackend.domain.Dto.PhysicianDto;
import com.nzozbackend.domain.Physician;
import com.nzozbackend.mapper.PhysicianMapper;
import com.nzozbackend.repository.PhysicianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhysicianService {

    public final PhysicianRepository physicianRepository;
    public final PhysicianMapper physicianMapper;


    public List<PhysicianDto> findAllPhysicianDto() {
        return physicianMapper.mapToPhysicianDtoList(physicianRepository.findAll());
    }

    public Physician findPhysician(Long physicisId) {
        return physicianRepository.findById(physicisId).get();

    }

    public Physician savePhysicianDto(PhysicianDto physicianDto) {
        return physicianRepository.save(physicianMapper.mapToPhysician(physicianDto));
    }

    public void deletePhysicianById(final Long physicianId) {
        physicianRepository.deleteById(physicianId);
    }
}
