package com.example.JavaMovieBooker.web.controllers;

import com.example.JavaMovieBooker.application.services.UserService;
import com.example.JavaMovieBooker.domain.entities.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "Movie Booker", description = "Movie Booker API")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "List all Users")
    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }
}
