package com.trustcoodes.jobAppSimpleLogic.JobLayer.Controller;

import com.trustcoodes.jobAppSimpleLogic.JobLayer.Entity.JobEntity;
import com.trustcoodes.jobAppSimpleLogic.JobLayer.Service.JobAppService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/jobs")
public class JobAppController {

    private final JobAppService jobAppService;


    @GetMapping
    public ResponseEntity<List<JobEntity>> findAllJobs() {
        return ResponseEntity.ok(jobAppService.findAllJobs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobEntity> findJobById(@PathVariable Long id) {
        JobEntity jobber = jobAppService.findJobById(id);
        if (jobber != null) {
            return new ResponseEntity<>(jobber, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<String> addJob (@RequestBody JobEntity jobEntities){
        jobAppService.addJob(jobEntities);
        return new ResponseEntity<>("Job Published", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean jobRemoved = jobAppService.removeJobById(id);
        if (jobRemoved) {
            return new ResponseEntity<>("Job Deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable Long id, @RequestBody JobEntity entities){
        boolean entityUpdated = jobAppService.updateJobById(id, entities);
        if (entityUpdated) {
            return new ResponseEntity<>("Job Updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("ERROR: No Related Data Found For this ID", HttpStatus.NOT_FOUND);
        }

}
}