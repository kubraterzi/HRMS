package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.hrms.business.abstracts.UserService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.entities.concretes.User;

import java.util.List;

@RestController
@RequestMapping("/api/users/")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("get")
    public DataResult<User> get(int id) {
        return userService.get(id);
    }

    @PostMapping("add")
    public void add(@RequestBody User user) {
        userService.add(user);
    }

}
