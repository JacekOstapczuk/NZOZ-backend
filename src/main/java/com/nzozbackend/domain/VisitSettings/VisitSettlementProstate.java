package com.nzozbackend.domain.VisitSettings;

import java.math.BigDecimal;


public class VisitSettlementProstate extends AbstractVisitSettlementDecorator {
    public VisitSettlementProstate(VisitSettlement visitSettlement) {
        super(visitSettlement);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(50));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Prostate examination";
    }
}
