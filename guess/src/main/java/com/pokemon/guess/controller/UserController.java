package com.pokemon.guess.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pokemon.guess.service.AttemptsService;
import jakarta.validation.Valid;
import com.pokemon.guess.entity.Attempt;
import com.pokemon.guess.repository.UserRepository;
import com.pokemon.guess.entity.User;
import java.util.List;
import com.pokemon.guess.repository.AttemptRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private AttemptsService attemptsService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AttemptRepository attemptsRepository;

    @PostMapping("/updatescore")
        public ResponseEntity<?> registerScore(@Valid @RequestBody User user) {
        try {
            Integer userId = user.getIdUser();
            User updatedUser = attemptsService.plusScore(userId);
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/score")
    public ResponseEntity<?> registerAttempt(@Valid @RequestBody Attempt attempt) {
        try {
            Attempt createdAttempt = attemptsService.createAttempt(attempt);
            return ResponseEntity.ok(createdAttempt);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/ranking")
    public ResponseEntity<List<User>> getRanking() {
        List<User> ranking = userRepository.findTop10ByOrderByScoreDesc();
        return ResponseEntity.ok(ranking);
    }

    @PostMapping("/last")
    public ResponseEntity<List<String>> getLastAttempts(@RequestBody User user) {
        Integer userId = user.getIdUser();
        List<String> lastAttempts = attemptsRepository.findTop5PokemonNamesByUserId(userId);
        return ResponseEntity.ok(lastAttempts);
    }
    
}
