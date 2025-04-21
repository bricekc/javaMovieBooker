package com.example.JavaMovieBooker.application.ports.output;

import com.example.JavaMovieBooker.domain.entities.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(String id);
    void save(User user);
}
