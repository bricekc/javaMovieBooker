package com.example.JavaMovieBooker.web.controllers;

import com.example.JavaMovieBooker.application.services.UserService;
import com.example.JavaMovieBooker.domain.entities.User;
import com.example.JavaMovieBooker.infrastructure.adapters.input.rest.dto.CreateUserRequest;
import com.example.JavaMovieBooker.web.dtos.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth", description = "Authentication API")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Register a new user")
    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody CreateUserRequest request) {
        User user = new User(
                request.email(),
                request.password(),
                request.firstName(),
                request.lastName()
        );
        this.userService.createUser(user);
        return ResponseEntity.ok(UserDTO.fromDomain(user));
    }
}
