package com.nzozbackend.domain.Dto;

import com.nzozbackend.domain.*;
import com.nzozbackend.domain.VisitSettings.VisitSettlementBasic;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class VisitDto {

    private Long id;
    private Physician physician;
    private Patient patient;
    private Paymaster paymaster;
    private Outpost outpost;
    private LocalDate date;
    private String visitName;
    private LocalTime visitDuration;
    private Settlement settlement;

    public  VisitDto () {
        this.settlement = new Settlement(new VisitSettlementBasic());
    }
}
