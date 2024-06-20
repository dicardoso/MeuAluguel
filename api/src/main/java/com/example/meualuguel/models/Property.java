package com.example.meualuguel.models;

import com.example.meualuguel.dtos.contract.ContractRequestDTO;
import com.example.meualuguel.dtos.property.PropertyRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Table(name = "properties")
@Entity(name = "properties")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "address is required")
    private String address;
    @NotNull(message = "Status ID is mandatory")
    private String number;
    private String complement;
    private String neighborhood;

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private PropertyType type;
    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private PropertyStatus status;
    private Boolean is_active;

    public Property(PropertyRequestDTO data, PropertyType type, PropertyStatus status) {
        this.address = data.address();
        this.complement = data.complement();
        this.neighborhood = data.neighborhood();
        this.number = data.number();
        this.type = type;
        this.status = status;
        this.is_active = data.is_active();
    }
}
