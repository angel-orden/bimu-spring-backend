package com.angelorden.bimu.user;

public record UserProfileResponse(
        Long id,
        String username,
        String email,
        String role
) {
}
