package com.nzozbackend.domain.Dto;

import com.nzozbackend.domain.Visit;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class PatientDto {

    private Long id;
    private String name;
    private String surname;
    private Integer pesel;
    private List<Visit> visits;

    public PatientDto(Long id, String name, String surname, Integer pesel, List<Visit> visits) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.visits = new ArrayList<>();
    }
}
