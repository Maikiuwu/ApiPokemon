package com.pokemon.guess.entity;

import java.io.Serializable;
import java.util.Objects;

/*Cuando usas en una entidad dos claves primarias (como idUser e idPokemon en PokemonFound), eso se llama clave compuesta. Spring JPA necesita saber cómo identificar una fila de forma única, y eso lo haces con la anotación @IdClass.

🔧 Pero para que funcione, tienes que crear una clase que represente esa clave compuesta, y esa clase es justo PokemonFoundId. */
public class PokemonFoundId implements Serializable {
    private Integer idUser;
    private Integer idPokemon;

    public PokemonFoundId() {}

    public PokemonFoundId(Integer idUser, Integer idPokemon) {
        this.idUser = idUser;
        this.idPokemon = idPokemon;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokemonFoundId that = (PokemonFoundId) o;
        return Objects.equals(idUser, that.idUser) &&
               Objects.equals(idPokemon, that.idPokemon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, idPokemon);
    }
}