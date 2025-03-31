package com.devops.devops.repository;

import com.devops.devops.entity.PipelineRun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PipelineRunRepository extends JpaRepository<PipelineRun, Long> {
    List<PipelineRun> findByStatus(String status);
    List<PipelineRun> findByPipelineName(String pipelineName);
    List<PipelineRun> findByPipelineNameAndStatus(String pipelineName, String status);
}