package com.nzozbackend.emailservice;

import com.nzozbackend.repository.VisitRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

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