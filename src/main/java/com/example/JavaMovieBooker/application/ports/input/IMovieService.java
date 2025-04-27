package com.example.JavaMovieBooker.application.ports.input;

import com.example.JavaMovieBooker.domain.entities.MoviePage;
import reactor.core.publisher.Mono;

public interface IMovieService {
    Mono<MoviePage> getMovies();
}
