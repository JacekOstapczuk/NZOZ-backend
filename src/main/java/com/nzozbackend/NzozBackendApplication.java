package com.nzozbackend;

import com.nzozbackend.externalAPI.Calendar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class NzozBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(NzozBackendApplication.class, args);

//		Calendar calendar = new Calendar();
//		try {
//			calendar.httRequest();
//		} catch (Exception e) {
//		}

	}
}
