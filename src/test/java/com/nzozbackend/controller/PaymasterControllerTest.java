package com.nzozbackend.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nzozbackend.LocalDateTypeAdapter;
import com.nzozbackend.LocalTimeTypeAdapter;
import com.nzozbackend.domain.Dto.PaymasterDto;
import com.nzozbackend.domain.Visit;
import com.nzozbackend.service.PaymasterService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(PaymasterController.class)
class PaymasterControllerTest {

    @Autowired
    public MockMvc mockMvc;
    @MockBean
    public PaymasterService paymasterService;

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
        System.out.println(" ");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }

    @DisplayName("when create Paymaster, " +
            "then controller should return ok"
    )
    @Test
    public void testCreatePaymaster() throws Exception {
        //Given
        List<Visit> visit = new ArrayList<>();
        PaymasterDto paymasterDto = new PaymasterDto(1L, "NFZ", visit);
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .registerTypeAdapter(LocalTime.class, new LocalTimeTypeAdapter())
                .create();
        String gsoncontent = gson.toJson(paymasterDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/nzoz/paymaster")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(gsoncontent))
                .andExpect(MockMvcResultMatchers.status().isOk());

        System.out.println("Testing creating new Paymaster");
    }

    @DisplayName("when get Paymasters, " +
            "then controller should return list"
    )
    @Test
    public void testGetPaymasters() throws Exception {
        //Given
       PaymasterDto paymasterDto1 = new PaymasterDto();
        PaymasterDto paymasterDto2 =  new PaymasterDto();
        List<PaymasterDto> paymasterDtoList = new ArrayList<>();
        paymasterDtoList.add(paymasterDto1);
        paymasterDtoList.add(paymasterDto2);

        when(paymasterService.findAllPaymasterDto()).thenReturn(paymasterDtoList);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/nzoz/paymaster")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

        System.out.println("Testing getting all Paymasters");
    }

    @DisplayName("when update Paymaster, " +
            "then controller should return ok"
    )
    @Test
    public void testUpdatePaymaster() throws Exception {
        //Given
        List<Visit> visit = new ArrayList<>();
        PaymasterDto paymasterDto = new PaymasterDto(1L, "NFZ-Lublin", visit);
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .registerTypeAdapter(LocalTime.class, new LocalTimeTypeAdapter())
                .create();
        String gsoncontent = gson.toJson(paymasterDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/nzoz/paymaster")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(gsoncontent))
                .andExpect(MockMvcResultMatchers.status().isOk());

        System.out.println("Testing updating Paymaster");
    }

    @DisplayName("when delete Paymaster, " +
            "then controller should return ok"
    )
    @Test
    public void testDeletePaymaster() throws Exception {
        //Given

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/nzoz/paymaster/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        System.out.println("Testing deleting Paymaster by id");
    }
}


