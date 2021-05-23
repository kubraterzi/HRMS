package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.hrms.business.abstracts.SystemPersonnelService;
import project.hrms.entities.concretes.SystemPersonnel;

import java.util.List;

@Controller
@RequestMapping("/api/systempersonnels/")
public class SystemPersonnelsController {

    private SystemPersonnelService systemPersonnelService;

    @Autowired
    public SystemPersonnelsController(SystemPersonnelService systemPersonnelService) {
        this.systemPersonnelService = systemPersonnelService;
    }


    @GetMapping("getall")
    public List<SystemPersonnel> getAll(){
        return systemPersonnelService.getAll();
    }


    @GetMapping("get")
    public SystemPersonnel get(int id){
        return systemPersonnelService.get(id);
    }


    @GetMapping("add")
    public void add(SystemPersonnel systemPersonnel){
        systemPersonnelService.add(systemPersonnel);
    }


    @GetMapping("update")
    public void update(SystemPersonnel systemPersonnel){
        systemPersonnelService.update(systemPersonnel);
    }


    @GetMapping("delete")
    public void delete(SystemPersonnel systemPersonnel){
        systemPersonnelService.delete(systemPersonnel);
    }
}
