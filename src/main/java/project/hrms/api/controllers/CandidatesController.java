package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.hrms.business.abstracts.CandidateService;
import project.hrms.entities.concretes.Candidate;

import java.util.List;

@Controller
@RequestMapping("/api/candidates/")
public class CandidatesController {

    private CandidateService candidateService;

    @Autowired
    public CandidatesController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("getall")
    public List<Candidate> getAll(){
        return candidateService.getAll();
    }

    @GetMapping("get")
    public Candidate get(int id){
        return candidateService.get(id);
    }

    @PostMapping("add")
    public void add(Candidate candidate){
        candidateService.add(candidate);
    }

    @PostMapping("delete")
    public void delete(Candidate candidate){
        candidateService.delete(candidate);
    }

    @PostMapping("update")
    public void update(Candidate candidate){
        candidateService.update(candidate);
    }
}
