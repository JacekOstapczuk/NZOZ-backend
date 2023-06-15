package com.nzozbackend.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nzozbackend.LocalDateTypeAdapter;
import com.nzozbackend.LocalTimeTypeAdapter;
import com.nzozbackend.domain.Administrator;
import com.nzozbackend.domain.Dto.OutpostDto;
import com.nzozbackend.domain.Visit;
import com.nzozbackend.mapper.OutpostMapper;
import com.nzozbackend.repository.OutpostRepository;
import com.nzozbackend.service.OutpostService;
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
@WebMvcTest(OutpostController.class)
class OutpostControllerTest {

    @Autowired
    public MockMvc mockMvc;
    @MockBean
    public OutpostService outpostService;
    @MockBean
    public OutpostRepository outpostRepository;
    @MockBean
    public OutpostMapper outpostMapper;

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

    @DisplayName("when create Outpost, " +
            "then controller should return ok"
    )
    @Test
    public void testCreateOutpost() throws Exception {
        //Given
        List<Visit> visitList = new ArrayList<Visit>();
        OutpostDto outpostDto = new OutpostDto( "Warsaw", new Administrator(1l, "Tomek"), visitList);

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .registerTypeAdapter(LocalTime.class, new LocalTimeTypeAdapter())
                .create();
        String gsoncontent = gson.toJson(outpostDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/nzoz/outpost")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(gsoncontent))
                .andExpect(MockMvcResultMatchers.status().isOk());

        System.out.println("Testing creating new Outpost");
    }

    @DisplayName("when get Outposts, " +
            "then controller should return list"
    )
    @Test
    public void testGetOutposts() throws Exception {
        //Given
        Visit visit = new Visit();
        List<Visit> visitList = new ArrayList<Visit>();
        visitList.add(visit);
        OutpostDto outpostDto1 = new OutpostDto(1L, "Warsaw", new Administrator(1L, "Tomek"), visitList);
        OutpostDto outpostDto2 = new OutpostDto(2L, "Gdansk", new Administrator(2L, "Romek"), visitList);
        List<OutpostDto> outpostDtoList = new ArrayList<>();
        outpostDtoList.add(outpostDto1);
        outpostDtoList.add(outpostDto2);
        when(outpostService.findAllOutpostDto()).thenReturn(outpostDtoList);
        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/nzoz/outpost")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

        System.out.println("Testing getting all Outpost");
    }

    @DisplayName("when update Outpost, " +
            "then controller should return ok"
    )
    @Test
    public void testUpdateOutpost() throws Exception {
        //Given
        List<Visit> visitList = new ArrayList<Visit>();
        OutpostDto outpostDto1 = new OutpostDto( "Warsaw", new Administrator(1L, "Tomek"), visitList);
        OutpostDto outpostDto2 = new OutpostDto("Gdansk", new Administrator(2L, "Romek"), visitList);
        outpostRepository.save(outpostMapper.mapToOutpost(outpostDto1));

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .registerTypeAdapter(LocalTime.class, new LocalTimeTypeAdapter())
                .create();
        String gsoncontent = gson.toJson(outpostDto2);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/nzoz/outpost")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(gsoncontent))
                .andExpect(MockMvcResultMatchers.status().isOk());
        System.out.println("Testing updating Outpost");
    }

    @DisplayName("when delete Outpost, " +
            "then controller should return ok"
    )
    @Test
    public void testDeleteOutpost() throws Exception {
        //Given

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/nzoz/outpost/1" )
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        System.out.println("Testing deleting Outpost by id");
    }
}