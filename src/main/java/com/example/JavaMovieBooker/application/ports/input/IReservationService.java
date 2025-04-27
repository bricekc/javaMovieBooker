package com.example.JavaMovieBooker.application.ports.input;

import com.example.JavaMovieBooker.domain.entities.Reservation;

public interface IReservationService {
    Reservation save(Reservation reservation);
}
