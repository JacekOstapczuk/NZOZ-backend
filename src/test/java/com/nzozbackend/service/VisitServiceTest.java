package com.nzozbackend.service;

import com.nzozbackend.domain.*;
import com.nzozbackend.domain.Dto.VisitDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class VisitServiceTest {

    @Autowired
    VisitService visitService;

    private void deleteTestedVisit() {
        Long id = 0L;
        List<VisitDto> visitDtoList = visitService.findAllVisitDto();
        Iterator<VisitDto> visitDtoIterator = visitDtoList.iterator();
        while (visitDtoIterator.hasNext()) {
            id = visitDtoIterator.next().getId();
        }
        visitService.deleteVisitById(id);
    }

    @Test
    public void tesFindAllPatientsDto() {
        //Given
        VisitDto visitDto1 = new VisitDto();
        VisitDto visitDto2 = new VisitDto();
        int visitServiceCountBefore = visitService.findAllVisitDto().size();
        visitService.saveVisitDto(visitDto1);
        visitService.saveVisitDto(visitDto2);
        int visitServiceCountAfter = visitService.findAllVisitDto().size();

        //When
        int visitServiceCount = visitServiceCountAfter - visitServiceCountBefore;
        //Then
        assertEquals(2, visitServiceCount);

        //CleanUp
        deleteTestedVisit();
        deleteTestedVisit();
    }

    @Test
    public void tesFindVisit() {
        //Given
        VisitDto visitDto1 = new VisitDto();
        visitDto1.setVisitName("First Visit");
        visitService.saveVisitDto(visitDto1);
        List<VisitDto> visitDtoList = visitService.findAllVisitDto();
        long id = 0;
        for (VisitDto visitDto : visitDtoList) {
            id = visitDto.getId();
        }

        //When
        Visit searchingVisit = visitService.findVisit(id);

        //Then
        assertEquals(visitDto1.getVisitName(), searchingVisit.getVisitName());
        //CleanUp
        visitService.deleteVisitById(id);
    }
}