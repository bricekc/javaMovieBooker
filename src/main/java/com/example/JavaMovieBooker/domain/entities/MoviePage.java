package com.example.JavaMovieBooker.domain.entities;
import java.util.List;

public class MoviePage {
    private int page;
    private int totalPages;
    private int totalResults;
    private List<Movie> movies;

    public MoviePage() {}

    public MoviePage(int page, int totalPages, int totalResults, List<Movie> movies) {
        this.page = page;
        this.totalPages = totalPages;
        this.totalResults = totalResults;
        this.movies = movies;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}

