package com.devops.ai.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;
import java.time.LocalDateTime;

@Document(collection = "ai_logs")
public class AILog {
    @Id
    private String id;
    
    @Indexed
    private String service;
    
    private String logMessage;
    
    @Indexed
    private LocalDateTime timestamp;
    
    private String threatPrediction;
    
    private Double confidenceScore;

    // Default constructor
    public AILog() {
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getService() {
        return service;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getThreatPrediction() {
        return threatPrediction;
    }

    public Double getConfidenceScore() {
        return confidenceScore;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setThreatPrediction(String threatPrediction) {
        this.threatPrediction = threatPrediction;
    }

    public void setConfidenceScore(Double confidenceScore) {
        this.confidenceScore = confidenceScore;
    }

    // Builder pattern methods
    public AILog withService(String service) {
        this.service = service;
        return this;
    }

    public AILog withLogMessage(String logMessage) {
        this.logMessage = logMessage;
        return this;
    }

    public AILog withTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public AILog withThreatPrediction(String threatPrediction) {
        this.threatPrediction = threatPrediction;
        return this;
    }

    public AILog withConfidenceScore(Double confidenceScore) {
        this.confidenceScore = confidenceScore;
        return this;
    }
}