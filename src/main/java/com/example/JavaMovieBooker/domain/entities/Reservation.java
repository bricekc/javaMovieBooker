package com.example.JavaMovieBooker.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class Reservation {
    private UUID id;

    private Long movieId;

    private LocalDateTime reservationDate;

    private UUID userId;

    public Reservation() {}

    public Reservation(Long movieId, LocalDateTime reservationDate, UUID userId) {
        this.movieId = movieId;
        this.reservationDate = reservationDate;
        this.userId = userId;
    }

    public Reservation(UUID id, Long movieId, LocalDateTime reservationDate, UUID userId) {
        this.id = id;
        this.movieId = movieId;
        this.reservationDate = reservationDate;
        this.userId = userId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
