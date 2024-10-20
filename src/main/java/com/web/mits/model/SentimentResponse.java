package com.web.mits.model;

public class SentimentResponse {
    private String sentiment;

    public SentimentResponse(String sentiment) {
        this.sentiment = sentiment;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }
}