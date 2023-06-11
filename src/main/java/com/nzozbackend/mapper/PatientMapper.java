package com.nzozbackend.mapper;

import com.nzozbackend.domain.Dto.PatientDto;
import com.nzozbackend.domain.Patient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientMapper {

    public Patient mapToPatient(final PatientDto patientDto) {
        return new Patient(
                patientDto.getId(),
                patientDto.getName(),
                patientDto.getSurname(),
                patientDto.getPesel(),
                patientDto.getVisits()
        );
    }

    public PatientDto mapToPatientDto(final Patient patient) {
        return new PatientDto(
                patient.getId(),
                patient.getName(),
                patient.getSurname(),
                patient.getPesel(),
                patient.getVisits()
        );
    }

    public List<PatientDto> mapToPatientDtoList(final List<Patient> patientList) {
        return patientList.stream()
                .map(this::mapToPatientDto)
                .collect(Collectors.toList());
    }
}
