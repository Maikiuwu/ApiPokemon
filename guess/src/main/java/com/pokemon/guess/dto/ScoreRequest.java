package com.pokemon.guess.dto;

public class ScoreRequest {
    private Integer user_id;
    private String pokemon_name;
    private String sprite_url;
    private int attempts;

    // Getters and setters
    public Integer getUserId() {
        return user_id;
    }
    public void setUserId(Integer user_id) {
        this.user_id = user_id;
    }
    public String getPokemonName() {
        return pokemon_name;
    }
    public void setPokemonName(String pokemon_name) {
        this.pokemon_name = pokemon_name;
    }
    public String getSpriteUrl() {
        return sprite_url;
    }
    public void setSpriteUrl(String sprite_url) {
        this.sprite_url = sprite_url;
    }
    public int getAttempts() {
        return attempts;
    }
    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }
}