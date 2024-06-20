package com.example.meualuguel.dtos.status;

import com.example.meualuguel.models.PropertyStatus;

public record StatusResponseDTO(Long id, String name, Boolean is_active) {

    public StatusResponseDTO(PropertyStatus status) {
        this(status.getId(), status.getName(), status.getIs_active());
    }
}
