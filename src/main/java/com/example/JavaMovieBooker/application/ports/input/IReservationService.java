package com.example.JavaMovieBooker.application.ports.input;

import com.example.JavaMovieBooker.domain.entities.Reservation;
import jakarta.servlet.http.HttpServletRequest;

public interface IReservationService {
    Reservation save(Reservation reservation, HttpServletRequest request);
}
