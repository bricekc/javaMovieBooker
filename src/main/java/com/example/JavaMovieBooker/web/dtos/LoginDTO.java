package com.example.JavaMovieBooker.web.dtos;

public class LoginDTO {
    public String token;

    public LoginDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static LoginDTO fromDomain(String token) {
        return new LoginDTO(
                token
        );
    }
}
