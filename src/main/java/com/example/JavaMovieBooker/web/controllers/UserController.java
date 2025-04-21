package com.example.JavaMovieBooker.web.controllers;

import com.example.JavaMovieBooker.application.services.UserService;
import com.example.JavaMovieBooker.domain.entities.User;
import com.example.JavaMovieBooker.web.dtos.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "Users", description = "Users API")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "List all Users")
    @GetMapping("")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> dtos = userService.getAllUsers()
                .stream()
                .map(UserDTO::fromDomain)
                .toList();

        return ResponseEntity.ok().body(dtos);
    }

    @Operation(summary = "Get User by ID")
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String id) {
        return userService.getUserById(id)
                .map(UserDTO::fromDomain)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
