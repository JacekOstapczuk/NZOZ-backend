package com.nzozbackend.domain;

import com.nzozbackend.domain.VisitSettings.VisitSettlement;
import com.nzozbackend.domain.VisitSettings.VisitSettlementBasic;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
@Data
@AllArgsConstructor
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
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "PAYMASTER_ID")
    private Paymaster paymaster;

    @ManyToOne
    @JoinColumn(name = "OUTPOST_ID")
    private Outpost outpost;

    @Column(name = "DATE")
    private LocalDate date;

    @Column(name = "VISIT_NAME")
    private String visitName;

    @Column(name = "VISIT_DURATION")
    private LocalTime visitDuration;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "VISIT_SETTLEMENT")
    private Settlement settlement;

    public Visit () {
        this.settlement = new Settlement( new VisitSettlementBasic());
    }

    public void setSettlement(VisitSettlement visitSettlement) {
       settlement.setPrice(visitSettlement.getCost());
       settlement.setSettlement(visitSettlement.getDescription());
    }
}