package com.nzozbackend.domain;

import com.nzozbackend.domain.VisitSettings.VisitSettlement;
import com.nzozbackend.domain.VisitSettings.VisitSettlementBasic;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SETTLEMENT")
public class Settlement implements VisitSettlement {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "DESCRIPTION")
    private String settlement;

    @Override
    public BigDecimal getCost() {
        return price;
    }

    @Override
    public String getDescription() {
        return settlement;
    }

    public Settlement(VisitSettlementBasic visitSettlementBasic) {
        this.price = visitSettlementBasic.getCost();
        this.settlement = visitSettlementBasic.getDescription();
    }
}
