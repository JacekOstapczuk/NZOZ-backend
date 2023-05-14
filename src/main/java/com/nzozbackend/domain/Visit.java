package com.nzozbackend.domain;

import com.nzozbackend.domain.VisitSettings.VisitSettlementBasic;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Date;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "VISITS")
public class Visit  {

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

    @Column(name = "DATE")
    private Date date;

    @Column(name = "VISIT_NAME")
    private String visitName;

    @Column(name = "VISIT_DURATION")
    private LocalTime visitDuration;


    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "DESCRIPTION")
    private String description;

    @NotNull
    public Visit(Date date) {
        this.date = date;
    }
}