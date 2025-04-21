package com.example.JavaMovieBooker.application.services;

import com.example.JavaMovieBooker.application.ports.input.IUserService;
import com.example.JavaMovieBooker.domain.entities.User;
import com.example.JavaMovieBooker.infrastructure.adapters.output.persistence.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
