package com.example.meualuguel.controllers;

import com.example.meualuguel.dtos.property.PropertyRequestDTO;
import com.example.meualuguel.dtos.property.PropertyResponseDTO;
import com.example.meualuguel.exceptions.ResourceNotFoundException;
import com.example.meualuguel.models.Property;
import com.example.meualuguel.models.PropertyStatus;
import com.example.meualuguel.models.PropertyType;
import com.example.meualuguel.repositories.PropertyRepository;
import com.example.meualuguel.repositories.PropertyStatusRepository;
import com.example.meualuguel.repositories.PropertyTypeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("property")
public class PropertyController {

    @Autowired
    private PropertyRepository repository;
    @Autowired
    private PropertyStatusRepository propertyStatusRepository;
    @Autowired
    private PropertyTypeRepository propertyTypeRepository;

    @GetMapping
    public List<PropertyResponseDTO> getAll() {
        return repository.findAll().stream().map(PropertyResponseDTO::new).toList();
    }

    @GetMapping("/{property_id}")
    public Optional<Property> getPropertyById(@PathVariable Long property_id) {
        return repository.findById(property_id);
    }

    @PostMapping
    public void saveProperty(@RequestBody PropertyRequestDTO data) {
        PropertyStatus status = propertyStatusRepository.findById(data.status_id())
                .orElseThrow(() -> new ResourceNotFoundException("status_id not found"));
        PropertyType type = propertyTypeRepository.findById(data.type_id())
                .orElseThrow(() -> new ResourceNotFoundException("type_id not found"));
        Property newProperty = new Property(data, type, status);
        repository.save(newProperty);
    }

    @PutMapping("/{property_id}")
    public ResponseEntity<Property> updateProperty(@PathVariable long property_id, @RequestBody PropertyRequestDTO data) {
        Property updateProperty = repository.findById(property_id)
                .orElseThrow(() -> new ResourceNotFoundException("property_id not found"));
        PropertyStatus status = propertyStatusRepository.findById(data.status_id())
                .orElseThrow(() -> new ResourceNotFoundException("status_id not found"));
        PropertyType type = propertyTypeRepository.findById(data.type_id())
                .orElseThrow(() -> new ResourceNotFoundException("type_id not found"));

        updateProperty.setAddress(data.address());
        updateProperty.setComplement(data.complement());
        updateProperty.setStatus(status);
        updateProperty.setType(type);
        updateProperty.setNumber(data.number());
        updateProperty.setIs_active(data.is_active());

        repository.save(updateProperty);

        return ResponseEntity.ok(updateProperty);
    }

}
