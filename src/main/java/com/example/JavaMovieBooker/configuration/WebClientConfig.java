package com.example.JavaMovieBooker.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
@Configuration
public class WebClientConfig {

    @Value("${TMDB_API_KEY}")
    private String apiKey;
    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("https://api.themoviedb.org/3")
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .build();
    }
}

