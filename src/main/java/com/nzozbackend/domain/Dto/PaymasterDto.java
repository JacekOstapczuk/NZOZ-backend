package com.nzozbackend.domain.Dto;

import com.nzozbackend.domain.Visit;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class PaymasterDto {

    private Long id;
    private String name;
    private List<Visit> visits;

    public PaymasterDto(Long id, String name, List<Visit> visits) {
        this.id = id;
        this.name = name;
        this.visits = new ArrayList<>();
    }
}
