package com.udemy.spring.services;

import com.udemy.spring.entities.User;
import com.udemy.spring.entities.request.UserRequest;
import com.udemy.spring.repositories.UserRepository;
import com.udemy.spring.services.exceptions.DatabaseException;
import com.udemy.spring.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
        try {
            userRepository.delete(user);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }
}
