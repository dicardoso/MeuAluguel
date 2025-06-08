package com.example.meualuguel.dtos.user;

import com.example.meualuguel.models.User;

public record UserResponseDTO(
        Long id,
        String name,
        String registry,
        String email,
        String phone,
        String address,
        Long profile_id,
        Boolean is_active
) {
    public UserResponseDTO(User user) {
        this(
                user.getId(),
                user.getName(),
                user.getRegistry(),
                user.getEmail(),
                user.getPhone(),
                user.getAddress(),
                user.getProfile() != null ? user.getProfile().getId() : null,
                user.getIs_active()
        );
    }
}
