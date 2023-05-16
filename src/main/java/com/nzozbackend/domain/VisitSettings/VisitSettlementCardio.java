package com.nzozbackend.domain.VisitSettings;

import java.math.BigDecimal;

public class VisitSettlementCardio extends AbstractVisitSettlementDecorator {
    public VisitSettlementCardio(VisitSettlement visitSettlement) {
        super(visitSettlement);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(100));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Heart examination";
    }
}
