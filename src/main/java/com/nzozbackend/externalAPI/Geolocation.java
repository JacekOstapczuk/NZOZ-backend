package com.nzozbackend.externalAPI;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
@RequiredArgsConstructor
public class Geolocation {

    private final GeolocationConfig geolocationConfig;

    public void httRequest() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(geolocationConfig.getGeolocationApiUri()))
                .header("X-RapidAPI-Key", geolocationConfig.getGeolocationApiKey())
                .header("X-RapidAPI-Host", geolocationConfig.getGeolocationApiHost())
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
