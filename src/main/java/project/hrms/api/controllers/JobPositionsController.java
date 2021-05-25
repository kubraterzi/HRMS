package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.hrms.business.abstracts.JobPositionService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.entities.concretes.JobPosition;

import java.util.List;

@RestController
@RequestMapping("/api/jobpositions/")
public class JobPositionsController {

    private JobPositionService jobPositionService;

    @Autowired
    public JobPositionsController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }


    @GetMapping("getall")
    public DataResult<List<JobPosition>> getAll(){
        return this.jobPositionService.getAll();
    }


    @GetMapping("get")
    public  DataResult<JobPosition> get(int id){
        return this.jobPositionService.getById(id);
    }


    @PostMapping("add")
    public void add(@RequestBody JobPosition jobPosition){
        this.jobPositionService.add(jobPosition);
    }


    @PostMapping("delete")
    public void delete(@RequestBody JobPosition jobPosition){
        this.jobPositionService.delete(jobPosition);
    }


    @PostMapping("update")
    public void update(@RequestBody JobPosition jobPosition){
        this.jobPositionService.update(jobPosition);
    }

}
