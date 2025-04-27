package com.example.JavaMovieBooker.web.controllers;

import com.example.JavaMovieBooker.application.services.MovieService;
import com.example.JavaMovieBooker.domain.entities.MoviePage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movies")
@Tag(name = "Movies", description = "Movies API")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @Operation(summary = "Get all movies")
    @GetMapping("")
    public Mono<MoviePage> getMovies() {
        return movieService.getMovies();
    }
}
