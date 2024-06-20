package com.example.meualuguel.dtos.property;

import com.example.meualuguel.dtos.propertyStatus.PropertyStatusResponseDTO;
import com.example.meualuguel.dtos.propertyType.PropertyTypeResponseDTO;
import com.example.meualuguel.models.Property;
import com.example.meualuguel.models.PropertyStatus;

public record PropertyResponseDTO(Long id, String address, String complement, String number, PropertyTypeResponseDTO type, PropertyStatusResponseDTO status, Boolean is_active) {
    public PropertyResponseDTO(Property property) {
        this(
                property.getId(),
                property.getAddress(),
                property.getComplement(),
                property.getNumber(),
                new PropertyTypeResponseDTO(property.getType()),
                new PropertyStatusResponseDTO(property.getStatus()),
                property.getIs_active()
        );
    }
}
