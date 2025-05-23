package com.example.JavaMovieBooker.infrastructure.adapters.output.persistence.reservation;

import com.example.JavaMovieBooker.application.ports.output.IReservationRepository;
import com.example.JavaMovieBooker.domain.entities.Reservation;
import com.example.JavaMovieBooker.infrastructure.adapters.output.persistence.user.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ReservationRepository implements IReservationRepository {
    private final JpaReservationRepository jpaRepo;

    public ReservationRepository(JpaReservationRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public Reservation save(Reservation reservation) {
        ReservationEntity reservationEntity = jpaRepo.save(convertToEntity(reservation));
        return this.findById(reservationEntity.getId());
    }

    public Reservation findById(UUID id) {
        return jpaRepo.findById(id)
                .map(this::convertToDomain)
                .orElseThrow(() -> new IllegalArgumentException("Reservation not found"));
    }

    public List<Reservation> findAllByUserId(UUID id) {
        return jpaRepo.findAllByUserId(id).stream().map(this::convertToDomain).toList();
    }

    public void deleteReservationById(UUID id) {
        jpaRepo.deleteById(id);
    }

    private Reservation convertToDomain(ReservationEntity reservationEntity) {
        return new Reservation(
                reservationEntity.getId(),
                reservationEntity.getMovieId(),
                reservationEntity.getReservationDate(),
                reservationEntity.getUser().getId()
        );
    }

    private ReservationEntity convertToEntity(Reservation reservation) {
        ReservationEntity entity = new ReservationEntity();
        entity.setId(reservation.getId());
        entity.setMovieId(reservation.getMovieId());
        entity.setReservationDate(reservation.getReservationDate());

        UserEntity user = new UserEntity();
        user.setId(reservation.getUserId());
        entity.setUser(user);

        return entity;
    }

}
