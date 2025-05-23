package com.pokemon.guess.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import com.pokemon.guess.util.constants.AppConstants;

@Configuration
public class WebClientConfig {
        
    @Bean
    public WebClient webClient() {
        // Configure the WebClient with a maximum in-memory size
        ExchangeStrategies strategies = ExchangeStrategies.builder()
                .codecs(configurer -> configurer
                        .defaultCodecs()
                        .maxInMemorySize(2 * 1024 * 1024)) // 2 MB
                .build();

        return WebClient.builder()
                .baseUrl(AppConstants.BASE_URL_POKE_API)
                .exchangeStrategies(strategies)
                .build();
    }
}
