package com.example.meualuguel.repositories;

import com.example.meualuguel.models.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
