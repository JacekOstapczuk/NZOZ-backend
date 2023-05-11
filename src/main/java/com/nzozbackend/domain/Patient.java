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
@Table(name = "PATIENTS")
public class Patient {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "NAME")
    private  String name;

    @NotNull
    @Column(name = "SURNAME")
    private  String surname;

    @NotNull
    @Column(name = "PESEL", unique = true)
    private Integer pesel;

    @OneToMany(
            targetEntity = Visit.class,
            mappedBy = "patient",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Visit> visits = new ArrayList<>();

   public Patient( String name, String surname, Integer pesel) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
    }

}
