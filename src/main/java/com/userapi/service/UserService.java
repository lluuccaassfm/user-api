package com.userapi.service;

import com.userapi.model.User;
import com.userapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private static final String NOT_FOUND_USER = "Nenhum usuário encontrado";

    @Autowired
    private UserRepository repository;

    public List<User> findAllUsers() {
      return repository.findAll();
    }

    public User findById(String id) throws Exception {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new Exception(NOT_FOUND_USER));
    }

    public User findByCodUser(Long codUser) throws Exception {
        Optional<User> user = repository.findByCodUser(codUser);
        return user.orElseThrow(() -> new Exception(NOT_FOUND_USER));
    }

    public User findByName(String name) throws Exception {
        Optional<User> user = repository.findByName(name);
        return user.orElseThrow(() -> new Exception(NOT_FOUND_USER));
    }

    public User createUser(User newUser) {
        return repository.save(newUser);
    }

    public void updateUser(User user) {
        repository.save(user);
    }

    public String deleteUser(String id) {
        repository.deleteById(id);
        return "Usuário excluído com sucesso !!!";
    }

}
