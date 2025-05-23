package com.pokemon.guess.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.pokemon.guess.service.PokeApiService;

@RestController()
@RequestMapping("/api/pokemon")
public class PokemonController {

    @Autowired
    private PokeApiService pokeApiService;

    @GetMapping("/random")
    public ResponseEntity<?> getRandomPokemon() {
        return ResponseEntity.ok(pokeApiService.getRandomPokemon());
    }
}
