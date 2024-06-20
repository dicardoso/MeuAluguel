package com.example.meualuguel.dtos.property;

import com.example.meualuguel.models.Property;
import com.example.meualuguel.models.PropertyStatus;
import com.example.meualuguel.models.PropertyType;

public record PropertyRequestDTO(String address, String complement, String neighborhood, String number, Long type_id, Long status_id, Boolean is_active) {
    public PropertyRequestDTO(Property property) {
        this(
                property.getAddress(),
                property.getComplement(),
                property.getNeighborhood(),
                property.getNumber(),
                property.getType().getId(),
                property.getStatus().getId(),
                property.getIs_active()
        );
    }
}
