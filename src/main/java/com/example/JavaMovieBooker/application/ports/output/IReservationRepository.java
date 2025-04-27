package com.example.JavaMovieBooker.application.ports.output;

import com.example.JavaMovieBooker.domain.entities.Reservation;

import java.util.UUID;

public interface IReservationRepository {
    Reservation save(Reservation reservation);
    Reservation findById(UUID id);
}
