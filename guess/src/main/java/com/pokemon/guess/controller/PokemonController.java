package com.pokemon.guess.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.pokemon.guess.service.PokeApiService;
import java.util.Map;

@RestController()
@RequestMapping("/api/pokemon")
public class PokemonController {

    @Autowired
    private PokeApiService pokeApiService;
    Object currentPokemon;

    @GetMapping("/random")
    public ResponseEntity<?> getRandomPokemon() {
     currentPokemon = pokeApiService.getRandomPokemon();
    return ResponseEntity.ok(currentPokemon);
}
@RequestMapping("/guess/{pokemonName}")
    public ResponseEntity<?> guessPokemon(String pokemonName) {
        if (currentPokemon == null) {
            return ResponseEntity.badRequest().body("No current Pokemon to guess.");
        }

        String currentPokemonName = (String) ((Map<?, ?>) currentPokemon).get("name");
        boolean isCorrect = currentPokemonName.equalsIgnoreCase(pokemonName);

        Map<String, Object> response = Map.of(
            "correct", isCorrect,
            "currentPokemonName", currentPokemonName
        );

        return ResponseEntity.ok(response);
    }
}
