package com.nzozbackend.externalAPI;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
public class Geolocation  {

    public void httRequest() throws  Exception{


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://wft-geo-db.p.rapidapi.com/v1/geo/adminDivisions?location=Olsztyn"))
                .header("X-RapidAPI-Key", "e9b976f659msh28325406b177999p12965ajsnca996d1cb9ca")
                .header("X-RapidAPI-Host", "wft-geo-db.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        try {
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        } catch(IOException e) {log.error("Failed to process HttpResponse: " + e.getMessage(), e);}
    }

}
