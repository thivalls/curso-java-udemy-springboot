package com.udemy.spring.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>> index() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> index(@PathVariable Long id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário não encontrado");
        }
        return ResponseEntity.ok(user.get());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UserResponse> store(@RequestBody UserRequest request) {
        userRepository.save(request.toModel());

        return ResponseEntity.ok(new UserResponse(request.getName(), request.getEmail(), request.getPhone(), request.getPassword()));
    }
}
