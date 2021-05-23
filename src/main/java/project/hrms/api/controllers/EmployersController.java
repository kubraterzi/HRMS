package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.hrms.business.abstracts.EmployerService;
import project.hrms.entities.concretes.Employer;

import java.util.List;

@Controller
@RequestMapping("/api/employers/")
public class EmployersController {

    private EmployerService employerService;


    @Autowired
    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }


    @GetMapping("getall")
    public List<Employer> getAll(){
        return employerService.getAll();
    }


    @GetMapping("get")
    public Employer get(int id){
        return employerService.get(id);
    }


    @GetMapping("add")
    public void add(Employer employer){
        employerService.add(employer);
    }


    @GetMapping("delete")
    public void delete(Employer employer){
        employerService.delete(employer);
    }


    @GetMapping("update")
    public void update(Employer employer){
        employerService.update(employer);
    }
}
