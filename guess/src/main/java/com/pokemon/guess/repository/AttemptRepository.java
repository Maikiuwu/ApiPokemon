package com.pokemon.guess.repository;

import com.pokemon.guess.entity.Attempt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttemptRepository extends JpaRepository<Attempt, Integer> {
    
}
