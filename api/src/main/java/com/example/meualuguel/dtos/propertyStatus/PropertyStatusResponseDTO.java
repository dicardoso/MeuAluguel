package com.example.meualuguel.dtos.propertyStatus;

import com.example.meualuguel.models.PropertyStatus;

public record PropertyStatusResponseDTO(Long id, String name, Boolean is_active) {

    public PropertyStatusResponseDTO(PropertyStatus property_status) {
        this(property_status.getId(), property_status.getName(), property_status.getIs_active());
    }

}
