package com.example.JavaMovieBooker.infrastructure.adapters.input.rest.dto;

public record CreateUserRequest(
        String email,
        String password,
        String firstName,
        String lastName
) {}