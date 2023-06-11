package com.nzozbackend.domain.Dto;

import com.nzozbackend.domain.Administrator;
import com.nzozbackend.domain.Visit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutpostDto {

    private Long id;
    private String city;
    private Administrator administrator;
    private List<Visit> visits;

    public OutpostDto(String city, Administrator administrator, List<Visit> visits) {
        this.city = city;
        this.administrator = administrator;
        this.visits = visits;
    }
}
