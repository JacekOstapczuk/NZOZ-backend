package com.nzozbackend.domain.VisitSettings;

import java.math.BigDecimal;

public class VisitSettlementLungs extends AbstractVisitSettlementDecorator {
    public VisitSettlementLungs(VisitSettlement visitSettlement) {
        super(visitSettlement);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(50));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Lungs examination";
    }
}
