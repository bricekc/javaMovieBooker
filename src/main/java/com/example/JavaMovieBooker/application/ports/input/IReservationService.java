package com.example.JavaMovieBooker.application.ports.input;

import com.example.JavaMovieBooker.domain.entities.Reservation;
import jakarta.servlet.http.HttpServletRequest;

import java.util.UUID;

public interface IReservationService {
    Reservation save(Reservation reservation, HttpServletRequest request);
    Reservation findById(UUID id, HttpServletRequest request);
}
