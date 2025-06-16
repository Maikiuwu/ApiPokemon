package com.pokemon.guess.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pokemon.guess.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.pokemon.guess.service.UserService;


@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @PostMapping("/EditUser")
    public User postMethodName(@RequestBody User user) {
        User userEditado = userService.updateUser(user);
        return userEditado;
    }

    @PostMapping("/DeleteUser")
    public void deleteMethodName(@RequestBody User user) {
        userService.deleteUser(user);
    }

}
