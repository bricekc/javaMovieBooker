package com.example.JavaMovieBooker.application.ports.input;

import com.example.JavaMovieBooker.domain.entities.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
}
