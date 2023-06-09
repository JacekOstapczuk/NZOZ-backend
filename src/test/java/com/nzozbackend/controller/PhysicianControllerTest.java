package com.nzozbackend.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nzozbackend.LocalDateTypeAdapter;
import com.nzozbackend.LocalTimeTypeAdapter;
import com.nzozbackend.domain.Dto.PhysicianDto;
import com.nzozbackend.domain.Physician;
import com.nzozbackend.domain.Visit;
import com.nzozbackend.service.PhysicianService;
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
@WebMvcTest(PhysicianController.class)
class PhysicianControllerTest {

    @Autowired
    public MockMvc mockMvc;
    @MockBean
    public PhysicianService physicianService;

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

    @DisplayName("when create Physician, " +
            "then controller should return ok"
    )
    @Test
    public void testCreatePhysician() throws Exception {
        //Given
        Physician physician = new Physician();

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .registerTypeAdapter(LocalTime.class, new LocalTimeTypeAdapter())
                .create();
        String gsoncontent = gson.toJson(physician);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/nzoz/physican")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(gsoncontent))
                .andExpect(MockMvcResultMatchers.status().isOk());

        System.out.println("Testing creating new Physician");
    }

    @DisplayName("when get Physician, " +
            "then controller should return list"
    )
    @Test
    public void testGetPhysicians() throws Exception {
        //Given
        PhysicianDto physicianDto1 = new PhysicianDto();
        PhysicianDto physicianDto2 = new PhysicianDto();
        List<PhysicianDto> physicianDtoList = new ArrayList<>();
        physicianDtoList.add(physicianDto1);
        physicianDtoList.add(physicianDto2);

        when(physicianService.findAllPhysicianDto()).thenReturn(physicianDtoList);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/nzoz/physican")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

        System.out.println("Testing getting all Physician");
    }

    @DisplayName("when update Physician, " +
            "then controller should return ok"
    )
    @Test
    public void testUpdatePhysician() throws Exception {
        //Given
        List<Visit> visit = new ArrayList<>();
        PhysicianDto physicianDto = new PhysicianDto(1L, "Tadeusz", "Morawski", 5231, visit);
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .registerTypeAdapter(LocalTime.class, new LocalTimeTypeAdapter())
                .create();
        String gsonContent = gson.toJson(physicianDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/nzoz/physican")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(gsonContent))
                .andExpect(MockMvcResultMatchers.status().isOk());

        System.out.println("Testing updating Physician");
    }

    @DisplayName("when delete Physician, " +
            "then controller should return ok"
    )
    @Test
    public void testDeletePhysician() throws Exception {
        //Given

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/nzoz/physican/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        System.out.println("Testing deleting Physician by id");
    }
}