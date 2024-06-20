package com.example.meualuguel.services;

import com.example.meualuguel.models.Property;
import com.example.meualuguel.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    public Property update(Long id, Property property){
        return this.propertyRepository.save(property);
    }
}
