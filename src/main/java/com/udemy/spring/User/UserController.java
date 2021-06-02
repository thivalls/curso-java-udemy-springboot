package com.udemy.spring.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String index() {
        List<User> userControllers = userRepository.findAll();
        if(userControllers.size() == 0) {
            return "Nenhum usuário cadastrado no banco de dados";
        }
        return userControllers.toString();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UserResponse> store(@RequestBody UserRequest request) {
        userRepository.save(request.toModel());

        return ResponseEntity.ok(new UserResponse(request.getName(), request.getEmail(), request.getPhone(), request.getPassword()));
    }
}
