package com.nzozbackend.mapper;

import com.nzozbackend.domain.Dto.OutpostDto;
import com.nzozbackend.domain.Dto.PatientDto;
import com.nzozbackend.domain.Outpost;
import com.nzozbackend.domain.Patient;

import java.util.List;
import java.util.stream.Collectors;

public class PatientMapper {

    public Patient mapToPatient (final PatientDto patientDto) {
        return new Patient(
                patientDto.getId(),
                patientDto.getName(),
                patientDto.getSurname(),
                patientDto.getPESEL(),
                patientDto.getVisit()
        );
    }

    public PatientDto mapToPatientDto (final Patient patient) {
        return new PatientDto(
                patient.getId(),
                patient.getName(),
                patient.getSurname(),
                patient.getPESEL(),
                patient.getVisit()
        );
    }

    public List<PatientDto> mapToPatientDtoList(final List<Patient> patientList) {
        return patientList.stream()
                .map(this::mapToPatientDto)
                .collect(Collectors.toList());
    }


}
