package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.hrms.business.abstracts.UserService;
import project.hrms.entities.concretes.User;

import java.util.List;

@Controller
@RequestMapping("/api/users/")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("getall")
    public List<User> getAll(){
       return userService.getAll();
    }

    @GetMapping("get")
    public User get(int id){
        return userService.get(id);
    }

    @PostMapping("add")
    public void add(User user){
        userService.add(user);
    }

    @PostMapping("delete")
    public void delete(User user){
        userService.delete(user);
    }

    @PostMapping("update")
    public void update(User user){
        userService.update(user);
    }
}
