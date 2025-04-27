package com.example.JavaMovieBooker.web.controllers;

import com.example.JavaMovieBooker.application.services.ReservationService;
import com.example.JavaMovieBooker.domain.entities.Reservation;
import com.example.JavaMovieBooker.infrastructure.adapters.input.rest.dto.CreateReservationRequest;
import com.example.JavaMovieBooker.web.dtos.ReservationDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @Operation(
            summary = "Create a reservation",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping("")
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody CreateReservationRequest request) {
        Reservation reservation = new Reservation(
                request.movieId(),
                request.reservationDate(),
                request.userId()
        );
        try {
            Reservation newReservation = this.reservationService.save(reservation);
            return ResponseEntity.ok(ReservationDTO.fromDomain(newReservation));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid reservation data", e);
        }
    }
}
