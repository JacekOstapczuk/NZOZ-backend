package com.nzozbackend.emailservice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DailyVisitSummaryMail {

    private String mailTo;
    private String subject;
    private String message;

    public DailyVisitSummaryMail() {
        this.mailTo = "jacekostapczuk86@gmail.com";
        this.subject = "Number of Visit";
        this.message = "Actual number of registered visit: ";
    }
}