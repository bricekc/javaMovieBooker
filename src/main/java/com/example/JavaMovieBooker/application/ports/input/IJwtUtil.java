package com.example.JavaMovieBooker.application.ports.input;

import jakarta.servlet.http.HttpServletRequest;

public interface IJwtUtil {
    String generateAccessToken(String userEmail);
    boolean validate(String token);
    String getUserEmail(String token);
    String getJwtFromRequest(HttpServletRequest request);
}
