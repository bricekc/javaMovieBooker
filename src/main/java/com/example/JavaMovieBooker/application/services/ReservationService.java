package com.example.JavaMovieBooker.application.services;

import com.example.JavaMovieBooker.application.ports.input.IReservationService;
import com.example.JavaMovieBooker.domain.entities.Reservation;
import com.example.JavaMovieBooker.infrastructure.adapters.output.persistence.reservation.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationService implements IReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation save(Reservation reservation) {
        System.out.println("Saving reservation: " + reservation);
        reservationRepository.save(reservation);
        return reservation;
    }
}
