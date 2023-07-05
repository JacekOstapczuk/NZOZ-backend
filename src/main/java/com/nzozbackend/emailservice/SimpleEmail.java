package com.nzozbackend.emailservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SimpleEmail {
    private final JavaMailSender javaMailSender;

    public void send(final DailyVisitSummaryMail dailyVisitSummaryMail) {
        log.info("Starting email preparation...");
        try {
            SimpleMailMessage mailMessage = createMailMessage(dailyVisitSummaryMail);

            javaMailSender.send(mailMessage);
            log.info("Email has been sent.");
        } catch (MailException e) {
            log.error("Failed to process email sending: " + e.getMessage(), e);
        }
    }

    private SimpleMailMessage createMailMessage(final DailyVisitSummaryMail dailyVisitSummaryMail) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(dailyVisitSummaryMail.getMailTo());
        mailMessage.setSubject(dailyVisitSummaryMail.getSubject());
        mailMessage.setText(dailyVisitSummaryMail.getMessage());
        return mailMessage;
    }
}