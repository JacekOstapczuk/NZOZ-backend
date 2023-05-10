package com.nzozbackend.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "VISITS")
public class Visit {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "PHYSICIAN_ID")
    private Physician physician;


    @ManyToOne
    @JoinColumn(name = "PATIENT_ID")
    public Patient patient;


    @ManyToOne
    @JoinColumn(name = "PAYMASTER_ID")
    private Paymaster paymaster;


    @ManyToOne
    @JoinColumn(name = "OUTPOST_ID")
    private Outpost outpost;

    @Column(name = "DATE", unique = true)
    private Date date;

    @NotNull
    public Visit (Date date){
        this.date=date;
    }

}
