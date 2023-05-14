package com.nzozbackend.domain.VisitSettings;

import java.math.BigDecimal;

public class AbstractVisitSettlementDecorator implements VisitSettlement {
    private final VisitSettlement visitSettlement;

    protected AbstractVisitSettlementDecorator (VisitSettlement visitSettlement){
        this.visitSettlement=visitSettlement;
    }

    @Override
    public BigDecimal getCost() {
        return visitSettlement.getCost();
    }

    @Override
    public String getDescription() {
        return visitSettlement.getDescription();
    }
}
