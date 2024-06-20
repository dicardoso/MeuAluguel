package com.example.meualuguel.models;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "property_statuses")
@Entity(name = "property_statuses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PropertyStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean is_active;
}
