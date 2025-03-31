package com.devops.ai.controller;

import com.devops.ai.entity.AILog;
import com.devops.ai.repository.AILogRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AIController {

    private final AILogRepository repository;

    public AIController(AILogRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/logs")
    public List<AILog> getAllLogs() {
        return repository.findAll();
    }

    @GetMapping("/logs/{service}")
    public List<AILog> getLogsByService(@PathVariable String service) {
        return repository.findByService(service);
    }

    @PostMapping("/logs")
    public ResponseEntity<AILog> createLog(@RequestBody AILog log) {
        log.setTimestamp(LocalDateTime.now());
        return ResponseEntity.ok(repository.save(log));
    }

    @GetMapping("/logs/threat/{prediction}")
    public List<AILog> getLogsByThreatPrediction(@PathVariable String prediction) {
        return repository.findByThreatPrediction(prediction);
    }

    @GetMapping("/logs/confidence/{threshold}")
    public List<AILog> getHighConfidenceLogs(@PathVariable Double threshold) {
        return repository.findByConfidenceScoreGreaterThan(threshold);
    }

    @GetMapping("/logs/timerange")
    public List<AILog> getLogsByTimeRange(
            @RequestParam LocalDateTime start,
            @RequestParam LocalDateTime end) {
        return repository.findByTimestampBetween(start, end);
    }
}