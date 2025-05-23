package com.example.JavaMovieBooker.application.ports.output;

import com.example.JavaMovieBooker.domain.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    Optional<User> findById(String id);
    Optional<User> findByEmail(String email);
    void save(User user);
    List<User> findAll();
}
