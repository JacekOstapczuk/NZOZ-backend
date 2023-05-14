package com.nzozbackend.domain.Dto;

import com.nzozbackend.domain.Administrator;
import com.nzozbackend.domain.Visit;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class OutpostDto {

   private Long id;
    private String city;

    private Administrator administrator;
    private List<Visit> visits;

    public OutpostDto (Long id,  String city, Administrator administrator, List<Visit> visits){
        this.id=id;
        this.city=city;
        this.visits = new ArrayList<>();
    }

}
