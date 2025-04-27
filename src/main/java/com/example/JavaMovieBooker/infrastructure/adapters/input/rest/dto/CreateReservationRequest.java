package com.example.JavaMovieBooker.infrastructure.adapters.input.rest.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateReservationRequest(
    Long movieId,
    LocalDateTime reservationDate,
    UUID userId
) {}
