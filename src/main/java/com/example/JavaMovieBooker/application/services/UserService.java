package com.example.JavaMovieBooker.application.services;

import com.example.JavaMovieBooker.application.ports.input.IUserService;
import com.example.JavaMovieBooker.domain.entities.User;
import com.example.JavaMovieBooker.infrastructure.adapters.input.rest.dto.LoginRequest;
import com.example.JavaMovieBooker.infrastructure.adapters.output.persistence.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User user) {
        if (this.userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("User with this email already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }

    @Override
    public Boolean login(LoginRequest loginRequest) {
        Optional<User> user = userRepository.findByEmail(loginRequest.email());
        if (user.isPresent()) {
            return passwordEncoder.matches(loginRequest.password(), user.get().getPassword());
        }
        return false;
    }
}
