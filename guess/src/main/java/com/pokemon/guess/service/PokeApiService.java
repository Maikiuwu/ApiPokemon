package com.pokemon.guess.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.*;
import com.pokemon.guess.util.constants.AppConstants;

@Service
public class PokeApiService {

    @Autowired
    private WebClient webClient;

    private final Set<Integer> usedIds = new HashSet<>();
    private final Random random = new Random();
    
    public Map<String, Object> getRandomPokemon() {
        if (usedIds.size() >= AppConstants.MAX_POKEMON_ID) {
            // Reiniciar si ya se usaron todos
            usedIds.clear();
        }

        int id;
        do {
            id = random.nextInt(AppConstants.MAX_POKEMON_ID) + 1; // entre 1 y AppConstants.MAX_POKEMON_ID
        } while (usedIds.contains(id));

        usedIds.add(id);

        return getPokemonById(id);
    }

    public Map<String, Object> getPokemonById(int id) {
        try {
            JsonNode response = webClient.get()
                    .uri("/pokemon/{id}", id)
                    .retrieve()
                    .bodyToMono(JsonNode.class)
                    .block();

            int pokemonId = response.get("id").asInt();
            String name = response.get("name").asText();
            String image = response
                    .path("sprites")
                    .path("other")
                    .path("official-artwork")
                    .path("front_default")
                    .asText();

            List<String> types = new ArrayList<>();
            for (JsonNode typeNode : response.path("types")) {
                String typeName = typeNode.path("type").path("name").asText();
                types.add(typeName);
            }

            Map<String, Object> result = new LinkedHashMap<>();
            result.put("id", pokemonId);
            result.put("name", name);
            result.put("image", image);
            result.put("types", types);

            return result;
        } catch (Exception e) {
            System.out.println("Error al obtener el Pokémon: " + e.getMessage());
            return Collections.emptyMap();
        }
    }
}
