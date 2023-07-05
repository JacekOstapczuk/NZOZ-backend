package com.nzozbackend.externalAPI;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class CalendarConfig {

    @Value("${calendar.api.uri}")
    private String calendarApiUri;
    @Value("${calendar.api.key}")
    private String calendarApiKey;
    @Value("${calendar.api.host}")
    private String calendarApiHost;
}
