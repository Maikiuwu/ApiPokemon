package com.pokemon.guess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pokemon.guess.entity.User;
import java.util.Optional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    Optional<User> findByUsernameAndPassword(String username, String password);
    List<User> findTop10ByOrderByScoreDesc();
    List<User> findAll();
    User findByUsername(String username);

}
