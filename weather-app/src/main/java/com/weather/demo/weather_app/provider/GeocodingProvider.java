package com.weather.demo.weather_app.provider;

import com.weather.demo.weather_app.domain.CityCoordinates;
import com.weather.demo.weather_app.domain.WeatherRequestDetails;
import com.weather.demo.weather_app.entity.GeocodingCoordinatesEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GeocodingProvider {

    @Value("${api.key}")
    private String apiKey;

    @Value("${geocoding.url}")
    private String geocodingUrl;

    public GeocodingCoordinatesEntity getCoordinates(final WeatherRequestDetails weatherRequestDetails) throws Exception {
        // geocoding api call

        RestTemplate restTemplate = new RestTemplate();

        final ResponseEntity<GeocodingCoordinatesEntity[]> responseEntity;

        HttpEntity<String> requestEntity = new HttpEntity<>((String) null); // dude

        UriComponents uri = UriComponentsBuilder.fromUriString(geocodingUrl)
                .queryParam("q", weatherRequestDetails.getCity())
                .queryParam("limit", "1")
                .queryParam("appid", apiKey)
                .build();

        try{
            responseEntity = restTemplate.exchange(
                    uri.toUriString(),
                    HttpMethod.GET,
                    requestEntity,
                    GeocodingCoordinatesEntity[].class);

        }catch(HttpStatusCodeException e){
            throw new Exception(e.getMessage());
        }

        if (responseEntity.getBody() != null) {
            return responseEntity.getBody()[0];
        }
        else{
            return null;
        }
    }
}
