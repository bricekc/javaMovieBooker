package com.example.JavaMovieBooker.infrastructure.adapters.output.persistence.reservation;

import com.example.JavaMovieBooker.application.ports.output.IReservationRepository;
import com.example.JavaMovieBooker.domain.entities.Reservation;
import com.example.JavaMovieBooker.infrastructure.adapters.output.persistence.user.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository implements IReservationRepository {
    private final JpaReservationRepository jpaRepo;

    public ReservationRepository(JpaReservationRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public void save(Reservation reservation) {
        ReservationEntity r = jpaRepo.save(convertToEntity(reservation));
        System.out.println("Saved reservation: " + r);
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
