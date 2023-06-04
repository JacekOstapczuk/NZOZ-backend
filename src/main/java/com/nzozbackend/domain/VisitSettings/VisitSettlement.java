package com.nzozbackend.domain.VisitSettings;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public interface VisitSettlement {
    BigDecimal getCost();
    String getDescription();
}
