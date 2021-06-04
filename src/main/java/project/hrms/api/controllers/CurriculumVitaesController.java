package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.hrms.business.abstracts.CurriculumVitaeService;
import project.hrms.entities.concretes.CurriculumVitae;

@RestController
@RequestMapping("/api/curriculumvitaes/")
public class CurriculumVitaesController {

    private CurriculumVitaeService curriculumVitaeService;

    @Autowired
    public CurriculumVitaesController(CurriculumVitaeService curriculumVitaeService) {
        this.curriculumVitaeService = curriculumVitaeService;
    }


    @GetMapping("getCurriculumVitaesByCandidateId")
    public ResponseEntity<?> getCurriculumVitaesByCandidateId(@RequestParam int candidateId){
        return ResponseEntity.ok(this.curriculumVitaeService.getCurriculumVitaesByCandidateId(candidateId));
    }


    @PostMapping("addCurriculumVitae")
    public ResponseEntity<?> addCurriculumVitae(@RequestBody CurriculumVitae curriculumVitae){
        return ResponseEntity.ok(this.curriculumVitaeService.addCurriculumVitae(curriculumVitae));
    }
}
