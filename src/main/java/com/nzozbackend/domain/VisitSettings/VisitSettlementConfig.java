package com.nzozbackend.domain.VisitSettings;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class VisitSettlementConfig {
    public final VisitSettlement visitSettlement;

    @Bean
    public VisitSettlementCardio visitSettlementCardio(){
        return new VisitSettlementCardio(visitSettlement);
    }

    @Bean
    public VisitSettlementLungs visitSettlementLungs(){
        return new VisitSettlementLungs(visitSettlement);
    }

    @Bean
    public VisitSettlementProstate visitSettlementProstate(){
        return new VisitSettlementProstate(visitSettlement);
    }

}
