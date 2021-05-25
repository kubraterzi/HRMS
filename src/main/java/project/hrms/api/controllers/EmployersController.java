package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.hrms.business.abstracts.EmployerService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.entities.concretes.Employer;

import java.util.List;

@RestController
@RequestMapping("/api/employers/")
public class EmployersController {

    private EmployerService employerService;


    @Autowired
    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }


    @GetMapping("getall")
    public DataResult<List<Employer>> getAll(){
        return employerService.getAll();
    }


    @GetMapping("get")
    public DataResult<Employer> get(int id){
        return employerService.get(id);
    }


    @PostMapping("add")
    public void add(@RequestBody Employer employer){
        employerService.add(employer);
    }


    @PostMapping("delete")
    public void delete(@RequestBody Employer employer){
        employerService.delete(employer);
    }


    @PostMapping("update")
    public void update(@RequestBody Employer employer){
        employerService.update(employer);
    }
}
