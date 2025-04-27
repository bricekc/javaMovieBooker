package com.example.JavaMovieBooker.infrastructure.adapters.input.rest.mapper;

import com.example.JavaMovieBooker.domain.entities.Genre;
import com.example.JavaMovieBooker.infrastructure.adapters.input.rest.dto.TmdbGenreResponse;

import java.util.List;
import java.util.stream.Collectors;

public class GenreMapper {

    public static Genre mapToGenre(TmdbGenreResponse.GenreDto genreDto) {
        return new Genre(genreDto.getId(), genreDto.getName());
    }

    public static List<Genre> mapToGenreList(List<TmdbGenreResponse.GenreDto> genreDtoList) {
        return genreDtoList.stream()
                .map(GenreMapper::mapToGenre)
                .collect(Collectors.toList());
    }
}
