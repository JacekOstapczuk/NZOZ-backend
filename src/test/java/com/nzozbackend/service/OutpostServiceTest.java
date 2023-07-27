package com.nzozbackend.service;

import com.nzozbackend.domain.Administrator;
import com.nzozbackend.domain.Dto.OutpostDto;
import com.nzozbackend.domain.Outpost;
import com.nzozbackend.domain.Visit;
import com.nzozbackend.repository.OutpostRepository;
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
class OutpostServiceTest {

    @Autowired
    OutpostService outpostService;
    @Autowired
    OutpostRepository outpostRepository;

    private  void deleteTestedOutpost() {
        Long id =0L;
        List <OutpostDto> outpostDtoList= outpostService.findAllOutpostDto();
        Iterator <OutpostDto>  outpostDtoIterator= outpostDtoList.iterator();
        while (outpostDtoIterator.hasNext()) {
            id = outpostDtoIterator.next().getId();
        }
        outpostService.deleteOutpostById( id);
    }

    @Test
    public void FindAllOutpostDto_TwoOutpostDto_ListOfTwoOutpostDto() {
        //Given
        List<Visit> visit = new ArrayList<>();
        OutpostDto outpost1 = new OutpostDto( "Warszawa", new Administrator(), visit );
        OutpostDto outpost2 = new OutpostDto( "Poznan", new Administrator(), visit );
        int outpostServiceCountBefore =outpostService.findAllOutpostDto().size();
        outpostService.saveOutpostDto(outpost1);
        outpostService.saveOutpostDto(outpost2);
        int outpostServiceCountAfter =outpostService.findAllOutpostDto().size();

        //When
         int outpostServiceCount = outpostServiceCountAfter - outpostServiceCountBefore;
        //Then
        assertEquals(2, outpostServiceCount);

        //CleanUp
        deleteTestedOutpost();
        deleteTestedOutpost();
    }

    @Test
    public void FindOutpost_OutpostId_OneOutpost() {
        //Given
        List<Visit> visit = new ArrayList<>();
        OutpostDto outpost1 = new OutpostDto("Krakow", new Administrator(), visit );
        outpostService.saveOutpostDto(outpost1);
        List <OutpostDto> outpostDtoList= outpostService.findAllOutpostDto();
      long id1 = 0;
        for ( OutpostDto outpostDto : outpostDtoList) {
              id1= outpostDto.getId();
          };

        //When
            Outpost searchingOutpost = outpostService.findOutpost(id1);


        //Then
        assertEquals(outpost1.getCity(), searchingOutpost.getCity());

        //CleanUp
        outpostService.deleteOutpostById(id1);
    }
}