package com.nzozbackend.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nzozbackend.LocalDateTypeAdapter;
import com.nzozbackend.LocalTimeTypeAdapter;
import com.nzozbackend.domain.*;
import com.nzozbackend.domain.Dto.VisitDto;
import com.nzozbackend.domain.VisitSettings.VisitSettlementBasic;
import com.nzozbackend.domain.VisitSettings.VisitSettlementConfig;
import com.nzozbackend.domain.VisitSettings.VisitSettlementProstate;
import com.nzozbackend.mapper.VisitMapper;
import com.nzozbackend.service.*;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(VisitController.class)
class VisitControllerTest {

    @Autowired
    public MockMvc mockMvc;
    @MockBean
    public VisitService visitService;
    @MockBean
    public PhysicianService physicianService;
    @MockBean
    public PatientService patientService;
    @MockBean
    public PaymasterService paymasterService;
    @MockBean
    public OutpostService outpostService;
    @MockBean
    public VisitMapper visitMapper;
    @MockBean
    public VisitSettlementBasic visitSettlementBasic;
    @MockBean
    public VisitSettlementConfig visitSettlementConfig;
    @MockBean
    public VisitSettlementProstate visitSettlementProstate;

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

    @DisplayName("when create Visit, " +
            "then controller should return ok"
    )
    @Test
    public void testCreateVisit() throws Exception {
        //Given
        VisitDto visitDto = new VisitDto();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .registerTypeAdapter(LocalTime.class, new LocalTimeTypeAdapter())
                .create();

        String gsoncontent = gson.toJson(visitDto);
        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/nzoz/visit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(gsoncontent))
                .andExpect(MockMvcResultMatchers.status().isOk());

        System.out.println("Testing creating new Visit");
    }

    @DisplayName("when get Visits, " +
            "then controller should return list"
    )
    @Test
    public void testGetVisits() throws Exception {
        //Given
        VisitDto visitDto1 = new VisitDto();
        VisitDto visitDto2 = new VisitDto();
        List<VisitDto> visitDtoList = new ArrayList<>();
        visitDtoList.add(visitDto1);
        visitDtoList.add(visitDto2);
        when(visitService.findAllVisitDto()).thenReturn(visitDtoList);
        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/nzoz/visit")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

        System.out.println("Testing getting all Visits");
    }

    @DisplayName("when put Physician, " +
            "then controller should return ok"
    )
    @Test
    public void testAddPhysician() throws Exception {
        //Given
        Visit visit = new Visit();
        List<Visit> visits = new ArrayList<>();
        visits.add(visit);
        Physician physician = new Physician(1L, "Boleslaw", "Surnogi", 123, visits);
        Visit visitEdit = new Visit(1L, new Physician(), new Patient(), new Paymaster(), new Outpost(), LocalDate.now(), "firstVisit", LocalTime.now(),  new Settlement(visitSettlementBasic));
        when(visitService.findVisit(any())).thenReturn(visitEdit);

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .registerTypeAdapter(LocalTime.class, new LocalTimeTypeAdapter())
                .create();
        String gsoncontent = gson.toJson(physician);
        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/nzoz/visit/" + visitEdit.getId() + "/addPhysician/" + physician.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(gsoncontent))
                .andExpect(MockMvcResultMatchers.status().isOk());

        System.out.println("Testing adding Physician");
    }

    @DisplayName("when put Patient, " +
            "then controller should return ok"
    )
    @Test
    public void testAddPatient() throws Exception {
        //Given
        Visit visit = new Visit();
        List<Visit> visits = new ArrayList<>();
        visits.add(visit);
        Patient patient = new Patient(1L, "Dariusz", "Koziol", 12453344, visits);
        Visit visitEdit = new Visit(1L, new Physician(), new Patient(), new Paymaster(), new Outpost(), LocalDate.now(), "firstVisit", LocalTime.now(),  new Settlement(visitSettlementBasic));

        when(visitService.findVisit(any())).thenReturn(visitEdit);

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .registerTypeAdapter(LocalTime.class, new LocalTimeTypeAdapter())
                .create();
        String gsoncontent = gson.toJson(patient);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/nzoz/visit/" + visitEdit.getId() + "/addPatient/" + patient.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(gsoncontent))
                .andExpect(MockMvcResultMatchers.status().isOk());

        System.out.println("Testing adding Patient");
    }

    @DisplayName("when put Paymaster, " +
            "then controller should return ok"
    )
    @Test
    public void testAddPaymaster() throws Exception {
        //Given
        Visit visit = new Visit();
        List<Visit> visits = new ArrayList<>();
        visits.add(visit);
        Paymaster paymaster = new Paymaster(1L, "NFZ", visits);
        Visit visitEdit = new Visit(1L, new Physician(), new Patient(), new Paymaster(), new Outpost(), LocalDate.now(), "firstVisit", LocalTime.now(),  new Settlement(visitSettlementBasic));

        when(visitService.findVisit(any())).thenReturn(visitEdit);

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .registerTypeAdapter(LocalTime.class, new LocalTimeTypeAdapter())
                .create();
        String gsoncontent = gson.toJson(paymaster);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/nzoz/visit/" + visitEdit.getId() + "/addPaymaster/" + paymaster.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(gsoncontent))
                .andExpect(MockMvcResultMatchers.status().isOk());

        System.out.println("Testing adding Paymaster");
    }

    @DisplayName("when put Outpost, " +
            "then controller should return ok"
    )
    @Test
    public void testAddOutpost() throws Exception {
        //Given
        Visit visit = new Visit();
        List<Visit> visits = new ArrayList<>();
        visits.add(visit);
        Outpost outpost = new Outpost(1L, "Warsaw", new Administrator(), visits);
        Visit visitEdit = new Visit(1L, new Physician(), new Patient(), new Paymaster(), new Outpost(), LocalDate.now(), "firstVisit", LocalTime.now(),  new Settlement(visitSettlementBasic));

        when(visitService.findVisit(any())).thenReturn(visitEdit);

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .registerTypeAdapter(LocalTime.class, new LocalTimeTypeAdapter())
                .create();
        String gsoncontent = gson.toJson(outpost);
        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/nzoz/visit/" + visitEdit.getId() + "/addOutpost/" + outpost.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(gsoncontent))
                .andExpect(MockMvcResultMatchers.status().isOk());

        System.out.println("Testing adding Outpost");
    }

    @DisplayName("when put VisitType, " +
            "then controller should return ok"
    )
    @Test
    public void testAddVisitType() throws Exception {
        //Given
        Visit visitEdit = new Visit(1L, new Physician(), new Patient(), new Paymaster(), new Outpost(), LocalDate.now(), "firstVisit", LocalTime.now(), new Settlement(visitSettlementBasic));
        Visit modifiedVisit = new Visit(1L, new Physician(), new Patient(), new Paymaster(), new Outpost(), LocalDate.now(), "firstVisit", LocalTime.now(),  new Settlement(visitSettlementBasic));
      VisitDto visitDto = visitMapper.mapToVisitDto(modifiedVisit);

        when (visitService.findVisit(any())).thenReturn(visitEdit);
        when(visitMapper.mapToVisitDto(any())).thenReturn(visitDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/nzoz/visit/" + visitEdit.getId() + "/addVisitType/" + "Diagnostic")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        System.out.println("Testing adding VisitType");
    }

//    @Test
//    public void testAddVisitSettlement() throws Exception {
//        //Given
//        Settlement settlement = new Settlement(visitSettlementBasic);
//        VisitSettlement settlementProstate = new VisitSettlementProstate(settlement);
//         Visit visitEdit = new Visit(1L, new Physician(), new Patient(), new Paymaster(), new Outpost(), LocalDate.now(), "firstVisit", LocalTime.now(), new Settlement(visitSettlementBasic));
//
//       // visitEdit.setSettlement(settlementProstate);
//       VisitDto visitEditDto = visitMapper.mapToVisitDto(visitEdit);
//        when (visitService.findVisit(any())).thenReturn(visitEdit);
//        when   (visitMapper.mapToVisitDto(any())).thenReturn(visitEditDto);
//
//        //When & Then
//        mockMvc
//                .perform(MockMvcRequestBuilders
//                        .put("/nzoz/visit/" + visitEdit.getId() + "/addVisitSettlement/" + "Prostate")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }

    @DisplayName("when delete Visit, " +
            "then controller should return ok"
    )
    @Test
    public void testDeleteVisit() throws Exception {
        //Given

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/nzoz/visit/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        System.out.println("Testing deleting Visit by id");
    }
}