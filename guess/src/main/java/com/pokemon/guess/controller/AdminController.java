package com.pokemon.guess.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pokemon.guess.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.pokemon.guess.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.pokemon.guess.repository.UserRepository;



@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/EditUser")
    public User postMethodName(@RequestBody User user) {
        User userEditado = userService.updateUser(user);
        return userEditado;
    }

    @PostMapping("/DeleteUser")
    public void deleteMethodName(@RequestBody User user) {
        userService.deleteUser(user);
    }

    @GetMapping("/GetUser")
    public ResponseEntity<List<User>> listUsers() {
        List<User> users = userRepository.findAllByIdUserNotOrderByIdUserAsc(1);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/GetUserByUsername")
    public ResponseEntity<User> getUserByUsername(@RequestParam String username) {
        User user = userRepository.findByUsername(username);
        return ResponseEntity.ok(user);
    }

}
