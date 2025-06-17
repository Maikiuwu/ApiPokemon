package com.pokemon.guess.service;

import org.springframework.stereotype.Service;
import com.pokemon.guess.entity.Favorite;
import com.pokemon.guess.repository.FavoriteRepository;
import com.pokemon.guess.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import com.pokemon.guess.entity.User;
import java.util.List;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    // FavoriteService.java
    @Autowired
    private UserRepository userRepository;

   
public Favorite addFavorite(User user, String pokemonName, String url) {
    User existingUser = userRepository.findById(user.getIdUser())
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    // Verifica si ya existe el favorito
    Favorite existingFavorite = favoriteRepository.findByUserAndPokemonName(existingUser, pokemonName);
    if (existingFavorite != null) {
        throw new RuntimeException("Este Pokémon ya está en tus favoritos.");
    }

    Favorite favorite = new Favorite();
    favorite.setUser(existingUser);
    favorite.setPokemonName(pokemonName);
    favorite.setSpriteUrl(url);
    return favoriteRepository.save(favorite);
}

    public void removeFavorite(Integer userId, String pokemonId) {
        Favorite favorite = favoriteRepository.findByUserIdUserAndPokemonName(userId, pokemonId);
        if (favorite != null) {
            favoriteRepository.delete(favorite);
        } else {
            throw new RuntimeException("Favorito no encontrado para el usuario y Pokémon especificados.");
        }
    }

    public List<Favorite> getFavoritesByUser(User user) {
        return favoriteRepository.findByUser(user);
    }
}
