package com.devops.devops.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pipeline_runs")
public class PipelineRun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String pipelineName;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column
    private LocalDateTime endTime;

    @Column
    private String logUrl;

    // Default constructor
    public PipelineRun() {
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getPipelineName() {
        return pipelineName;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getLogUrl() {
        return logUrl;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setPipelineName(String pipelineName) {
        this.pipelineName = pipelineName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setLogUrl(String logUrl) {
        this.logUrl = logUrl;
    }

    // Builder pattern methods for fluent API
    public PipelineRun withPipelineName(String pipelineName) {
        this.pipelineName = pipelineName;
        return this;
    }

    public PipelineRun withStatus(String status) {
        this.status = status;
        return this;
    }

    public PipelineRun withStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    public PipelineRun withEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
        return this;
    }

    public PipelineRun withLogUrl(String logUrl) {
        this.logUrl = logUrl;
        return this;
    }
}