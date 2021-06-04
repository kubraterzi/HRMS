package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.hrms.business.abstracts.SkillService;
import project.hrms.entities.concretes.Skill;

@RestController
@RequestMapping("/api/skills/")
public class SkillsController {

    private SkillService skillService;

    @Autowired
    public SkillsController(SkillService skillService) {
        this.skillService = skillService;
    }


    @GetMapping("getSkillsByCandidateId")
    public ResponseEntity<?> getSkillsByCandidateId(@RequestParam int candidateId){
        return ResponseEntity.ok(this.skillService.getSkillsByCandidateId(candidateId));
    }


    @PostMapping("addSkill")
    public ResponseEntity<?> addSkill(@RequestBody Skill skill){
        return ResponseEntity.ok(this.skillService.addSkill(skill));
    }
}
