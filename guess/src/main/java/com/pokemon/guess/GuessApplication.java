package com.pokemon.guess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class GuessApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuessApplication.class, args);
	}

	@GetMapping("/")
    public String hello() {
        return "Hello, World!";
    }

}
