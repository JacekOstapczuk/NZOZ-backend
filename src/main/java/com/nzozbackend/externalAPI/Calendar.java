package com.nzozbackend.externalAPI;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
public class Calendar {


    public void httRequest() throws  Exception{

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://working-days.p.rapidapi.com/1.3/analyse?start_date=2023-06-01&end_date=2023-07-01&country_code=PL&configuration=Federal%20holidays"))
                .header("X-RapidAPI-Key", "e9b976f659msh28325406b177999p12965ajsnca996d1cb9ca")
                .header("X-RapidAPI-Host", "working-days.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
try {
    HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    System.out.println(response.body());
    } catch(IOException e) {log.error("Failed to process HttpResponse: " + e.getMessage(), e);}
}
}
