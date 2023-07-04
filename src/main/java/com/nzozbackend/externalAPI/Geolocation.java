package com.nzozbackend.externalAPI;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
public class Geolocation {
    @Value("${geolocation.api.uri}")
    private String geolocationApiUri;
    @Value("${geolocation.api.key}")
    private String geolocationApiKey;
    @Value("${geolocation.api.host}")
    private String geolocationApiHost;

    public void httRequest() throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(geolocationApiUri))
                .header("X-RapidAPI-Key", geolocationApiKey)
                .header("X-RapidAPI-Host", geolocationApiHost)
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
