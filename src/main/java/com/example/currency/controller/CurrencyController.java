package com.example.currency.controller;

import com.example.currency.entity.ConversionHistory;
import com.example.currency.repository.ConversionRepository;
import com.example.currency.service.CurrencyService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CurrencyController {

    private final CurrencyService service;
    private final ConversionRepository repo;

    @Value("${api.key}")
    private String apiKey;

    public CurrencyController(CurrencyService service, ConversionRepository repo) {
        this.service = service;
        this.repo = repo;
    }

    // 🔐 Simple API Key Check
    private void validateKey(String key) {
        if (!apiKey.equals(key)) {
            throw new RuntimeException("Invalid API Key");
        }
    }

    // 💱 Convert Currency
    @GetMapping("/convert")
    public double convert(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam double amount,
            @RequestHeader("x-api-key") String key) {

        validateKey(key);

        double result = service.convert(from, to, amount);

        ConversionHistory history = new ConversionHistory();
        history.setFromCurrency(from);
        history.setToCurrency(to);
        history.setAmount(amount);
        history.setConvertedAmount(result);
        history.setTimestamp(LocalDateTime.now());

        repo.save(history);

        return result;
    }

    // 📜 Get History
    @GetMapping("/history")
    public List<ConversionHistory> getHistory(@RequestHeader("x-api-key") String key) {
        validateKey(key);
        return repo.findAll();
    }
}