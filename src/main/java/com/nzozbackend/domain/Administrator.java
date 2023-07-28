package com.nzozbackend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;


@NoArgsConstructor
@Data
@Entity
@Table(name = "ADMINISTRATOR")
public class Administrator {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "SURNAME")
    private String surname;

    public Administrator (String surname) {
        this.surname=surname;
    }
}
