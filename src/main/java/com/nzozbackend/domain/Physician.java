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
@Table(name = "PHYSICIANS")
public class Physician {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "SURNAME")
    private String surname;

    @NotNull
    @Column(name = "PWZ", unique = true)
    private Integer pwz;

    @OneToMany(
            targetEntity = Visit.class,
            mappedBy = "physician",
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY
    )
    private List<Visit> visits = new ArrayList<>();
}