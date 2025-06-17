package com.pokemon.guess.service;

import org.springframework.stereotype.Service;
import com.pokemon.guess.entity.Favorite;
import com.pokemon.guess.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    public Favorite addFavorite(Integer userId, String pokemonId,String url) {
        Favorite favorite = new Favorite();
        favorite.setUserId(userId);
        favorite.setPokemonName(pokemonId);
        favorite.setSpriteUrl(url);
        return favoriteRepository.save(favorite);
    }

    public void removeFavorite(Integer userId, String pokemonId) {
        Favorite favorite = favoriteRepository.findByUserIdAndPokemonName(userId, pokemonId);
        if (favorite != null) {
            favoriteRepository.delete(favorite);
        } else {
            throw new RuntimeException("Favorito no encontrado para el usuario y Pokémon especificados.");
        }
    }

}
