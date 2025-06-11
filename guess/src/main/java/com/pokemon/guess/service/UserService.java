package com.pokemon.guess.service;

import com.pokemon.guess.entity.User;
import com.pokemon.guess.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("El nombre de usuario ya está en uso.");
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("El correo ya está en uso.");
        }
        return userRepository.save(user);
    }
    public User login(String username, String password) {
    return userRepository.findByUsernameAndPassword(username, password)
            .orElseThrow(() -> new RuntimeException("Credenciales inválidas"));
}

}
