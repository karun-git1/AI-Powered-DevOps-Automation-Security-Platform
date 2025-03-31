package com.devops.security.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "security_incidents")
public class SecurityIncident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String severity;

    @Column(nullable = false)
    private String affectedService;

    @Column(nullable = false)
    private LocalDateTime detectedAt;

    @Column
    private String description;

    // Default constructor
    public SecurityIncident() {
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getSeverity() {
        return severity;
    }

    public String getAffectedService() {
        return affectedService;
    }

    public LocalDateTime getDetectedAt() {
        return detectedAt;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setAffectedService(String affectedService) {
        this.affectedService = affectedService;
    }

    public void setDetectedAt(LocalDateTime detectedAt) {
        this.detectedAt = detectedAt;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Builder pattern methods
    public SecurityIncident withType(String type) {
        this.type = type;
        return this;
    }

    public SecurityIncident withSeverity(String severity) {
        this.severity = severity;
        return this;
    }

    public SecurityIncident withAffectedService(String affectedService) {
        this.affectedService = affectedService;
        return this;
    }

    public SecurityIncident withDetectedAt(LocalDateTime detectedAt) {
        this.detectedAt = detectedAt;
        return this;
    }

    public SecurityIncident withDescription(String description) {
        this.description = description;
        return this;
    }
}