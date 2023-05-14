package com.nzozbackend.domain.VisitSettings;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class VisitSettlementBasic implements VisitSettlement {

    @Override
    public BigDecimal getCost() {
        return new BigDecimal(100.00);
    }

    @Override
    public String getDescription() {
        return "Basic diagnostic";
    }
}
