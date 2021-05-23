package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.hrms.business.abstracts.JobPositionService;
import project.hrms.entities.concretes.JobPosition;

import java.util.List;

@Controller
@RequestMapping("/api/jobpositions/")
public class JobPositionsController {

    private JobPositionService jobPositionService;

    @Autowired
    public JobPositionsController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }


    @GetMapping("getall")
    public List<JobPosition> getAll(){
        return jobPositionService.getAll();
    }


    @GetMapping("get")
    public  JobPosition get(int id){
        return jobPositionService.get(id);
    }


    @GetMapping("add")
    public void add(JobPosition jobPosition){
        jobPositionService.add(jobPosition);
    }


    @GetMapping("delete")
    public void delete(JobPosition jobPosition){
        jobPositionService.delete(jobPosition);
    }


    @GetMapping("update")
    public void update(JobPosition jobPosition){
        jobPositionService.update(jobPosition);
    }

}
