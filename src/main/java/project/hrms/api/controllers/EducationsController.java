package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.hrms.business.abstracts.EducationService;
import project.hrms.entities.concretes.Education;

@RestController
@RequestMapping("/api/educations/")
public class EducationsController {

    private EducationService educationService;

    @Autowired
    public EducationsController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping("getAllSchoolsByCandidateId")
    public ResponseEntity<?> getAllSchoolsByCandidateId(@RequestParam int candidateId){
        return ResponseEntity.ok(this.educationService.getAllEducationsByCandidateId(candidateId));
    }


    @PostMapping("addEducation")
    public ResponseEntity<?> addEducation(@RequestBody Education education){
        return ResponseEntity.ok(this.educationService.addEducation(education));
    }
}
