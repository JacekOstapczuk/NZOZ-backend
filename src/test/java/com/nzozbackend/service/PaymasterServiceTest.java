package com.nzozbackend.service;

import com.nzozbackend.domain.Dto.PaymasterDto;
import com.nzozbackend.domain.Paymaster;
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
class PaymasterServiceTest {

    @Autowired
    PaymasterService paymasterService;

    private void deleteTestedPaymaster() {
        Long id = 0L;
        List<PaymasterDto> paymasterDtoList = paymasterService.findAllPaymasterDto();
        Iterator<PaymasterDto> paymasterDtoIterator = paymasterDtoList.iterator();
        while (paymasterDtoIterator.hasNext()) {
            id = paymasterDtoIterator.next().getId();
        }
        paymasterService.deletePaymasterById(id);
    }

    @Test
    public void tesFindAllPaymasterDto() {
        //Given
        List<Visit> visit = new ArrayList<>();
        PaymasterDto paymasterDto1 = new PaymasterDto(4L, "NZF-Bialystok", visit);
        PaymasterDto paymasterDto2 = new PaymasterDto(5L, "NZF-Wroclaw", visit);
        int paymasterServiceCountBefore = paymasterService.findAllPaymasterDto().size();
        paymasterService.savePaymasterDto(paymasterDto1);
        paymasterService.savePaymasterDto(paymasterDto2);
        int paymasterServiceCountAfter = paymasterService.findAllPaymasterDto().size();

        //When
        int paymasterServiceCount = paymasterServiceCountAfter - paymasterServiceCountBefore;

        //Then
        assertEquals(2, paymasterServiceCount);

        //CleanUp
        deleteTestedPaymaster();
        deleteTestedPaymaster();
    }

    @Test
    public void tesFindPaymaster() {
        //Given
        List<Visit> visit = new ArrayList<>();
        PaymasterDto paymasterDto1 = new PaymasterDto(5L, "NZF-Krakow", visit);
        paymasterService.savePaymasterDto(paymasterDto1);
        List<PaymasterDto> paymasterDtoList = paymasterService.findAllPaymasterDto();
        long id = 0;
        for (PaymasterDto paymasterDto : paymasterDtoList) {
            id = paymasterDto.getId();
        }

        //When
        Paymaster searchingPaymaster = paymasterService.findPaymaster(id);

        //Then
        assertEquals(paymasterDto1.getName(), searchingPaymaster.getName());
        //CleanUp
        paymasterService.deletePaymasterById(id);
    }

    @Test
    public void tesFindPaymasterDto() {
        //Given
        List<Visit> visit = new ArrayList<>();
        PaymasterDto paymasterDto1 = new PaymasterDto(5L, "NZF-Krakow", visit);
        paymasterService.savePaymasterDto(paymasterDto1);
        List<PaymasterDto> paymasterDtoList = paymasterService.findAllPaymasterDto();
        long id = 0;
        for (PaymasterDto paymasterDto : paymasterDtoList) {
            id = paymasterDto.getId();
        }

        //When
        PaymasterDto searchingPaymasterDto = paymasterService.findPaymasterDto(id);

        //Then
        assertEquals(paymasterDto1.getName(), searchingPaymasterDto.getName());
        //CleanUp
        paymasterService.deletePaymasterById(id);
    }
}