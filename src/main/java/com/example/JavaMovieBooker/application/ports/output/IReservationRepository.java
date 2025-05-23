package com.example.JavaMovieBooker.application.ports.output;

import com.example.JavaMovieBooker.domain.entities.Reservation;

import java.util.List;
import java.util.UUID;

public interface IReservationRepository {
    Reservation save(Reservation reservation);
    Reservation findById(UUID id);
    List<Reservation> findAllByUserId(UUID id);
}
