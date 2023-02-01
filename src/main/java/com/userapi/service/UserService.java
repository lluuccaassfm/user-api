package com.userapi.service;

import com.userapi.model.User;
import com.userapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAllUsers() {
      return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repository.findById(id);
        return user.get();
    }

    public User findByName(String name) {
        Optional<User> user = repository.findByName(name);
        return user.get();
    }

}
