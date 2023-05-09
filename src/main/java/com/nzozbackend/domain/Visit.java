package com.nzozbackend.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "VISITS")
public class Visit {

    @Id
    @NotNull
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "ID", unique = true)
    private Long id;

   @ManyToOne
    @NotNull
   @JoinColumn(name = "PHYSICIAN_ID")
    private Physician physician;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "PATIENT_ID")
    private Patient patient;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "PAYMASTER_ID")
    private Paymaster paymaster;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "OUTPOST_ID")
    private Outpost outpost;

    @NotNull
    @Column(name = "DATE")
    private Date date;

}
