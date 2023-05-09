package com.nzozbackend.domain.Dto;

import com.nzozbackend.domain.Outpost;
import com.nzozbackend.domain.Patient;
import com.nzozbackend.domain.Paymaster;
import com.nzozbackend.domain.Physician;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class VisitDto {

    private Long id;
    private Physician physician;
    private Patient patient;
    private Paymaster paymaster;
    private Outpost outpost;
    private Date date;
}
