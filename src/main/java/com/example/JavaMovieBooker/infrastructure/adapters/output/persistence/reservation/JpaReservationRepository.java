package com.example.JavaMovieBooker.infrastructure.adapters.output.persistence.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface JpaReservationRepository extends JpaRepository<ReservationEntity, UUID> {
    List<ReservationEntity> findAllByUserId(UUID userId);
}
