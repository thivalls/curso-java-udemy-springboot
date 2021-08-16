package com.udemy.spring.services;

import com.udemy.spring.entities.User;
import com.udemy.spring.entities.request.UserRequest;
import com.udemy.spring.repositories.UserRepository;
import com.udemy.spring.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User newUser) {
        return userRepository.save(newUser);
    }

    public void remove(User user) {
        userRepository.delete(user);
    }

    public User update(Long id, UserRequest request) {
        User updatedUser = request.toModel();
        updatedUser.setId(id);
        return userRepository.save(updatedUser);
    }
}
