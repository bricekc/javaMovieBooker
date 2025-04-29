package com.example.JavaMovieBooker.web.controllers;

import com.example.JavaMovieBooker.application.services.ReservationService;
import com.example.JavaMovieBooker.domain.entities.Reservation;
import com.example.JavaMovieBooker.infrastructure.adapters.input.rest.dto.CreateReservationRequest;
import com.example.JavaMovieBooker.web.dtos.ReservationDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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
    public ResponseEntity<ReservationDTO> createReservation(
            @RequestBody CreateReservationRequest createReservationRequest,
            HttpServletRequest request
    ) {
        Reservation reservation = new Reservation(
                createReservationRequest.movieId(),
                createReservationRequest.reservationDate()
        );
        try {
            Reservation newReservation = this.reservationService.save(reservation, request);
            return ResponseEntity.ok(ReservationDTO.fromDomain(newReservation));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid reservation data", e);
        }
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get one reservation",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    public ResponseEntity<ReservationDTO> findOneReservation(
            @PathVariable UUID id,
            HttpServletRequest request
    ) {
        Reservation reservation = this.reservationService.findById(id, request);
        return ResponseEntity.ok(ReservationDTO.fromDomain(reservation));
    }
}
