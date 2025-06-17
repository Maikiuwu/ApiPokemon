package com.pokemon.guess.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "favorite")
public class Favorite {

    @Id
    private Integer idUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Column(nullable = false)
    private String pokemonName;

    private String spriteUrl;

    public Favorite() {
        // Constructor vacío requerido por JPA
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public String getSpriteUrl() {
        return spriteUrl;
    }

    public void setSpriteUrl(String spriteUrl) {
        this.spriteUrl = spriteUrl;
    }

    public Favorite(User user, String pokemonName, String spriteUrl) {
        this.user = user;
        this.pokemonName = pokemonName;
        this.spriteUrl = spriteUrl;
    }

}