package com.pokemon.guess.repository;
import com.pokemon.guess.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
    import java.util.List;
import com.pokemon.guess.entity.User;
public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
    Favorite findByUserIdUserAndPokemonName(Integer userId, String pokemonName);
    void delete(Favorite favorite);
// FavoriteRepository.java
Favorite findByUserAndPokemonName(User user, String pokemonName);

List<Favorite> findByUser(User user);
}
