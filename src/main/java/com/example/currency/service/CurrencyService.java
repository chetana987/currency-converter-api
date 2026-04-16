package com.example.currency.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class CurrencyService {

    @Value("${exchange.api.url}")
    private String apiUrl;

    private RestTemplate restTemplate = new RestTemplate();

    public double convert(String from, String to, double amount) {

        String url = apiUrl + from;

        Map response = restTemplate.getForObject(url, Map.class);
        Map<String, Double> rates = (Map<String, Double>) response.get("rates");

        double rate = rates.get(to);

        return amount * rate;
    }
}