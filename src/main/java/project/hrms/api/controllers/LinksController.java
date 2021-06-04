package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.hrms.business.abstracts.LinkService;
import project.hrms.entities.concretes.Link;

@RestController
@RequestMapping("/api/links/")
public class LinksController {

    private LinkService linkService;

    @Autowired
    public LinksController(LinkService linkService) {
        this.linkService = linkService;
    }


    @GetMapping("getLinksByCandidateId")
    public ResponseEntity<?> getLinksByCandidateId(@RequestParam int candidateId){
        return ResponseEntity.ok(this.linkService.getLinksByCandidateId(candidateId));
    }


    @PostMapping("addLink")
    public ResponseEntity<?> addLink(@RequestBody Link link){
        return ResponseEntity.ok(this.linkService.addLink(link));
    }
}
