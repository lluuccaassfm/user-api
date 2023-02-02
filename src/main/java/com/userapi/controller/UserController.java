package com.userapi.controller;

import com.userapi.model.User;
import com.userapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping()
    public ResponseEntity<List<User>> findAllUsers() {
        return ResponseEntity.ok(service.findAllUsers());
    }

    @GetMapping("/by-id/{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // Busca por Query Param
    @GetMapping("/by-name")
    public ResponseEntity<User> findByName(@RequestParam(value = "name") String name) {
        return ResponseEntity.ok(service.findByName(name));
    }

}
