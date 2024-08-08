package com.example.project0807.controller;

import com.example.project0807.dto.UserForm;
import com.example.project0807.entity.User;
import com.example.project0807.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> users() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User user(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping("/users/new")
    public ResponseEntity<User> create(@RequestBody UserForm dto) {
        User user = dto.toEntity();
        if (user.getId() != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        else {
            User added = userRepository.save(user);
            return ResponseEntity.status(HttpStatus.OK).body(added);
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id) {
        User target = userRepository.findById(id).orElse(null);
        if (target == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        else {
            userRepository.delete(target);

            return ResponseEntity.status(HttpStatus.OK).body(target);
        }
    }
}
