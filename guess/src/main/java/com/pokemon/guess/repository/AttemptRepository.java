package com.pokemon.guess.repository;

import com.pokemon.guess.entity.Attempt;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AttemptRepository extends JpaRepository<Attempt, Integer> {

    @Query("SELECT a.pokemonName FROM Attempt a WHERE a.user.idUser = :userId ORDER BY a.attemptTime DESC")
    List<String> findTop5PokemonNamesByUserId(@Param("userId") Integer userId);

}
