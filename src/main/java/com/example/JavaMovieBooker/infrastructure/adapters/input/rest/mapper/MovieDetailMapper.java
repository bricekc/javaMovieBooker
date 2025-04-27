package com.example.JavaMovieBooker.infrastructure.adapters.input.rest.mapper;

import com.example.JavaMovieBooker.domain.entities.Genre;
import com.example.JavaMovieBooker.domain.entities.MovieDetail;
import com.example.JavaMovieBooker.infrastructure.adapters.input.rest.dto.TmdbMovieDetailResponse;

public class MovieDetailMapper {
    public static MovieDetail mapToMovieDetail(TmdbMovieDetailResponse response) {
        return new MovieDetail(
                response.getId(),
                response.getTitle(),
                response.getOverview(),
                response.getPoster_path(),
                response.getRelease_date(),
                GenreMapper.mapToGenreList(response.getGenres()),
                response.isAdult(),
                response.getBackdrop_path(),
                response.getOriginal_language(),
                response.getOriginal_title(),
                response.getPopularity(),
                response.getVote_average(),
                response.getVote_count(),
                response.getRuntime()

        );
    }
}
