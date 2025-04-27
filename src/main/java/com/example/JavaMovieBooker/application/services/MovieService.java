package com.example.JavaMovieBooker.application.services;

import com.example.JavaMovieBooker.application.ports.input.IMovieService;
import com.example.JavaMovieBooker.domain.entities.Genre;
import com.example.JavaMovieBooker.domain.entities.MovieDetail;
import com.example.JavaMovieBooker.domain.entities.MoviePage;
import com.example.JavaMovieBooker.infrastructure.adapters.input.rest.dto.TmdbGenreResponse;
import com.example.JavaMovieBooker.infrastructure.adapters.input.rest.dto.TmdbMovieDetailResponse;
import com.example.JavaMovieBooker.infrastructure.adapters.input.rest.dto.TmdbMovieResponse;
import com.example.JavaMovieBooker.infrastructure.adapters.input.rest.mapper.GenreMapper;
import com.example.JavaMovieBooker.infrastructure.adapters.input.rest.mapper.MovieDetailMapper;
import com.example.JavaMovieBooker.infrastructure.adapters.input.rest.mapper.MovieMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService {
    private final WebClient webClient;

    public MovieService(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<MoviePage> getMovies(String page) {
        String uri = "/movie/popular";
        if (page != null && !page.isEmpty()) {
            uri += "?page=" + page;
        }
        return webClient.get()
                .uri(uri)
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

    @Override
    public Mono<List<Genre>> getGenres() {
        return webClient.get()
                .uri("/genre/movie/list")
                .retrieve()
                .bodyToMono(TmdbGenreResponse.class)
                .map(tmdbGenreResponse -> GenreMapper.mapToGenreList(tmdbGenreResponse.getGenres()));

    }

    @Override
    public Mono<MovieDetail> getMovieDetail(int id) {
        return webClient.get()
                .uri("/movie/" + id)
                .retrieve()
                .bodyToMono(TmdbMovieDetailResponse.class)
                .map(MovieDetailMapper::mapToMovieDetail);
    }
}
