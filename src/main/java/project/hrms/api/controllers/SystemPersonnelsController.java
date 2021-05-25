package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.hrms.business.abstracts.SystemPersonnelService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.entities.concretes.SystemPersonnel;

import java.util.List;

@RestController
@RequestMapping("/api/systempersonnels/")
public class SystemPersonnelsController {

    private SystemPersonnelService systemPersonnelService;

    @Autowired
    public SystemPersonnelsController(SystemPersonnelService systemPersonnelService) {
        this.systemPersonnelService = systemPersonnelService;
    }


    @GetMapping("getall")
    public DataResult<List<SystemPersonnel>> getAll(){
        return systemPersonnelService.getAll();
    }


    @GetMapping("get")
    public DataResult<SystemPersonnel> get(int id){
        return systemPersonnelService.get(id);
    }


    @PostMapping("add")
    public void add(@RequestBody SystemPersonnel systemPersonnel){
        systemPersonnelService.add(systemPersonnel);
    }


    @PostMapping("update")
    public void update(@RequestBody SystemPersonnel systemPersonnel){
        systemPersonnelService.update(systemPersonnel);
    }


    @PostMapping("delete")
    public void delete(@RequestBody SystemPersonnel systemPersonnel){
        systemPersonnelService.delete(systemPersonnel);
    }
}
