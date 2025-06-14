package com.pokemon.guess.service;

import com.pokemon.guess.entity.Attempt;
import com.pokemon.guess.repository.AttemptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttemptsService {

    @Autowired
    private AttemptRepository attemptRepository;

    public Attempt createAttempt(Attempt attempt) {
        return attemptRepository.save(attempt);
    }

}
