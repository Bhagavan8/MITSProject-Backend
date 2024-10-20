package com.web.mits.controller;


import org.springframework.web.bind.annotation.*;

import com.web.mits.model.SentimentRequest;
import com.web.mits.model.SentimentResponse;

@RestController
@RequestMapping("/api")
public class SentimentController {

    @PostMapping("/sentiment")
    public SentimentResponse getSentiment(@RequestBody SentimentRequest request) {
        String text = request.getText();
        // Here you can integrate any AI/ML library or API to analyze the sentiment.
        // For demonstration, we'll just return a dummy sentiment.
        String sentiment = analyzeSentiment(text);
        return new SentimentResponse(sentiment);
    }

    private String analyzeSentiment(String text) {
        if (text.contains("happy") || text.contains("good")) {
            return "Positive";
        } else if (text.contains("sad") || text.contains("bad")) {
            return "Negative";
        } else {
            return "Neutral";
        }
    }
}
