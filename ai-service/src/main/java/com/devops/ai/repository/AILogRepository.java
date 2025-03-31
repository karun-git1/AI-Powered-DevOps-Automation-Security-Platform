package com.devops.ai.repository;

import com.devops.ai.entity.AILog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AILogRepository extends MongoRepository<AILog, String> {
    List<AILog> findByService(String service);
    List<AILog> findByThreatPrediction(String threatPrediction);
    List<AILog> findByConfidenceScoreGreaterThan(Double threshold);
    List<AILog> findByTimestampBetween(LocalDateTime start, LocalDateTime end);
    List<AILog> findByServiceAndThreatPrediction(String service, String threatPrediction);
}