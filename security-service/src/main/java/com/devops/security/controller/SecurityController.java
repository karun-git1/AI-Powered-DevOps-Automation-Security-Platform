package com.devops.security.controller;

import com.devops.security.entity.SecurityIncident;
import com.devops.security.repository.SecurityIncidentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SecurityController {

    private final SecurityIncidentRepository repository;

    public SecurityController(SecurityIncidentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/incidents")
    public List<SecurityIncident> getAllIncidents() {
        return repository.findAll();
    }

    @GetMapping("/incidents/{severity}")
    public List<SecurityIncident> getIncidentsBySeverity(@PathVariable String severity) {
        return repository.findBySeverity(severity);
    }

    @PostMapping("/incidents")
    public ResponseEntity<SecurityIncident> createIncident(@RequestBody SecurityIncident incident) {
        incident.setDetectedAt(LocalDateTime.now());
        return ResponseEntity.ok(repository.save(incident));
    }

    @GetMapping("/incidents/type/{type}")
    public List<SecurityIncident> getIncidentsByType(@PathVariable String type) {
        return repository.findByType(type);
    }

    @GetMapping("/incidents/service/{service}")
    public List<SecurityIncident> getIncidentsByService(@PathVariable String service) {
        return repository.findByAffectedService(service);
    }

    @PutMapping("/incidents/{id}")
    public ResponseEntity<SecurityIncident> updateIncident(@PathVariable Long id, @RequestBody SecurityIncident incident) {
        return repository.findById(id)
                .map(existingIncident -> {
                    existingIncident.setSeverity(incident.getSeverity());
                    existingIncident.setDescription(incident.getDescription());
                    return ResponseEntity.ok(repository.save(existingIncident));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}