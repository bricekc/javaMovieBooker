package com.example.JavaMovieBooker.infrastructure.adapters.output.persistence.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaReservationRepository extends JpaRepository<ReservationEntity, String> {
}
