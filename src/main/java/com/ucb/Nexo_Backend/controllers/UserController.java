package com.ucb.Nexo_Backend.controllers;

import com.ucb.Nexo_Backend.models.User;
import com.ucb.Nexo_Backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class UserController {

    private UserService service;
    @Autowired
    public void setServices(UserService service){
        this.service=service;
    }

    @GetMapping(value = "/user/{userId}")
    public List<User> getUserBy(@PathVariable int userId){
        return this.service.getByUserId(userId);
    }

}
