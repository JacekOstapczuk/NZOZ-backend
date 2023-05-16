package com.nzozbackend;

import com.nzozbackend.externalAPI.APICalendar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Calendar;

@EnableScheduling
@SpringBootApplication
public class NzozBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(NzozBackendApplication.class, args);

        APICalendar calendar = new APICalendar();
		try {
			calendar.httRequest();
		} catch (Exception e) {
		}

    }
}
