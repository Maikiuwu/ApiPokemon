package com.pokemon.guess.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pokemons_found")
@IdClass(PokemonFoundId.class)
public class PokemonFound {

    @Id
    @Column(name = "id_user")
    private Integer idUser;

    @Id
    @Column(name = "id_pokemon")
    private Integer idPokemon;

    @Column(name = "pokemon_name", nullable = false)
    private String pokemonName;

    public PokemonFound() {
        // Constructor vacío requerido por JPA
    }

    public PokemonFound(Integer idUser, Integer idPokemon, String pokemonName) {
        this.idUser = idUser;
        this.idPokemon = idPokemon;
        this.pokemonName = pokemonName;
    }

    // Getters y Setters
    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(Integer idPokemon) {
        this.idPokemon = idPokemon;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }
}
