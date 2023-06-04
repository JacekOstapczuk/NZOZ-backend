package com.nzozbackend.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nzozbackend.LocalDateTypeAdapter;
import com.nzozbackend.LocalTimeTypeAdapter;
import com.nzozbackend.domain.Dto.PatientDto;
import com.nzozbackend.domain.Visit;
import com.nzozbackend.mapper.PatientMapper;
import com.nzozbackend.repository.PatientRepository;
import com.nzozbackend.service.PatientService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(PatientController.class)
class PatientControllerTest {

    @Autowired
    public MockMvc mockMvc;
    @MockBean
    public PatientService patientService;
    @MockBean
    public PatientRepository patientRepository;
    @MockBean
    public PatientController patientController;
    @MockBean
    public PatientMapper patientMapper;

    @Test
    public void testCreatePatient() throws Exception {
        //Given
        List <Visit> visitsList = new ArrayList<>();
        PatientDto patientDto = new PatientDto(1L, "Tomasz", "Fronczewski", 4623414, visitsList);

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .registerTypeAdapter(LocalTime.class, new LocalTimeTypeAdapter())
                .create();
        String gsoncontent = gson.toJson(patientDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/nzoz/patient")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(gsoncontent))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetPatients() throws Exception {
        //Given
        List <Visit> visitsList = new ArrayList<>();
        PatientDto patientDto1 = new PatientDto(1L, "Tomasz", "Fronczewski", 4623414, visitsList);
        PatientDto patientDto2 = new PatientDto(2L, "Tomaszek", "Fronczewicz", 156403, visitsList);
        List <PatientDto> patientDtoList = new ArrayList<>();
        patientDtoList.add(patientDto1);
        patientDtoList.add(patientDto2);
       when(patientService.findAllPatientDto()).thenReturn( patientDtoList);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/nzoz/patient")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }

    @Test
    public void testGetPatient() throws Exception {
        //Given
        List <Visit> visitsList = new ArrayList<>();
        PatientDto patientDto1 = new PatientDto(1L, "Tomasz", "Fronczewski", 4623414, visitsList);
        when( patientService.findPatientDto(any())).thenReturn(patientDto1);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/nzoz/patient/" + patientDto1.getId())
                       .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)));
    }


}