package com.pokemon.guess.entity;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;

public class Favorite {
    @JoinColumn(name = "id_user", nullable = false)
    private Integer userId;
    @Column(name = "pokemon_name", nullable = false)
    private String pokemonName;
    private String spriteUrl;

    public Integer  getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPokemonName() {
        return pokemonName;
    }
    
    public String getSpriteUrl() {
        return spriteUrl;
    }

    public void setSpriteUrl(String spriteUrl) {
        this.spriteUrl = spriteUrl;
    }
    
    public String setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
        return pokemonName;
    }


}
