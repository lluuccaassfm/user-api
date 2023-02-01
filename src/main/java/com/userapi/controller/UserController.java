package com.userapi.controller;

import com.userapi.model.User;
import com.userapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;


    // TODO: Utilizar 'ResponseEntity'
    @GetMapping()
    public List<User> findAllUsers() {
        return service.findAllUsers();
    }

    @GetMapping("/by-id/{id}")
    public User findById(@PathVariable String id) {
        return service.findById(id);
    }

    @GetMapping("/by-name")
    public User findByName(@RequestParam(value = "name") String name) {
        return service.findByName(name);
    }

}
