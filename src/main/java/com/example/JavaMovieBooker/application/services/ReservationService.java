package com.example.JavaMovieBooker.application.services;

import com.example.JavaMovieBooker.application.ports.input.IReservationService;
import com.example.JavaMovieBooker.domain.entities.Reservation;
import com.example.JavaMovieBooker.domain.entities.User;
import com.example.JavaMovieBooker.infrastructure.adapters.output.persistence.reservation.ReservationRepository;
import com.example.JavaMovieBooker.infrastructure.adapters.output.persistence.user.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReservationService implements IReservationService {
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final JwtUtilService jwtUtil;

    public ReservationService(ReservationRepository reservationRepository, UserRepository userRepository, JwtUtilService jwtUtil) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public Reservation save(Reservation reservation, HttpServletRequest request) {
        String jwt = jwtUtil.getJwtFromRequest(request);
        if (jwtUtil.validate(jwt)) {
            User user = userRepository.findByEmail(jwtUtil.getUserEmail(jwt)).orElseThrow(() -> new RuntimeException("User not found"));
            reservation.setUserId(user.getId());
            return reservationRepository.save(reservation);
        } else {
            throw new RuntimeException("Invalid token");
        }
    }

    @Override
    public Reservation findById(UUID id, HttpServletRequest request) {
        String jwt = jwtUtil.getJwtFromRequest(request);
        if (jwtUtil.validate(jwt)) {
            User user = userRepository.findByEmail(jwtUtil.getUserEmail(jwt)).orElseThrow(() -> new RuntimeException("User not found"));
            Reservation reservation = reservationRepository.findById(id);
            if (user.getId() != reservation.getUserId()) {
                throw new RuntimeException("You do not have permission to access this reservation");
            }
            return reservation;
        } else {
            throw new RuntimeException("Invalid token");
        }
    }

    @Override
    public List<Reservation> findAllByUser(HttpServletRequest request) {
        String jwt = jwtUtil.getJwtFromRequest(request);
        if (jwtUtil.validate(jwt)) {
            User user = userRepository.findByEmail(jwtUtil.getUserEmail(jwt)).orElseThrow(() -> new RuntimeException("User not found"));
            return reservationRepository.findAllByUserId(user.getId());
        } else {
            throw new RuntimeException("Invalid token");
        }
    }

    @Override
    public void deleteReservationById(UUID id, HttpServletRequest request) {
        String jwt = jwtUtil.getJwtFromRequest(request);
        if (jwtUtil.validate(jwt)) {
            User user = userRepository.findByEmail(jwtUtil.getUserEmail(jwt)).orElseThrow(() -> new RuntimeException("User not found"));
            Reservation reservation = reservationRepository.findById(id);
            if (user.getId() != reservation.getUserId()) {
                throw new RuntimeException("You do not have permission to delete this reservation");
            }
            reservationRepository.deleteReservationById(id);
        } else {
            throw new RuntimeException("Invalid token");
        }
    }
}
