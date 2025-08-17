package com.example.meualuguel.models;

import com.example.meualuguel.dtos.contract.ContractRequestDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Future;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Table(name = "contracts")
@Entity(name = "contracts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "property_id", referencedColumnName = "id")
    private Property property;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User owner;

    @ManyToOne
    @JoinColumn(name = "renter_id", referencedColumnName = "id")
    private User renter;

    private LocalDate start_date;
    private LocalDate end_date;
    private LocalDate sign_date;
    @Min(value = 1)
    @Max(value = 31)
    private Integer maturity_date;

    @Min(value = 1, message = "value should be greater than 0")
    private double value;
    @Column(name = "is_active")
    private Boolean isActive;

    public Contract(ContractRequestDTO data, Property property, User owner, User renter, LocalDate end_date) {
        this.setProperty(property);
        this.setOwner(owner);
        this.setRenter(renter);
        this.setSign_date(data.sign_date());
        this.setStart_date(data.start_date());
        this.setEnd_date(end_date);
        this.setValue(data.value());
        this.setMaturity_date(data.maturity_date());
        this.setIsActive(true);
    }
}
