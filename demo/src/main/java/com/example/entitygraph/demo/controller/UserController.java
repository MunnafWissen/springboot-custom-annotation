package com.example.entitygraph.demo.controller;

import com.example.entitygraph.demo.model.User;
import com.example.entitygraph.demo.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @RequestMapping("/users")
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }
}
