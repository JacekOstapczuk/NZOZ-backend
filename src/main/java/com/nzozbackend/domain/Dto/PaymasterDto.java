package com.nzozbackend.domain.Dto;

import com.nzozbackend.domain.Visit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@Data
public class PaymasterDto {

    private Long id;
    private String Name;
    private List<Visit> Visit;
}
