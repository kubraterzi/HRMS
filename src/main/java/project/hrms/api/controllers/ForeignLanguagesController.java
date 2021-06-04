package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.hrms.business.abstracts.ForeignLanguageService;
import project.hrms.entities.concretes.ForeignLanguage;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/foreignlanguages/")
public class ForeignLanguagesController {

    private ForeignLanguageService foreignLanguageService;

    @Autowired
    public ForeignLanguagesController(ForeignLanguageService foreignLanguageService) {
        this.foreignLanguageService = foreignLanguageService;
    }

    @GetMapping("getForeignLanguagesByCandidateId")
    public ResponseEntity<?> getForeignLanguagesByCandidateId(@RequestParam int candidateId){
        return ResponseEntity.ok(this.foreignLanguageService.getForeignLanguagesByCandidateId(candidateId));
    }


    @PostMapping("addForeignLanguage")
    public ResponseEntity<?> addForeignLanguage(@RequestBody @Valid ForeignLanguage foreignLanguage){
        return ResponseEntity.ok(this.foreignLanguageService.addForeignLanguage(foreignLanguage));
    }
}
