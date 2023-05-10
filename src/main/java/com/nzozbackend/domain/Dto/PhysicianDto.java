package com.nzozbackend.domain.Dto;

import com.nzozbackend.domain.Visit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class PhysicianDto {

    private Long id;
    private String name;
    private  String surname;
    private  Integer pwz;
    private List<Visit> visits;

    public PhysicianDto (Long id, String name, String surname, Integer pwz, List<Visit>visits){
        this.id=id;
        this.name=name;
        this.surname=surname;
        this.pwz=pwz;
        this.visits = new ArrayList<>();
    }
}
