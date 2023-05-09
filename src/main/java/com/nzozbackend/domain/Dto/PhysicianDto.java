package com.nzozbackend.domain.Dto;

import com.nzozbackend.domain.Visit;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PhysicianDto {

    private Long id;
    private String Name;
    private  String Surname;
    private  int PWZ;
    private List<Visit> Visit;
}
