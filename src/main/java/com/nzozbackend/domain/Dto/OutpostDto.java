package com.nzozbackend.domain.Dto;

import com.nzozbackend.domain.Visit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class OutpostDto {

   private Long id;
    private String City;
    private List<Visit> Visit;
}
