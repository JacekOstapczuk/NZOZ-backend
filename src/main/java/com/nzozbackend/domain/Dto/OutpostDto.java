package com.nzozbackend.domain.Dto;

import com.nzozbackend.domain.Administrator;
import com.nzozbackend.domain.Visit;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OutpostDto {

    private Long id;
    private String city;
    private Administrator administrator;
    private List<Visit> visits;
}
