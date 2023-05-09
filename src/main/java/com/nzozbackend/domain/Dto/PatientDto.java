package com.nzozbackend.domain.Dto;

import com.nzozbackend.domain.Visit;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PatientDto {

    private Long id;
    private  String Name;
    private  String Surname;
    private int PESEL;
    private List<Visit> Visit;
}
