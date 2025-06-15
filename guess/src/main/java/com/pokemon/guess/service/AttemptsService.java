package com.pokemon.guess.service;

import com.pokemon.guess.entity.Attempt;
import com.pokemon.guess.entity.User;
import com.pokemon.guess.repository.AttemptRepository;
import com.pokemon.guess.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttemptsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AttemptRepository attemptRepository;

    public Attempt createAttempt(Attempt attempt) {
        return attemptRepository.save(attempt);
    }

    public User plusScore(User user) {
        if (user.getScore() < 0) {
            throw new RuntimeException("El puntaje no puede ser negativo.");
        }
        user.setScore(user.getScore() + 1);
        return userRepository.save(user);
    }

}
