package com.nzozbackend.domain.VisitSettings;

import com.nzozbackend.domain.Visit;

import java.time.LocalTime;

public enum VisitType {
    INSTANCE;

    public Visit setFirstVisit (Visit visit){
        visit.setVisitName("first visit");
        visit.setVisitDuration(LocalTime.of(0, 30, 0));
        return visit;
    }

    public void  setFollowUpVisit(Visit visit){
        visit.setVisitName("follow-up visit");
        visit.setVisitDuration(LocalTime.of(0, 15, 0));
    }

    public void  setDiagnosticVisit (Visit visit){
        visit.setVisitName("diagnostic visit");
        visit.setVisitDuration(LocalTime.of(1, 0, 0));
    }
}
