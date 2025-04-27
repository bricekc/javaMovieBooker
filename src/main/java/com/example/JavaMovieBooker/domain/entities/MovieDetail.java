package com.example.JavaMovieBooker.domain.entities;

import java.util.List;

public class MovieDetail extends Movie {
    private List<Genre> genres;
    private boolean isAdult;
    private String backdropPath;
    private String originalLanguage;
    private String originalTitle;
    private double popularity;
    private double voteAverage;
    private int voteCount;
    private int runtime;

    public MovieDetail() {
        super();
    }

    public MovieDetail(int id, String title, String overview, String posterPath, String releaseDate, List<Genre> genres, boolean isAdult, String backdropPath, String originalLanguage, String originalTitle, double popularity, double voteAverage, int voteCount, int runtime) {
        super(id, title, overview, posterPath, releaseDate);
        this.genres = genres;
        this.isAdult = isAdult;
        this.backdropPath = backdropPath;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.popularity = popularity;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
        this.runtime = runtime;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public void setAdult(boolean adult) {
        isAdult = adult;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public List<Genre> getGenres() {
        return this.genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }
}
