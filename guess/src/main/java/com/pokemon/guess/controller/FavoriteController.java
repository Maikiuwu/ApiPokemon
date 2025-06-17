package com.pokemon.guess.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.pokemon.guess.entity.Favorite;
import com.pokemon.guess.service.FavoriteService;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @PostMapping("/favourite")
    public ResponseEntity<Favorite> guardarFavorito(@RequestBody Favorite favorite) {        
        Favorite newfavorite = favoriteService.addFavorite(favorite.getUser(), favorite.getPokemonName(), favorite.getSpriteUrl());
        return ResponseEntity.ok(newfavorite);
    }

    @PostMapping("/removeFavourite")
    public ResponseEntity<String> eliminarFavorito(@RequestBody Favorite favorite) {
        try {
            favoriteService.removeFavorite(favorite.getUser().getIdUser(), favorite.getPokemonName());
            return ResponseEntity.ok("Favorito eliminado correctamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    
}
