package com.nzozbackend.externalAPI;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class GeolocationConfig {

    @Value("${geolocation.api.uri}")
    private String geolocationApiUri;
    @Value("${geolocation.api.key}")
    private String geolocationApiKey;
    @Value("${geolocation.api.host}")
    private String geolocationApiHost;
}
