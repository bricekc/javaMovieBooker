package com.example.JavaMovieBooker.infrastructure.adapters.input.rest.mapper;


import com.example.JavaMovieBooker.domain.entities.Movie;
import com.example.JavaMovieBooker.infrastructure.adapters.input.rest.dto.TmdbMovieResponse;

public class MovieMapper {

    public static Movie mapToMovie(TmdbMovieResponse.Result result) {
        return new Movie(
                result.getId(),
                result.getTitle(),
                result.getOverview(),
                result.getPoster_path(),
                result.getRelease_date()
        );
    }
}