package com.nzozbackend.domain.Dto;

import com.nzozbackend.domain.Visit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {

    private Long id;
    private String name;
    private String surname;
    private Integer pesel;
    private List<Visit> visits;
}
