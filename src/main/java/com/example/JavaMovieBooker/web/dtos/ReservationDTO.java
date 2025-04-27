package com.example.JavaMovieBooker.web.dtos;

import com.example.JavaMovieBooker.domain.entities.Reservation;

import java.time.LocalDateTime;
import java.util.UUID;

public class ReservationDTO {
    private UUID id;
    private Long movieId;
    private LocalDateTime reservationDate;
    private UUID userId;

    public ReservationDTO() {}

    public ReservationDTO(UUID id, Long movieId, LocalDateTime reservationDate, UUID userId) {
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

    public static ReservationDTO fromDomain(Reservation reservation) {
        return new ReservationDTO(
                reservation.getId(),
                reservation.getMovieId(),
                reservation.getReservationDate(),
                reservation.getUserId()
        );
    }
}
