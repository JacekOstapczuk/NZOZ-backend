package com.nzozbackend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "CITY")
    private String city;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "Administrator_ID")
    private Administrator administrator;

    @OneToMany(
            targetEntity = Visit.class,
            mappedBy = "outpost",
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY
    )
    private List<Visit> visits = new ArrayList<>();
}
