package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.hrms.business.abstracts.CandidateService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.entities.concretes.Candidate;

import java.util.List;

@RestController
@RequestMapping("/api/candidates/")
public class CandidatesController {

    private CandidateService candidateService;

    @Autowired
    public CandidatesController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("getall")
    public DataResult<List<Candidate>> getAll(){
        return this.candidateService.getAll();
    }

    @GetMapping("get")
    public DataResult<Candidate> get(int id){
        return this.candidateService.get(id);
    }

    @PostMapping("add")
    public void add(@RequestBody Candidate candidate){
        candidateService.add(candidate);
    }

    @PostMapping("delete")
    public void delete(@RequestBody Candidate candidate){
        candidateService.delete(candidate);
    }

    @PostMapping("update")
    public void update(@RequestBody Candidate candidate){
        candidateService.update(candidate);
    }
}
