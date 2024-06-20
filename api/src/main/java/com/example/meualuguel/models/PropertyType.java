package com.example.meualuguel.models;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "property_types")
@Entity(name = "property_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PropertyType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean is_active;
}

