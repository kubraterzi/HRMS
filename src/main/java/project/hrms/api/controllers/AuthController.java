package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.hrms.business.abstracts.AuthService;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Candidate;
import project.hrms.entities.dtos.RegisterForCandidateAuthDto;
import project.hrms.entities.dtos.RegisterForEmployerAuthDto;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("registerForEmployer")
    public Result registerForEmployer(@RequestBody RegisterForEmployerAuthDto registerForEmployerAuthDto){
        return this.authService.registerForEmployer(registerForEmployerAuthDto);
    }

    @PostMapping("registerForCandidate")
    public Result registerForCandidate(@RequestBody RegisterForCandidateAuthDto registerForCandidateAuthDto){
        return this.authService.registerForCandidate(registerForCandidateAuthDto);
    }
}
