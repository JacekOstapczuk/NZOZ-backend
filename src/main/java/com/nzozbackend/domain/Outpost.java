package com.nzozbackend.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OUTPOSTS")
public class Outpost {

    @Id
    @NotNull
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "CITY")
    private String City;


    @OneToMany(
            targetEntity = Visit.class,
            mappedBy = "outpost",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.EAGER
    )
    private List<Visit> Visit = new ArrayList<>();

}
