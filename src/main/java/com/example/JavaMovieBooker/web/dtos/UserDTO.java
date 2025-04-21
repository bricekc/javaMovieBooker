package com.example.JavaMovieBooker.web.dtos;

import com.example.JavaMovieBooker.domain.entities.User;

import java.util.UUID;

public class UserDTO {
    private UUID id;
    private String email;
    private String firstName;
    private String lastName;

    public UserDTO() {}

    public UserDTO(UUID id, String email, String firstName, String lastName) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static UserDTO fromDomain(User user) {
        return new UserDTO(user.getId(), user.getEmail(), user.getFirstName(), user.getLastName());
    }

}
