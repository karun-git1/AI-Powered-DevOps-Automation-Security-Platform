package com.devops.devops.controller;

import com.devops.devops.entity.PipelineRun;
import com.devops.devops.repository.PipelineRunRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class DevOpsController {

    private final PipelineRunRepository repository;

    public DevOpsController(PipelineRunRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/pipelines")
    public List<PipelineRun> getAllPipelines() {
        return repository.findAll();
    }

    @GetMapping("/pipelines/{status}")
    public List<PipelineRun> getPipelinesByStatus(@PathVariable String status) {
        return repository.findByStatus(status);
    }

    @PostMapping("/pipelines")
    public ResponseEntity<PipelineRun> createPipeline(@RequestBody PipelineRun pipelineRun) {
        pipelineRun.setStartTime(LocalDateTime.now());
        pipelineRun.setStatus("IN_PROGRESS");
        return ResponseEntity.ok(repository.save(pipelineRun));
    }

    @GetMapping("/pipelines/name/{pipelineName}")
    public List<PipelineRun> getPipelinesByName(@PathVariable String pipelineName) {
        return repository.findByPipelineName(pipelineName);
    }

    @PutMapping("/pipelines/{id}/complete")
    public ResponseEntity<PipelineRun> completePipeline(@PathVariable Long id, @RequestParam String status) {
        return repository.findById(id)
                .map(pipeline -> {
                    pipeline.setStatus(status);
                    pipeline.setEndTime(LocalDateTime.now());
                    return ResponseEntity.ok(repository.save(pipeline));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}