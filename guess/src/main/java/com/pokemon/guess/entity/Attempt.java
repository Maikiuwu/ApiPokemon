package com.pokemon.guess.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "attempts")
public class Attempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAttempt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Column(nullable = false)
    private String pokemonName;

    private String spriteUrl;

    @Column(nullable = false)
    private Timestamp attemptTime = new Timestamp(System.currentTimeMillis());

    // getters and setters
    public Attempt() {
        // Constructor vacío requerido por JPA
    }
    
    public Integer getIdAttempt() {
        return idAttempt;
    }

    public void setIdAttempt(Integer idAttempt) {
        this.idAttempt = idAttempt;
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

    public Timestamp getAttemptTime() {
        return attemptTime;
    }

    public void setAttemptTime(Timestamp attemptTime) {
        this.attemptTime = attemptTime;
    }

    public Attempt(Integer idAttempt, User user, String pokemonName, String spriteUrl, Timestamp attemptTime) {
        this.idAttempt = idAttempt;
        this.user = user;
        this.pokemonName = pokemonName;
        this.spriteUrl = spriteUrl;
        this.attemptTime = attemptTime;
    }
}