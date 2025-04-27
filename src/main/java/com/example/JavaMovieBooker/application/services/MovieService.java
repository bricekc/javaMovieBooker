package com.example.JavaMovieBooker.application.services;

import com.example.JavaMovieBooker.application.ports.input.IMovieService;
import com.example.JavaMovieBooker.domain.entities.MoviePage;
import com.example.JavaMovieBooker.infrastructure.adapters.input.rest.dto.TmdbMovieResponse;
import com.example.JavaMovieBooker.infrastructure.adapters.input.rest.mapper.MovieMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService {
    private final WebClient webClient;

    public MovieService(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<MoviePage> getMovies() {
        return webClient.get()
                .uri("/movie/popular")
                .retrieve()
                .bodyToMono(TmdbMovieResponse.class)
                .map(tmdbResponse -> new MoviePage(
                        tmdbResponse.getPage(),
                        tmdbResponse.getTotal_pages(),
                        tmdbResponse.getTotal_results(),
                        tmdbResponse.getResults().stream()
                                .map(MovieMapper::mapToMovie)
                                .collect(Collectors.toList())
                ));
    }

}
