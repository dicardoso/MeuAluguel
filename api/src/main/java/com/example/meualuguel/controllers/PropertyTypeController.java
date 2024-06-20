package com.example.meualuguel.controllers;

import com.example.meualuguel.dtos.propertyType.PropertyTypeResponseDTO;
import com.example.meualuguel.models.PropertyType;
import com.example.meualuguel.repositories.PropertyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("property-type")
public class PropertyTypeController {
    @Autowired
    private PropertyTypeRepository repository;
    @GetMapping
    public List<PropertyTypeResponseDTO> getAll() {
        return repository.findAll().stream().map(PropertyTypeResponseDTO::new).toList();
    }

    @GetMapping("/{property_type_id}")
    public Optional<PropertyType> getStatusById(@PathVariable Long property_type_id) {
        Optional<PropertyType> property_type = repository.findById(property_type_id);
        return property_type;
    }
}
