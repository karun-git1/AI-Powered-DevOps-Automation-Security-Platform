package com.devops.security.repository;

import com.devops.security.entity.SecurityIncident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SecurityIncidentRepository extends JpaRepository<SecurityIncident, Long> {
    List<SecurityIncident> findBySeverity(String severity);
    List<SecurityIncident> findByType(String type);
    List<SecurityIncident> findByAffectedService(String affectedService);
    List<SecurityIncident> findByDetectedAtBetween(LocalDateTime start, LocalDateTime end);
    List<SecurityIncident> findBySeverityAndType(String severity, String type);
}