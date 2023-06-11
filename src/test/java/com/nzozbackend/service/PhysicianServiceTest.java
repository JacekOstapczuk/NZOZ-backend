package com.nzozbackend.service;

import com.nzozbackend.domain.Dto.PhysicianDto;
import com.nzozbackend.domain.Physician;
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
class PhysicianServiceTest {

    @Autowired
    PhysicianService  physicianService;

    private void deleteTestedPhysician() {
        Long id = 0L;
        List<PhysicianDto> physicianDtoList = physicianService.findAllPhysicianDto();
        Iterator<PhysicianDto> physicianDtoIterator = physicianDtoList.iterator();
        while (physicianDtoIterator.hasNext()) {
            id = physicianDtoIterator.next().getId();
        }
        physicianService.deletePhysicianById(id);
    }
    @Test
    public void tesFindAllPhysiciansDto() {
        //Given
        List<Visit> visit = new ArrayList<>();
        PhysicianDto physicianDto1 = new PhysicianDto(4L, "Radek", "Koryto", 485498, visit);
        PhysicianDto physicianDto2 = new PhysicianDto(7L, "Tomek", "Zlob", 559551, visit);
        int physicianServiceCountBefore = physicianService.findAllPhysicianDto().size();
        physicianService.savePhysicianDto(physicianDto1);
        physicianService.savePhysicianDto(physicianDto2);
        int physicianServiceCountAfter = physicianService.findAllPhysicianDto().size();

        //When
        int physicianServiceCount = physicianServiceCountAfter - physicianServiceCountBefore;
        //Then
        assertEquals(2, physicianServiceCount);

        //CleanUp
        deleteTestedPhysician();
        deleteTestedPhysician();
    }

    @Test
    public void tesFindPatient() {
        //Given
        List<Visit> visit = new ArrayList<>();
        PhysicianDto physicianDto1 = new PhysicianDto(2L, "Radek", "Koryto", 485498, visit);
        physicianService.savePhysicianDto(physicianDto1);
        List<PhysicianDto> physicianDtoList = physicianService.findAllPhysicianDto();
        long id = 0;
        for (PhysicianDto physicianDto : physicianDtoList) {
            id = physicianDto.getId();
        }

        //When
        Physician searchingPhysician  = physicianService.findPhysician(id);

        //Then
        assertEquals(physicianDto1.getSurname(), searchingPhysician.getSurname());
        assertEquals(physicianDto1.getPwz(), searchingPhysician.getPwz());
        //CleanUp
        physicianService.deletePhysicianById(id);
    }
}