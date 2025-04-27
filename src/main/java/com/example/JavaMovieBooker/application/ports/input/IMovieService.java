package com.example.JavaMovieBooker.application.ports.input;

import com.example.JavaMovieBooker.domain.entities.Genre;
import com.example.JavaMovieBooker.domain.entities.MovieDetail;
import com.example.JavaMovieBooker.domain.entities.MoviePage;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IMovieService {
    Mono<MoviePage> getMovies(String page);
    Mono<List<Genre>> getGenres();
    Mono<MovieDetail> getMovieDetail(int id);
    Mono<MoviePage> searchMovies(String query, String page);
}
