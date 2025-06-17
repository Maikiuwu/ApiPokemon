package com.pokemon.guess.repository;
import com.pokemon.guess.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;



public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
 Favorite findByUserIdAndPokemonName(Integer userId, String pokemonName);
    void delete(Favorite favorite);
}
