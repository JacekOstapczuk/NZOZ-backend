package com.nzozbackend.externalAPI;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
public class APICalendar {

    @Value("${calendar.api.uri}")
    private String calendarApiUri;
    @Value("${calendar.api.key}")
    private String calendarApiKey;
    @Value("${calendar.api.host}")
    private String calendarApiHost;

    public void httRequest() throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(calendarApiUri))
                .header("X-RapidAPI-Key", calendarApiKey)
                .header("X-RapidAPI-Host", calendarApiHost)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException e) {
            log.error("Failed to process HttpResponse: " + e.getMessage(), e);
        }
    }
}
