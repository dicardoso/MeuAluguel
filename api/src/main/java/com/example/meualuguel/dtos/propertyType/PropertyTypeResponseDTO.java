package com.example.meualuguel.dtos.propertyType;

import com.example.meualuguel.models.PropertyType;

public record PropertyTypeResponseDTO(Long id, String name, Boolean is_active) {

    public PropertyTypeResponseDTO(PropertyType property_type) {
        this(property_type.getId(), property_type.getName(), property_type.getIs_active());
    }

}
