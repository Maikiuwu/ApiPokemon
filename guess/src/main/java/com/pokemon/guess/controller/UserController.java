package com.pokemon.guess.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pokemon.guess.service.AttemptsService;
import jakarta.validation.Valid;
import com.pokemon.guess.entity.Attempt;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private AttemptsService attemptsService;

    @PostMapping("/score")
    public ResponseEntity<?> registerScore(@Valid @RequestBody Attempt attempt) {
        try {
            Attempt createdAttempt = attemptsService.createAttempt(attempt);
            return ResponseEntity.ok(createdAttempt);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
