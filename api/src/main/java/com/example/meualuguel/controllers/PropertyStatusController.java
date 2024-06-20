package com.example.meualuguel.controllers;

import com.example.meualuguel.dtos.status.StatusResponseDTO;
import com.example.meualuguel.models.PropertyStatus;
import com.example.meualuguel.repositories.PropertyStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("status")
public class PropertyStatusController {
    @Autowired
    private PropertyStatusRepository repository;
    @GetMapping
    public List<StatusResponseDTO> getAll() {
        return repository.findAll().stream().map(StatusResponseDTO::new).toList();
    }

    @GetMapping("/{status_id}")
    public Optional<PropertyStatus> getStatusById(@PathVariable Long status_id) {
        Optional<PropertyStatus> status = repository.findById(status_id);
        return status;
    }
}
