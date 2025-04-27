package com.example.JavaMovieBooker.web.controllers;

import com.example.JavaMovieBooker.application.services.MovieService;
import com.example.JavaMovieBooker.domain.entities.Genre;
import com.example.JavaMovieBooker.domain.entities.MovieDetail;
import com.example.JavaMovieBooker.domain.entities.MoviePage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

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
    public Mono<MoviePage> getMovies(@RequestParam(required = false) String page) {
        return movieService.getMovies(page);
    }

    @Operation(summary = "Get all genres")
    @GetMapping("/genres")
    public Mono<List<Genre>> getGenres() {
        return movieService.getGenres();
    }

    @Operation(summary = "Get movie details")
    @GetMapping("/{id}")
    public Mono<MovieDetail> getMovieDetail(@PathVariable int id) {
        return movieService.getMovieDetail(id);
    }
}
