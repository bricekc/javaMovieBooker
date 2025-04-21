package com.example.JavaMovieBooker.application.ports.input;

import com.example.JavaMovieBooker.domain.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAllUsers();
    Optional<User> getUserById(String id);
    User createUser(User user);
}
