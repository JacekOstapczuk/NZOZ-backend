package com.nzozbackend.domain.Dto;

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
    private List<Visit> visits;

    public OutpostDto (Long id,  String city,  List<Visit> visits){
        this.id=id;
        this.city=city;
        this.visits = new ArrayList<>();
    }

}
