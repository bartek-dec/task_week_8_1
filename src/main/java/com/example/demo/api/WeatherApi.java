package com.example.demo.api;

import com.example.demo.domain.api.WeatherForecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class WeatherApi {

    @Value("${baseUrl}")
    private String baseUrl;
    @Value("${key}")
    private String key;
    @Value("${keyValue}")
    private String keyValue;
    @Value("${q}")
    private String q;
    @Value("${location}")
    private String location;
    @Value("${langParam}")
    private String langParam;
    @Value("${langValue}")
    private String langValue;

    private RestTemplate restTemplate;

    @Autowired
    public WeatherApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherForecast getWeatherForecast() {
        UriComponentsBuilder url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam(key, keyValue)
                .queryParam(q, location)
                .queryParam(langParam, langValue);

        return restTemplate.getForObject(url.toUriString(), WeatherForecast.class);
    }
}
