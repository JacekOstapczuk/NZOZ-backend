package com.nzozbackend.service;

import com.nzozbackend.domain.Dto.PatientDto;
import com.nzozbackend.domain.Patient;
import com.nzozbackend.domain.Visit;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PatientServiceTest {
    @Autowired
    PatientService patientService;

    private void deleteTestedPatient() {
        Long id = 0L;
        List<PatientDto> patientDtoList = patientService.findAllPatientDto();
        Iterator<PatientDto> patientDtoIterator = patientDtoList.iterator();
        while (patientDtoIterator.hasNext()) {
            id = patientDtoIterator.next().getId();
        }
        patientService.deletePatientById(id);
    }

    @Test
    public void tesFindAllPatientsDto() {
        //Given
        List<Visit> visit = new ArrayList<>();
        PatientDto patientDto1 = new PatientDto(2L, "Radek", "Koryto", 874648, visit);
        PatientDto patientDto2 = new PatientDto(3L, "Tomek", "Zlob", 6241, visit);
        int patientServiceCountBefore = patientService.findAllPatientDto().size();
        patientService.savePatientDto(patientDto1);
        patientService.savePatientDto(patientDto2);
        int patientServiceCountAfter = patientService.findAllPatientDto().size();

        //When
        int patientServiceCount = patientServiceCountAfter - patientServiceCountBefore;
        //Then
        assertEquals(2, patientServiceCount);

        //CleanUp
        deleteTestedPatient();
        deleteTestedPatient();
    }

    @Test
    public void tesFindPatient() {
        //Given
        List<Visit> visit = new ArrayList<>();
        PatientDto patientDto1 = new PatientDto(4L, "Michal", "Drob", 2486785, visit);
        patientService.savePatientDto(patientDto1);
        List<PatientDto> patientDtoList = patientService.findAllPatientDto();
        long id = 0;
        for (PatientDto patientDto : patientDtoList) {
            id = patientDto.getId();
        }

        //When
        Patient searchingPatient = patientService.findPatient(id);

        //Then
        assertEquals(patientDto1.getSurname(), searchingPatient.getSurname());
        assertEquals(patientDto1.getPesel(), searchingPatient.getPesel());
        //CleanUp
        patientService.deletePatientById(id);
    }

    @Test
    public void tesFindPatientDto() {
        //Given
        List<Visit> visit = new ArrayList<>();
        PatientDto patientDto1 = new PatientDto(5L, "Dawid", "Boczek", 7458917, visit);
        patientService.savePatientDto(patientDto1);
        List<PatientDto> patientDtoList = patientService.findAllPatientDto();
        long id = 0;
        for (PatientDto patientDto : patientDtoList) {
            id = patientDto.getId();
        }

        //When
        PatientDto searchingPatientDto = patientService.findPatientDto(id);

        //Then
        assertEquals(patientDto1.getSurname(), searchingPatientDto.getSurname());
        assertEquals(patientDto1.getPesel(), searchingPatientDto.getPesel());
        //CleanUp
        patientService.deletePatientById(id);
    }
}