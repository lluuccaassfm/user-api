package com.userapi.service;

import com.userapi.exception.NotFoundException;
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

    public User findById(String id) throws NotFoundException {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(NotFoundException::new);
    }

    public User findByCodUser(Long codUser) throws NotFoundException {
        Optional<User> user = repository.findByCodUser(codUser);
        return user.orElseThrow(NotFoundException::new);
    }

    public User findByName(String name) throws NotFoundException {
        Optional<User> user = repository.findByName(name);
        return user.orElseThrow(NotFoundException::new);
    }

    public User createUser(User newUser) {
        return repository.insert(newUser);
    }

    public void updateUser(User user) {
        repository.save(user);
    }

    public String deleteUser(String id) {
        repository.deleteById(id);
        return "Usuário excluído com sucesso !!!";
    }

}
