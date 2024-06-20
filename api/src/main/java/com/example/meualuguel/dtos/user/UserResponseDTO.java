package com.example.meualuguel.dtos.user;

import com.example.meualuguel.models.User;

public record UserResponseDTO(Long id, String name, String registry, String email, String phone, String address) {

    public UserResponseDTO(User user) {
        this(user.getId(), user.getName(), user.getRegistry(), user.getEmail(), user.getPhone(), user.getAddress());
    }
}
