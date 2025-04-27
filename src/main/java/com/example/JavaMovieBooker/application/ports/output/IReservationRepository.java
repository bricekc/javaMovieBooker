package com.example.JavaMovieBooker.application.ports.output;

import com.example.JavaMovieBooker.domain.entities.Reservation;

public interface IReservationRepository {
    void save(Reservation reservation);
}
