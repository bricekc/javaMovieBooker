package com.example.JavaMovieBooker.application.ports.input;

import com.example.JavaMovieBooker.domain.entities.Reservation;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.UUID;

public interface IReservationService {
    Reservation save(Reservation reservation, HttpServletRequest request);
    Reservation findById(UUID id, HttpServletRequest request);
    List<Reservation> findAllByUser(HttpServletRequest request);
    public void deleteReservationById(UUID id, HttpServletRequest request);
}
