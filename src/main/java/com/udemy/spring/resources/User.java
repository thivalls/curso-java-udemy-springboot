package com.udemy.spring.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("users")
public class User {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String index() {
        List<User> users = userRepository.findAll();
        if(users.size() == 0) {
            return "Nenhum usuário cadastrado no banco de dados";
        }
        return users.toString();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UserResponse> store(@RequestBody UserRequest request) {
        userRepository.save(request.toModel());

        return ResponseEntity.ok(new UserResponse(request.getName(), request.getEmail(), request.getPhone(), request.getPassword()));
    }
}
