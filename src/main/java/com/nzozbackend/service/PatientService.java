package com.nzozbackend.service;


import com.nzozbackend.domain.Dto.PatientDto;
import com.nzozbackend.domain.Patient;
import com.nzozbackend.mapper.PatientMapper;
import com.nzozbackend.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    public final PatientRepository patientRepository;
    public final PatientMapper patientMapper;

    public List<PatientDto> findAllPatientDto(){
        return   patientMapper.mapToPatientDtoList(patientRepository.findAll());
    }

    public PatientDto findPatientDto (Long patientId){
        return patientMapper.mapToPatientDto(patientRepository.findById(patientId).get());
    }

    public Patient findPatient (Long patientId){
        return patientRepository.findById(patientId).get();
    }

    public Patient savePatientDto (PatientDto patientDto) {
    return patientRepository.save( patientMapper.mapToPatient(patientDto));
}

    public void deletePatientById(final Long patientId){
        patientRepository.deleteById(patientId);
    }

}