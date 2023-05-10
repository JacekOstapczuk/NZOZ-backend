package com.nzozbackend.scheduler;

import com.nzozbackend.emailservice.DailyVisitSummaryMail;
import com.nzozbackend.emailservice.SimpleEmail;
import com.nzozbackend.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VisitScheduler {
    public final SimpleEmail simpleEmail;
    private final VisitRepository visitRepository;



   @Scheduled(cron = " * * 7 * * MON-FRI")
    public void sendInformationEmail() {
        long size =visitRepository.count();
       DailyVisitSummaryMail dailyVisitSummaryMail =  new DailyVisitSummaryMail();
       String message = dailyVisitSummaryMail.getMessage();
       String actualMessage = message + " " + size;
       dailyVisitSummaryMail.setMessage(actualMessage);
        simpleEmail.send(
                dailyVisitSummaryMail);
    }



}
