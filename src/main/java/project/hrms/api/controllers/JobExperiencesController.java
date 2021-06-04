package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.hrms.business.abstracts.JobExperienceService;
import project.hrms.entities.concretes.JobExperience;

@RestController
@RequestMapping("/api/jobexperiences/")
public class JobExperiencesController {

    private JobExperienceService jobExperienceService;

    @Autowired
    public JobExperiencesController(JobExperienceService jobExperienceService) {
        this.jobExperienceService = jobExperienceService;
    }

    @GetMapping("getJobExperiencesByCandidateId")
    public ResponseEntity<?> getJobExperiencesByCandidateId(@RequestParam int candidateId){
        return ResponseEntity.ok(this.jobExperienceService.getJobExperiencesByCandidateId(candidateId));
    }


    @PostMapping("addJobExperience")
    public ResponseEntity<?> addJobExperience(@RequestBody JobExperience jobExperience){
        return ResponseEntity.ok(this.jobExperienceService.addJobExperience(jobExperience));
    }
}
